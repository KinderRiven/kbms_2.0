<%@ page import="com.upsuns.po.user.User" %><%

    User user = (User) session.getAttribute("user");
    boolean logging = false;

    if(user != null) {
        System.out.println(user.getUsername());
        logging = true;
    }
%>
