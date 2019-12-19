package com.xlt.myproject.mapper;

import com.xlt.myproject.model.Page;
import com.xlt.myproject.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="IsupplierDao")
public interface IsupplierDao {
    List<Supplier> findSupplierPageList(@Param("supplier")Supplier supplier,@Param("page") Page page) throws ApplicationException;
    int findSupplierPageListCount(@Param("supplier")Supplier supplier)throws ApplicationException;
    int deleteSupplierById(@Param("id")Long id) throws ApplicationException;
    int updateSupplier(@Param("supplier")Supplier supplier)throws ApplicationException;
    int addSupplier(@Param("supplier")Supplier supplier)throws ApplicationException;
}
