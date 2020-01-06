package lk.aws.inventorysystem.service.custom.impl;


import lk.aws.inventorysystem.dto.SupplierDTO;
import lk.aws.inventorysystem.entity.Supplier;
import lk.aws.inventorysystem.repository.SupplierRepository;
import lk.aws.inventorysystem.service.custom.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


    @Override
    public Page<SupplierDTO> getSupplierPage(int page, int size) {
        return null;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        final List<SupplierDTO> suppliers = supplierRepository.findAll().stream().map(supplier -> new SupplierDTO(supplier.getSup_id(), supplier.getSup_name(), supplier.getSup_adddress(), supplier.getSup_telephone())).collect(Collectors.toList());
        return suppliers;
    }

    @Override
    public String saveSuppliers(SupplierDTO dto) {

         if(supplierRepository.existsById(dto.getSup_id())){
             throw new RuntimeException("Supplier already exists");
         }
        return supplierRepository.save(new Supplier(dto.getSup_id(),dto.getSup_name(),dto.getSup_address(),dto.getSup_telephone())).getSup_id();
    }

    @Override
    public void updateSuppliers(SupplierDTO dto) {
        supplierRepository.save(new Supplier(dto.getSup_id(),dto.getSup_name(),dto.getSup_address(),dto.getSup_telephone()));
    }

    @Override
    public void removeSuppliers(String sup_id) {

    }

    @Override
    public SupplierDTO getSupplierById(String sup_id) {
        Supplier supplier = supplierRepository.getOne(sup_id);
        SupplierDTO supplierDTO = new SupplierDTO(supplier.getSup_id(),supplier.getSup_name(),supplier.getSup_adddress(),supplier.getSup_adddress());
        return supplierDTO;
    }

    @Override
    public boolean isSuppplierExists(String sup_id) {
        return supplierRepository.existsById(sup_id);
    }

    @Override
    public long supplierCount() {
        return 0;
    }
}
