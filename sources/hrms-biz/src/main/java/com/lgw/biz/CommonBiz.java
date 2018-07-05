package com.lgw.biz;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonBiz<T,E,ID> {
    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(ID cid);

    int insert(T record);

    int insertSelective(T record);

    PageInfo<T> selectByExample(E example, int pageIndex, int pageSize);

    PageInfo<T> selectByExampleWithBLOBs(E example, int pageIndex, int pageSize);

    List<T> selectByExample(E example );

    List<T> selectByExampleWithBLOBs(E example );

    T selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);
}
