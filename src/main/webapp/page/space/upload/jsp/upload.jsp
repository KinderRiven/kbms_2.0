<%@ page import="com.upsuns.po.user.User" %><%--
  Created by IntelliJ IDEA.
  User: KinderRiven
  Date: 2017/2/27
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/page/jsp/user.jsp" %>
<html>
<head>
    <title>用户空间-文件上传</title>

    <%-- bootstrap + jquery --%>
    <script src="/framework/jquery/jquery-2.2.2.min.js"></script>
    <link href="/framework/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/framework/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <link href="/framework/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">


    <%-- plugin--%>
    <script src="/plugin/bootstrap-fileinput-master/js/fileinput.min.js"></script>
    <script src="/plugin/bootstrap-fileinput-master/js/fileinput_locale_zh.js"></script>
    <link href="/plugin/bootstrap-fileinput-master/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />

    <%-- my js--%>
    <script src="/page/space/upload/js/upload-frame.js"></script>

    <%-- my css--%>
    <link href="/page/space/css/style.css" rel="stylesheet" type="text/css">
    <link href="/page/space/upload/css/upload.css" rel="stylesheet" type="text/css">

</head>
<body>
    <nav class="header navbar navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">KBMS</a>
            </div>
            <ul class="navbar-brand navbar-right">

                <li class="dropdown nav-user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span><img src="/resource/sao/icon/skills_hover.png"></span>
                        <span>KinderRiven</span>
                    </a>

                    <ul class="dropdown-menu user-menu">
                        <li>
                            <a href="#">
                                <span><img src="/resource/sao/icon/option_normal.png"></span>
                                <span>个人资料</span>
                            </a>
                        </li>
                        <li><a href="#">
                            <span><img src="/resource/sao/icon/option_normal.png"></span>
                            <span>退出</span>
                        </a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <div class="main-container">
        <div class="sidebar">
            <ul>
                <li><a href="#"><img src="/resource/sao/icon/folder_normal.png">文件列表</a></li>
                <li><a href="#"><img src="/resource/sao/icon/appearance_normal.png">用户日志</a></li>
                <li><a href="#"><img src="/resource/sao/icon/skills_normal.png">私密空间</a></li>
            </ul>
        </div>
        <div class="content clearfix">
            <div class="upload-frame">
                <form>
                    <input id="form-zh" type="file" name="file" multiple>
                </form>
            </div>
            <div class="file-frame">
                <div class="file-table">
                    <div class="file-table-head">
                        <ul class="clearfix">
                            <li class="file-table-head-fname">
                                <span><input type="checkbox"/></span>
                                <span>文件名称</span>
                            </li>
                            <li class="file-table-head-fsize">
                                <span>大小</span>
                            </li>
                            <li class="file-table-head-fdate">
                                <span>修改时间</span>
                            </li>
                        </ul>
                    </div>
                    <div class="file-table-body">
                        <div class="file-table-body-item">
                            <div class="item-fname">
                                <span><input type="checkbox"/></span>
                                <span><img src="/resource/sao/icon/folder_normal.png"></span>
                                <span>C语言入门</span>
                            </div>
                            <div class="item-fsize">
                                <span>-</span>
                            </div>
                            <div class="item-fdate">
                                <span>2017-02-28 18:23</span>
                            </div>
                        </div>
                        <div class="file-table-body-item">
                            <div class="item-fname">
                                <span><input type="checkbox"/></span>
                                <span><img src="/resource/sao/icon/folder_normal.png"></span>
                                <span>算法导论</span>
                            </div>
                            <div class="item-fsize">
                                <span>-</span>
                            </div>
                            <div class="item-fdate">
                                <span>2017-02-28 18:23</span>
                            </div>
                        </div>
                        <div class="file-table-body-item">
                            <div class="item-fname">
                                <span><input type="checkbox"/></span>
                                <span><img src="/resource/sao/icon/folder_normal.png"></span>
                                <span>有道</span>
                            </div>
                            <div class="item-fsize">
                                <span>-</span>
                            </div>
                            <div class="item-fdate">
                                <span>2017-02-28 18:23</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
