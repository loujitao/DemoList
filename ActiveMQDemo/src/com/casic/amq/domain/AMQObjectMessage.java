package com.casic.amq.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AMQObjectMessage implements Serializable {

    private static final long serialVersionUID = -526324944915280689L;

    private List<Produce> produces=new ArrayList<Produce>();

    public List<Produce> getProduces() {
        return produces;
    }

    public void setProduces(List<Produce> produces) {
        this.produces = produces;
    }
}
