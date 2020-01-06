package lk.aws.inventorysystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PurchaseOrder extends  SuperEntity {
@Id
private String Po_id;
private String date;
private String status;

    @OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Stock> stocks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="supplierId", referencedColumnName = "sup_id")
    private Supplier supplier;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String po_id, String date, String status) {
        Po_id = po_id;
        this.date = date;
        this.status = status;
    }

    public PurchaseOrder(String po_id, String date) {
        Po_id = po_id;
        this.date = date;

    }

    public String getPo_id() {
        return Po_id;
    }

    public void setPo_id(String po_id) {
        Po_id = po_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "Po_id='" + Po_id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", stocks=" + stocks +
                ", supplier=" + supplier +
                '}';
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        this.getStocks().add(stock);
        stock.setPurchaseOrder(this);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
