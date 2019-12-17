package com.xlt.myproject.mapper;

import com.xlt.myproject.model.Page;
import com.xlt.myproject.model.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IsupplierDao {
    List<Supplier> findSupplierPageList(@Param("supplier")Supplier supplier,@Param("page") Page page);
    int findSupplierPageListCount(@Param("supplier")Supplier supplier);
}
