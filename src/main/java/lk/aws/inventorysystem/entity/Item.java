package lk.aws.inventorysystem.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//
@Entity
public class Item extends SuperEntity{

    @Id
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;

    @ManyToOne
    @JoinColumn(name="stockId",referencedColumnName = "st_id")
    private Stock stock;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Item_brand> item_brands  = new ArrayList<>();


    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<SupplierItem> supplierItems = new ArrayList<>();





  //@OneToMany (mappedBy = "item",fetch = FetchType.LAZY)
  //private List<OrderDetail> orderDetails = new ArrayList<>();

    //@OneToMany(mappedBy = "item" ,FetchType.LAZY)


    public Item() {
    }

    public Item(String code, String description, double unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }


    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Item_brand> getItem_brands() {
        return item_brands;
    }

    public void setItem_brands(List<Item_brand> item_brands) {
        this.item_brands = item_brands;
    }


    public List<SupplierItem> getSupplierItems() {
        return supplierItems;
    }

    public void setSupplierItems(List<SupplierItem> supplierItems) {
        this.supplierItems = supplierItems;
    }

}
