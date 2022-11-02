package com.wfit.dachuang.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wfit.dachuang.pojo.DictDetail;
import com.wfit.dachuang.utils.CreateObjectNodeUtil;
import com.wfit.dachuang.utils.GetDictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController {
    @Autowired
    private GetDictUtils getDictUtils;

    @RequestMapping("/getDictByRole")
    public String getDictByRole(){
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        List<DictDetail> detailsByRole = getDictUtils.getDictByRole();
        return objectNode.putPOJO("dict_detail_role",detailsByRole).toString();
    }
    @RequestMapping("/getDictByHospLevel")
    public String getDictByHospLevel(){
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        List<DictDetail> detailsByHopeLevel = getDictUtils.getDictByHospLevel();
        return objectNode.putPOJO("dict_detail_hosp_level",detailsByHopeLevel).toString();
    }
    @RequestMapping("/getDictByDepartment")
    public String getDictByDepartment(){
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        List<DictDetail> detailsByDepartment = getDictUtils.getDictByDepartment();
        return objectNode.putPOJO("dict_detail_department",detailsByDepartment).toString();
    }
    @RequestMapping("/getDictByTitle")
    public String getDictByTitle(){
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        List<DictDetail> detailsByTitle = getDictUtils.getDictByTitle();
        return objectNode.putPOJO("dict_detail_title",detailsByTitle).toString();
    }
    @RequestMapping("/getDictByDictId")
    public String getDictByDictId(String dictId){
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        List<DictDetail> detailsByDictId = getDictUtils.getDictByDictId(dictId);
        return objectNode.putPOJO("dict_detail",detailsByDictId).toString();
    }

}
