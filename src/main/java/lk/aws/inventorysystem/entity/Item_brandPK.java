package lk.aws.inventorysystem.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Item_brandPK implements Serializable {

    private String brand_Id;
    private String itemCode;

    public Item_brandPK() {
    }

    public Item_brandPK(String brand_Id, String itemCode) {
        this.brand_Id = brand_Id;
        this.itemCode = itemCode;
    }

    public String getBrand_Id() {
        return brand_Id;
    }

    public void setBrand_Id(String brand_Id) {
        this.brand_Id = brand_Id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
