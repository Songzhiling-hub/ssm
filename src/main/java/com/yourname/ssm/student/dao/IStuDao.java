package com.yourname.ssm.student.dao;

import java.util.Map;
import java.util.List;

public interface IStuDao {

    List<Map<String,Object>> getList(Map<String,Object> param);

    Long getCount();

    int save(Map<String, Object> param);

    Map<String, Object> getObject(String id);

    int update(Map<String, Object> param);

    int delete(String id);
}
