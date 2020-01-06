package lk.aws.inventorysystem.controller;


import lk.aws.inventorysystem.dto.SupplierDTO;
import lk.aws.inventorysystem.service.custom.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/suppliers")
@RestController
public class SupplierController {

@Autowired
private SupplierService supplierService;


    @GetMapping(params = {"page","size"})
    public ResponseEntity<PagedResources<SupplierDTO>> getCustomersPage(int page, int size, PagedResourcesAssembler assembler){
        Page<SupplierDTO> supplierPage = supplierService.getSupplierPage(page, size);
        return new ResponseEntity<>(assembler.toResource(supplierPage),HttpStatus.OK);
    }


   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<SupplierDTO>> getAllSuppliers(){
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("X-Count",supplierService.supplierCount() +"");
       httpHeaders.setAccessControlAllowHeaders(Arrays.asList("X-Count"));
       httpHeaders.setAccessControlExposeHeaders(Arrays.asList("X-Count"));


       return new ResponseEntity<List<SupplierDTO>>(supplierService.getAllSuppliers(),httpHeaders, HttpStatus.OK);
   }

    @GetMapping(value = "/{sup_id:C\\d{3}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable("sup_id") String sup_id){
       SupplierDTO dto = null;
       if(supplierService.isSuppplierExists(sup_id)){
           dto = supplierService.getSupplierById(sup_id);
       }
       return new ResponseEntity<SupplierDTO>(dto,(dto !=null)?HttpStatus.OK:HttpStatus.NOT_FOUND);
     }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveSuppliers(@RequestBody SupplierDTO supplier) {

        if (supplier.getSup_id().isEmpty() || supplier.getSup_name().isEmpty() || supplier.getSup_address().isEmpty()||supplier.getSup_telephone().isEmpty()) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } else {
            String supplierId = supplierService.saveSuppliers(supplier);
            return new ResponseEntity<String>("\"" + supplierId + "\"", HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/{sup_id:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable("sup_id") String sup_id, @RequestBody SupplierDTO supplier) {
        if (!supplierService.isSuppplierExists(sup_id)) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (supplier.getSup_name().isEmpty() || supplier.getSup_address().isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } else {
            supplier.setSup_id(sup_id);
            supplierService.updateSuppliers(supplier);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

}
