package lk.aws.inventorysystem.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class SupplierItem implements Serializable {

    @EmbeddedId
    private SupplierItemPK supplierItemPK;

    @ManyToOne
    @JoinColumn(name="supplier_Id",referencedColumnName = "sup_id",insertable = false,updatable = false)
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name="itemCode",referencedColumnName = "code",insertable = false, updatable = false)
    private Item item;

    public SupplierItem() {
    }

    public SupplierItem(SupplierItemPK supplierItemPK) {
        this.supplierItemPK = supplierItemPK;
    }
    public SupplierItem(String supplier_Id,String itemCode) {
        this.supplierItemPK = new SupplierItemPK(supplier_Id,itemCode);
    }

    public SupplierItemPK getSupplierItemPK() {
        return supplierItemPK;
    }

    public void setSupplierItemPK(SupplierItemPK supplierItemPK) {
        this.supplierItemPK = supplierItemPK;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Item getItem() {
        return item;
    }

}
