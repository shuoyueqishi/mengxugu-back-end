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
import org.springframework.util.CollectionUtils;

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
        logger.info("SupplierServiceImpl.deleteSupplierById input id="+id);
        SupplierResponse response = new SupplierResponse();
        try {
            supplierDao.deleteSupplierById(id);
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage("Delete supplier successfully whose id is "+id);
        } catch (ApplicationException e) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Delete supplier failed whose id is "+id);
            logger.error("Delete supplier failed whose id is "+id);
            logger.error(e);
        }
        return response;
    }

    @Override
    public SupplierResponse addSupplier(Supplier supplier) {
        logger.info("SupplierServiceImpl.addSupplier input info:"+supplier);
        SupplierResponse response = new SupplierResponse();
        try {
            List<Supplier> list = supplierDao.findSupplierByCodeAndName(supplier);
            if (!CollectionUtils.isEmpty(list)) {
                logger.error("supplierCode:"+supplier.getCode()+",supplierName:"+supplier.getName()+" has existed in system. Don't add it again.");
                response.setStatus(Constant.Status.FAIL);
                response.setMessage("supplierCode:"+supplier.getCode()+",supplierName:"+supplier.getName()+" has existed in system. Don't add it again.");
                return response;
            }
            int row  = supplierDao.addSupplier(supplier);
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage("Add supplier successfully. "+row+" Added");
        } catch (ApplicationException e) {
            logger.error("Add supplier failed, error info:",e);
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Add supplier failed.");
        }
        return response;
    }

    @Override
    public SupplierResponse updateSupplier(Supplier supplier) {
        SupplierResponse response = new SupplierResponse();
        if (supplier.getId() == null) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Id can't be empty for updating supplier info.");
            return response;
        }
        try {
            supplierDao.updateSupplier(supplier);
            response.setMessage("update supplier info successfully.");
            response.setStatus(Constant.Status.SUCCESS);
        } catch(ApplicationException e) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("update database encounter error.");
            logger.error("update database encounter error:",e);
        }
        return response;
    }
}
