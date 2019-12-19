package com.xlt.myproject.service.impl;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.mapper.IsupplierDao;
import com.xlt.myproject.model.Page;
import com.xlt.myproject.model.Supplier;
import com.xlt.myproject.model.SupplierResponse;
import com.xlt.myproject.service.api.IsupplierService;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplierService")
@MapperScan("com.xlt.myproject.mapper")
public class SupplierServiceImpl implements IsupplierService {
    private static Logger logger = Logger.getLogger(SupplierServiceImpl.class);

    @Autowired
    private IsupplierDao supplierDao;

    @Override
    public SupplierResponse findSupplierPageList(Supplier supplier, Page page) {
        logger.info("SupplierServiceImpl.findSupplierPageList input info:"+supplier);
        SupplierResponse response = new SupplierResponse();
        try {
            int totals = supplierDao.findSupplierPageListCount(supplier);
            page.setTotal(totals);
            int totalPages = page.getTotalPages();
            logger.info("totalPages="+totalPages);
            List<Supplier> list = supplierDao.findSupplierPageList(supplier,page);
            response.setResult(list);
            response.setPage(page);
            response.setCode("success");
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage(list.size()+" suppliers infos has found in this query.");
        } catch (ApplicationException e) {
            logger.error("find supplier infos failed, error info:",e);
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("find supplier infos failed");
        }
        return response;
    }

    @Override
    public SupplierResponse deleteSupplierById(Long id) {
        return null;
    }

    @Override
    public SupplierResponse addSupplier(Supplier supplier) {
        return null;
    }

    @Override
    public SupplierResponse updateSupplier(Supplier supplier) {
        return null;
    }
}
