package com.playerplanet.core.model.attribute;


import java.util.Map;

public interface Attribute {

    public void setAttribute(String attr, String value);

    public void getAttribute();

    public Map<String,String> getAllAttributes();
}
