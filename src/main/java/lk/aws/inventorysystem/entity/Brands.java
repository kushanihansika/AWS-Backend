package lk.aws.inventorysystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brands extends SuperEntity{
    @Id
    private String brandId;
    private String brand_Name;


    @OneToMany(mappedBy = "brands", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Item_brand> item_brands  = new ArrayList<>();

    public Brands() {
    }

    public Brands(String brandId, String brand_Name) {
        this.brandId = brandId;
        this.brand_Name = brand_Name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrand_Name() {
        return brand_Name;
    }

    public void setBrand_Name(String brand_Name) {
        this.brand_Name = brand_Name;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "brandId='" + brandId + '\'' +
                ", brand_Name='" + brand_Name + '\'' +
                '}';
    }


    public List<Item_brand> getItem_brands() {
        return item_brands;
    }

    public void setItem_brands(List<Item_brand> item_brands) {
        this.item_brands = item_brands;
    }
}
