package com.lgw.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T,E,ID>  {

    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(ID cid);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    List<T> selectByExampleWithBLOBs(E example);

    T selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

}
