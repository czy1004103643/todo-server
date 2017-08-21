<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"   
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/site.css" type="text/css" rel="stylesheet"/>
<script src="/js/site.js"></script>
<title>任务管理系统</title>
</head>
<body>
    <h1>注册</h1>
    
    <span style="color:#1AFD9C">${info}</span>
    <br><br>
    <div id="signup-form">
        <form action="/tms/site/signup" method="post">
           <label>账号：</label> 
           <input type="text" name="username"/>
           <br><br>
           <label>密码：</label> 
           <input type="password" name="password"/>
           <br><br>
           <label>姓名：</label> 
           <input type="text" name="truename"/>
           <br><br>
           <input type="radio" name="status" value="4" />
           <label>董事长</label>
           <input type="radio" name="status" value="3" />
           <label>经理</label>
           <input type="radio" name="status" value="2" />
           <label>高级管理人员</label>
           <input type="radio" name="status" value="1" />
           <label>员工</label>
           
           <br><br>
           <input type="hidden" name="token" value="${token}"/>
           <input type="submit" value="注册"/>
        </form>
    </div>
    
</body>


</html>
