package com.lgw;

import java.util.*;

public class ParamBean<T> {
    private List<T> dataList =new ArrayList<>();
    private Set<T> dataSet=new HashSet<>();
    private Map<String,T> dataMap=new HashMap<>();

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Set<T> getDataSet() {
        return dataSet;
    }

    public void setDataSet(Set<T> dataSet) {
        this.dataSet = dataSet;
    }

    public Map<String, T> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, T> dataMap) {
        this.dataMap = dataMap;
    }
}
