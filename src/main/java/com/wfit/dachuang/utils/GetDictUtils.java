package com.wfit.dachuang.utils;

import com.wfit.dachuang.pojo.DictDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author gt
 *
 * */
@Mapper
@Component
public interface GetDictUtils {
    /**
     * 为了获取数据字典中的人物权限
     * */
    List<DictDetail> getDictByRole();
    /**
     * 为了获取数据字典中的医院等级
     * */
    List<DictDetail> getDictByHospLevel();
    /**
     * 为了获取数据字典中的医院科室
     * */
    List<DictDetail> getDictByDepartment();
    /**
     * 为了获取数据字典中的医院职称
     * */
    List<DictDetail> getDictByTitle();
    /**
     * 根据表中dict_id获取数据字典中的对应的值
     * */
    List<DictDetail> getDictByDictId(String dictId);

}
