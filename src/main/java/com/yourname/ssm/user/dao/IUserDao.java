package com.yourname.ssm.user.dao;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<Map<String,Object>> getList(Map<String,Object> param);

    int save(Map<String, Object> param);
}
