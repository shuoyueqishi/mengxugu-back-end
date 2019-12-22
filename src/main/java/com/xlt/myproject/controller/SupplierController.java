package com.xlt.myproject.controller;

import com.xlt.myproject.model.Page;
import com.xlt.myproject.model.Supplier;
import com.xlt.myproject.model.SupplierResponse;
import com.xlt.myproject.service.impl.SupplierServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value="supplierController")
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImpl supplierService;

    @RequestMapping(value = "/list/{pageSize}/{currentPage}", method = RequestMethod.GET, produces="application/json")
    public SupplierResponse getSupplierPageList(@Param("supplier") Supplier supplier, @PathVariable("pageSize")int pageSize, @PathVariable("currentPage") int currentPage) {
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        return supplierService.findSupplierPageList(supplier,page);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
    public SupplierResponse deleteSupplier(@PathVariable("id")Long id) {
        return supplierService.deleteSupplierById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json")
    public SupplierResponse updateSupplier(@RequestBody()Supplier supplier) {
        return supplierService.updateSupplier(supplier);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces="application/json")
    public SupplierResponse addSupplier(@RequestBody()Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }
}
