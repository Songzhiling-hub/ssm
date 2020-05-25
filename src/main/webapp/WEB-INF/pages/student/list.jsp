<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
        div{
            border: 1px solid black;
            padding:2px;
        }
        .content{
            width: 90%;
            margin: 0px auto;
        }
        .top{
            height: 100px;
        }
        .mid{
            overflow:hidden;/*子级元素浮动 需要在父级元素清除*/
        }
        .mid div{
            float: left;
            height:600px;
        }
        .left{
            width: 20%;
        }
        .right{
            margin-left:1%;
            width: 76%
        }
        table{
            width:96%;
            border-collapse: collapse;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="top"></div>
    <div class="mid">
        <div class="left"></div>
        <div class="right">
            <!-- 内容展示部分 -->
            <h2>学生信息</h2>
            <form action="imgInfoServlet">
                姓名:<input type="text" name="find_imgname"/>
                <input type="submit" value="查询"/>
                <a href="/ssm/student/getJsp" style="margin-left: 500px; border: solid 1px black">新增</a>
            </form>
            <table border="1">
                <thead>
                <th>序号</th>
                <th>学生编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>专业</th>
                <th>班级</th>
                <th>入学日期</th>
                <th>联系方式</th>
                <th>操作</th>
                </thead>
                <tbody>
                    <c:forEach items="${p.list}" var="stu" varStatus="s"><!-- varStatus 循环的下标 从0开始 类似for循环中的i -->
                        <tr>
                            <td>${s.index+1}</td>
                            <td>${stu.sno}</td>
                            <td>${stu.sname}</td>
                            <td>${stu.ssex}</td>
                            <td>${stu.pro_name}</td>
                            <td>${stu.classname}</td>
                            <td>${stu.comeDate}</td>
                            <td>xxx-xxx</td>
                            <td><a href="/ssm/student/getUpdateJsp/${stu.id}">编辑</a> | <a href="/ssm/student/delete/${stu.id}">删除</a> | <a href="/ssm/student/getDetail/${stu.id}">详情</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                当前${p.curPage}页      <a href="/ssm/student/getListJsp/${p.curPage-1}">上一页</a>     <a href="/ssm/student/getListJsp/${p.curPage+1}">下一页</a>    共${p.total}页 跳转到 x 页
        </div>
    </div>
</div>
</body>
</html>
