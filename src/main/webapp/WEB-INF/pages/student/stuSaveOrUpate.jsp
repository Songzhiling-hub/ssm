<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    学生信息
    <form action="/ssm/student/saveOrUpdate" method="post">
        <input type="hidden" name="id" value="${obj.id}"><!-- 隐藏域 存储id 用于区分保存和更新的操作 -->
        <table width="50%" border="1" style="border-collapse: collapse">
            <tbody>
                <tr>
                    <td>学生编号:</td>
                    <td><input type="text" name="sno" value="${obj.sno}"/></td>
                    <td>学生姓名:</td>
                    <td><input type="text" name="sname" value="${obj.sname}"/></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="radio" name="ssex" value="男">男<input type="radio" name="ssex" value="女">女</td>
                    <td>出生日期</td>
                    <td><input type="date" name="sbirth" value="${obj.sbirth}"></td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td><input type="text" name="idcard" value="${obj.idcard}"></td>
                    <td>专业</td>
                    <td><select name="profession">
                        <c:forEach items="${p.proList}" var="pro">
                            <option value="${pro.pro_no}">${pro.pro_name}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td>班级编号</td>
                    <td><select name="clazzNo">
                        <c:forEach items="${p.clazList}" var="cla">
                            <option value="${cla.classno}">${cla.classname}</option>
                        </c:forEach>
                    </select></td>
                    <td>入学日期</td>
                    <td><input type="date" name="comeDate" value="${obj.comeDate}"></td>
                </tr>
                <tr>
                    <td>联系方式</td>
                    <td><input type="tel" name="tel" value="${obj.tel}"></td>
                    <td>籍贯</td>
                    <td><input type="text" name="address" value="${obj.address}"></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td><select name="nation">
                        <option value="汉族">汉族</option>
                    </select></td>
                    <td>政治面貌</td>
                    <td><select name="zzmm">
                        <option>党员</option>
                        <option>群众</option>
                        <option>团员</option>
                        <option>其他党派</option>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交" id="inp_submit"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>

        </table>
        <script>
            var ssex = '${obj.ssex}';//男 或 女
            var clazzNo = '${obj.classNo}';
            var profession = '${obj.profession}';

            var detail = '${Detail}';
            window.onload=function () {
                /*对于页面编辑操作 需要使用js 将单选按钮 下拉框 等元素 设置成数据原有的状态*/
                if(document.getElementsByName("id").values() != null){
                    //----------------------radio 性别-----------------------
                    var radio_sex = document.getElementsByName("ssex");
                    if (ssex == '男') {
                        radio_sex[0].click();
                    } else {
                        radio_sex[1].click();
                    }
                    //----------------------select 专业-----------------------
                    var option_pro = document.getElementsByName("profession")[0].children;
                    for(var o=0; o<option_pro.length; o++){
                        if(option_pro[o].value == profession){
                            option_pro[o].selected=true;
                        }
                    }
                    //----------------------select 班级-----------------------
                    var option_claz = document.getElementsByName("clazzNo")[0].children;
                    for(var o=0;o<option_claz.length;o++){
                        if(option_claz[o].value ==  clazzNo){
                            option_claz[o].selected = true;
                        }
                    }
                }
                /*详情页的if一定要放在编辑页的if后面 因为 要先将 页面的select、radio等元素被选中  之后在执行 detail这个if的禁用元素/
                /*详情页 禁用 input 隐藏 提交按钮*/
                if(detail == 'detail'){
                    //禁用input readOnly 和 disable 区别  readOnly无法提交到后台
                    //1- 禁用input
                    var inputs = document.getElementsByTagName("input");
                    for (var i=0; i<inputs.length;i++){
                        inputs[i].disabled='disable';
                    }
                    //2-禁用select
                    var selects = document.getElementsByTagName("select");
                    for(var i=0; i<selects.length;i++){
                        selects[i].disabled='disable';
                    }
                    //3-隐藏提交按钮
                    var inp_submit = document.getElementById("inp_submit");
                    inp_submit.style.display='none';
                }
            }
        </script>
    </form>
</body>
</html>
