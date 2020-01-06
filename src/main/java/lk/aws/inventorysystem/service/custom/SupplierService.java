package lk.aws.inventorysystem.service.custom;

import lk.aws.inventorysystem.dto.SupplierDTO;
import lk.aws.inventorysystem.service.SuperService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService extends SuperService {


    Page<SupplierDTO> getSupplierPage(int page, int size);

    List<SupplierDTO> getAllSuppliers();

    String saveSuppliers(SupplierDTO dto);

    void updateSuppliers(SupplierDTO dto);

    void removeSuppliers(String sup_id);

    SupplierDTO getSupplierById(String sup_id);

    boolean isSuppplierExists(String sup_id);

    long supplierCount();

}
