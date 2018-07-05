package com.lgw.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgw.base.BaseMapper;
import com.lgw.biz.CommonBiz;

import java.util.List;

public abstract class CommonBizImpl<T,E,ID> implements CommonBiz<T,E,ID> {

    private BaseMapper baseMapper;

    public BaseMapper getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public long countByExample(E example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(E example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(ID cid) {
        return baseMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public PageInfo<T> selectByExample(E example, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<T> dataList= baseMapper.selectByExample(example);
        PageInfo page = new PageInfo(dataList);
        return page;
    }

    /**
     * 分页
     * @param example
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<T> selectByExampleWithBLOBs(E example, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<T> dataList= baseMapper.selectByExampleWithBLOBs(example);
        PageInfo page = new PageInfo(dataList);
        return page;
    }

    /**
     * 查询所有
     * @param example
     * @return
     */
    @Override
    public List<T> selectByExample(E example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> selectByExampleWithBLOBs(E example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public T selectByPrimaryKey(String cid) {
        return (T) baseMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByExampleSelective(T record, E example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(T record, E example) {
        return baseMapper.updateByExample( record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective( record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey( record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return baseMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByExampleWithBLOBs(T record, E example) {
        return baseMapper.updateByExampleWithBLOBs(record, example);
    }
}
