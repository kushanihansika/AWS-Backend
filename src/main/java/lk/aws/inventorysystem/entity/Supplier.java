package lk.aws.inventorysystem.entity;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Supplier extends SuperEntity{

    @Id
    private String sup_id;
    private String sup_name;
    private String sup_adddress;
    private String sup_telephone;

    @OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();


    @OneToMany(mappedBy = "supplier", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<SupplierItem> supplierItems = new ArrayList<>();


    public Supplier() {
    }

    public Supplier(String sup_id, String sup_name, String sup_adddress, String sup_telephone) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_adddress = sup_adddress;
        this.sup_telephone = sup_telephone;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_adddress() {
        return sup_adddress;
    }

    public void setSup_adddress(String sup_adddress) {
        this.sup_adddress = sup_adddress;
    }

    public String getSup_telephone() {
        return sup_telephone;
    }

    public void setSup_telephone(String sup_telephone) {
        this.sup_telephone = sup_telephone;
    }


    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public void addPurchase(PurchaseOrder purchaseOrder) {
        this.getPurchaseOrders().add(purchaseOrder);
        purchaseOrder.setSupplier(this);
    }

    public List<SupplierItem> getSupplierItems() {
        return supplierItems;
    }

    public void setSupplierItems(List<SupplierItem> supplierItems) {
        this.supplierItems = supplierItems;
    }
}
