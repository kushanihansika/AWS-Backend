package lk.aws.inventorysystem.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SupplierItemPK implements Serializable {

    private String supplier_Id;
    private String itemCode;

    public SupplierItemPK() {
    }

    public SupplierItemPK(String supplier_Id, String itemCode) {
        this.supplier_Id = supplier_Id;
        this.itemCode = itemCode;
    }



    public String getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(String supplier_Id) {
        this.supplier_Id = supplier_Id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
