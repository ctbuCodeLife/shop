<%@ page language="java"
         import="java.util.*,com.shop.dao.*,com.shop.domain.*"
         contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shop.domain.Customer" %>
<%@ page import="com.shop.dao.CustomerDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="cmn-Hans-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/admin.css" />
    <script src="../js/admin.js"></script>
</head>
<body>
<%!ArrayList<Customer> listCustomer;
%>
<%
    CustomerDao ad = new CustomerDao();
    listCustomer = ad.findAll();
    session.setAttribute("listCustomer", listCustomer);
%>
<div class="details">
    <div class="details_operation clearfix">
        <div class="bui_select">
            <input type="button" value="添&nbsp;&nbsp;加" class="add"
                   onclick="addCustomer()">
        </div>

    </div>
    <!--表格-->
    <table class="table">
        <thead>
        <tr>
            <th width="15%">管理员名</th>
            <th width="20%">密码</th>
            <th width="20%">邮箱</th>
            <th width="20%">等级</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${sessionScope.listCustomer}">
            <tr>
                <td width="15%"><label id="username" for="username"
                                       class="label">${customer.username}</label></td>
                <td width="20%">${customer.password}</td>
                <td width="20%">${customer.email}</td>
                <td width="20%">${customer.level}</td>
                <td align="center"><input id="edit" type="button" value="修改"
                                          class="btn" onclick="editCustomer('${customer.username}')"> <input
                        id="del" type="button" value="删除" class="btn"
                        onclick="delCustomer('${customer.username}')"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>