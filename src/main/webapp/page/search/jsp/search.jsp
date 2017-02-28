<%--
  Created by IntelliJ IDEA.
  User: KinderRiven
  Date: 2017/2/27
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>

    <%-- bootstrap + jquery --%>
    <script src="/framework/jquery/jquery-2.2.2.min.js"></script>
    <link href="/framework/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/framework/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <link href="/framework/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">

    <%-- my style--%>
    <link href="/page/search/css/login.css" rel="stylesheet" type="text/css">
    <link href="/page/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    
</body>
</html>
