package lk.aws.inventorysystem.dto;

public class SupplierDTO {

    private String sup_id;
    private String sup_name;
    private String sup_address;
    private String sup_telephone;

    public SupplierDTO() {
    }

    public SupplierDTO(String sup_id, String sup_name, String sup_address, String sup_telephone) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_address = sup_address;
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

    public String getSup_address() {
        return sup_address;
    }

    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }

    public String getSup_telephone() {
        return sup_telephone;
    }

    public void setSup_telephone(String sup_telephone) {
        this.sup_telephone = sup_telephone;
    }
}
