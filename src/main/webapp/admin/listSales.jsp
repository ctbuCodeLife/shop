<%@ page language="java"
         import="java.util.*,com.shop.dao.*,com.shop.domain.*"
         contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shop.domain.Sales" %>
<%@ page import="com.shop.dao.SalesDao" %>
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
<%!ArrayList<Sales> listSales;
%>
<%
    SalesDao sd = new SalesDao();
    listSales = sd.findAll();
    session.setAttribute("listSales", listSales);
%>
<div class="details">
    <div class="details_operation clearfix">
        <div class="bui_select">
            <input type="button" value="添&nbsp;&nbsp;加" class="add"
                   onclick="addSales()">
        </div>

    </div>
    <!--表格-->
    <table class="table">
        <thead>
        <tr>
            <th width="15%">订单id</th>
            <th width="20%">用户id</th>
            <th width="20%">商品id</th>
            <th width="20%">数量</th>
            <th width="20%">总价</th>
            <th width="20%">下单时间</th>
            <th width="20%">流水号</th>
            <th width="20%">状态</th>
            <th width="20%">收货时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sales" items="${sessionScope.listSales}">
            <tr>
                <td width="10%"><label id="username" for="username"
                                       class="label">${sales.id}</label></td>
                <td width="5%">${sales.cid}</td>
                <td width="20%">${sales.pid}</td>
                <td width="5%">${sales.count}</td>
                <td width="10%">${sales.totalPrice}</td>
                <td width="10%">${sales.orderDate}</td>
                <td width="10%">${sales.invoiceNo}</td>
                <td width="10%">${sales.orderStatus}</td>
                <td width="20%">${sales.dilivDate}</td>
                <td align="center"><input id="edit" type="button" value="修改"
                                          class="btn" onclick="editSales('${sales.username}')"> <input
                        id="del" type="button" value="删除" class="btn"
                        onclick="delSales('${sales.username}')"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>