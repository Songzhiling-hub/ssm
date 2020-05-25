package com.yourname.ssm.user.service;

import com.yourname.ssm.user.dao.IUserDao;
import com.yourname.ssm.util.IdGenerator;
import com.yourname.ssm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private IUserDao iUserDao;

    public String login(Map<String, Object> param) {
        List<Map<String,Object>> list =  iUserDao.getList(param);
        if (list==null || list.size()==0){
            return "登陆失败";
        }else {
            return "登陆成功";
        }
    }

    public String regist(Map<String, Object> param) {
        param.put("id", IdGenerator.uuid());//添加id主键
        param.put("password", StringUtil.md5encode(param.get("password").toString()));//password进行加密处理
        int i = iUserDao.save(param);
        String msg = null;
        if(i>0){
            msg =  "注册成功";
        }else {
            msg =  "注册失败";
        }
        return msg;
    }
}
