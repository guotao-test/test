package com.wfit.dachuang.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateObjectNodeUtil {
    public static ObjectNode getObjectNode(){
        ObjectMapper mapper=new ObjectMapper();
        return mapper.createObjectNode();
    }
}
