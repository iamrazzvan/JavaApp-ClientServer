package com.model.model;

import java.io.Serializable;

public class Identifiable<ID> implements Serializable {
    private ID id;

    public ID getID() {
        return id;
    }

    public void setID(ID newID) {
        id = newID;
    }
}
