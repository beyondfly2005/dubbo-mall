package com.beyondsoft.mall.mapper;

import com.beyondsoft.mall.entity.TProductType;

public interface TProductTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TProductType record);

    int insertSelective(TProductType record);

    TProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TProductType record);

    int updateByPrimaryKey(TProductType record);
}