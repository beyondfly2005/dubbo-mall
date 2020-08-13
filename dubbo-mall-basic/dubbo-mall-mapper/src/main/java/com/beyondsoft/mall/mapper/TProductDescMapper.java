package com.beyondsoft.mall.mapper;

import com.beyondsoft.mall.entity.TProductDesc;

public interface TProductDescMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TProductDesc record);

    int insertSelective(TProductDesc record);

    TProductDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TProductDesc record);

    int updateByPrimaryKeyWithBLOBs(TProductDesc record);

    int updateByPrimaryKey(TProductDesc record);
}