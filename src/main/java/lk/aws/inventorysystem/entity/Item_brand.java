package lk.aws.inventorysystem.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Item_brand implements Serializable {

   @EmbeddedId
   private Item_brandPK item_brandPK;

    @ManyToOne
    @JoinColumn(name="brand_Id", referencedColumnName = "brandId",insertable = false,updatable = false)
    private Brands brands;
    @ManyToOne
    @JoinColumn(name="itemCode",referencedColumnName = "code",insertable = false, updatable = false)
    private Item item;


    public Item_brand() {
    }

    public Item_brand(Item_brandPK item_brandPK) {
        this.item_brandPK = item_brandPK;
    }

    public Item_brand(String brand_Id,String itemCode) {
        this.item_brandPK = new Item_brandPK(brand_Id,itemCode);
    }


    public Item_brandPK getItem_brandPK() {
        return item_brandPK;
    }

    public void setItem_brandPK(Item_brandPK item_brandPK) {
        this.item_brandPK = item_brandPK;
    }


    public Brands getBrands() {
        return brands;
    }

    public Item getItem() {
        return item;
    }


}
