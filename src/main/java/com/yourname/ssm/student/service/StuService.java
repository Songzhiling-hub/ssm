package com.yourname.ssm.student.service;

import com.yourname.ssm.clazz.dao.IClazz;
import com.yourname.ssm.profession.dao.IProfessionDao;
import com.yourname.ssm.student.dao.IStuDao;
import com.yourname.ssm.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuService {
    @Autowired
    private IStuDao iStuDao;
    @Autowired
    private IProfessionDao professionDao;
    @Autowired
    private IClazz iClazz;

    /*分页查询*/
    public Map<String, Object> getList(int pageSize, int curPage) {
        Map<String,Object> map = new HashMap<>();

        int begin = pageSize*(curPage-1);
        int end = pageSize*curPage;
        //1-select数据
        map.put("begin",begin);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list = iStuDao.getList(map);
        //2-count结果
        Long count = iStuDao.getCount();
		/*
		* if(余数==0){
				count/pageSize
			}esle{
				count/pageSize+1
			}
		* */
        Long totalPages = 0L;//总页数
        if(count%pageSize == 0){
            totalPages = count/pageSize;
        }else{
            totalPages = count/pageSize+1;
        }
        map.put("list",list);
        map.put("total", totalPages);
        map.put("curPage",curPage);
        return map;
    }

    /*
        该方法用于 获取 学生录入页面的所有需要的参数，比如 专业列表、班级列表 等
     */
    public Map<String,Object> getParam(){
        Map<String,Object> param = new HashMap<>();
        //获取专业list
        List<Map<String, Object>> pro_list = professionDao.getListAll();
        param.put("proList", pro_list);
        //获取班级list
        List<Map<String, Object>> clazz_list = iClazz.getListAll();
        param.put("clazList",clazz_list);
        //如果还有的话 继续往param里put
        return param;
    }
    /*保存 更新 数据的业务方法*/
    public int saveOrUpdate(Map<String, Object> param) {
        int i=0;
        if(param.get("id") == null || "".equals(param.get("id"))){
            //新增
            param.put("id", IdGenerator.uuid());//添加id主键

            i = iStuDao.save(param);
        }else {
            //更新
            i = iStuDao.update(param);
        }
        return i;
    }

    /*更新   获取被更新的数据*/
    public Map<String, Object> getObject(String id) {
        return iStuDao.getObject(id);
    }

    public int delete(String id) {
        return iStuDao.delete(id);
    }
}
