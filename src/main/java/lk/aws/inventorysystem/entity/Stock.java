package lk.aws.inventorysystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock extends SuperEntity{
    @Id
    private String st_id;
    private String code;
    private String description;
    private String byingPrice;
    private String sellingPrice;

    @OneToMany(mappedBy = "stock", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

   @ManyToOne
   @JoinColumn(name="stockId",referencedColumnName = "Po_id")
   private PurchaseOrder purchaseOrder;

    public Stock() {
    }

    public Stock(String st_id, String code, String description, String byingPrice, String sellingPrice) {
        this.st_id = st_id;
        this.code = code;
        this.description = description;
        this.byingPrice = byingPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getByingPrice() {
        return byingPrice;
    }

    public void setByingPrice(String byingPrice) {
        this.byingPrice = byingPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "st_id='" + st_id + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", byingPrice='" + byingPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                '}';
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.getItems().add(item);
        item.setStock(this);
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
