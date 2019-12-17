package com.xlt.myproject.service.api;

import com.xlt.myproject.model.Page;
import com.xlt.myproject.model.Supplier;
import com.xlt.myproject.model.SupplierResponse;

public interface IsupplierService {
    /**
     * 分页查找供应商信息
     * @param supplier 查询条件
     * @param page 分页参数
     * @return 返回查询结果
     */
    SupplierResponse findSupplierPageList(Supplier supplier, Page page);

    /**
     * 根据ID删除供应商
     * @param id id
     * @return 返回删除结果
     */
    SupplierResponse deleteSupplierById(Long id);

    /**
     * 新增新的供应商
     * @param supplier 新供应商信息
     * @return 返回新增结果
     */
    SupplierResponse addSupplier(Supplier supplier);

    /**
     * 更新供应商信息
     * @param supplier 供应商最新信息
     * @return 返回更新结果
     */
    SupplierResponse updateSupplier(Supplier supplier);
}
