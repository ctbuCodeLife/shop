<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.shop.domain.Product" %>
<%@ page import="com.shop.dao.ProductDao" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>订单表</title>
<!--根据设备的宽度调整缩放比例   -->
<meta name="viewport" content="width=device-width,initial-scale=1" />
<!--引入bootstrap的CSS文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css"
	type="text/css" />
<!--引入jquery的js文件-->
<script 　type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

<%!	ArrayList<Sales> listSales;
%>
<%  Customer customer = new Customer();
    customer = (Customer)session.getAttribute("customer");
    if(customer != null){
	   SalesDao sd = new SalesDao();
	   listSales = sd.findShow(customer.getId());
	   session.setAttribute("listSales", listSales);
   }
%>
	<!--创建整体布局DIV-->
	<div class="container">
		<%@ include file="head.jsp"%>

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:1150px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
						<tbody>
                        <c:forEach var="sales" items="${sessionScope.listSales}">
                            <c:set var="pid" value="${sales.pId}" scope="session"/>
                            <%
                                try {
                                    String param = session.getAttribute("pid").toString();
                                    int pId = 0;
                                    if (param != null) {
                                        pId = Integer.parseInt(param);
                                    }
                                    ProductDao pd = new ProductDao();
                                    Product p = new Product();
                                    p = pd.find(pId);
                                    session.setAttribute("product", p);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>

							<tr class="success">
								<th colspan="6">订单编号:${sales.invoiceNo}</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
                                <th>状态</th>
							</tr>

							<tr class="active">
								<td width="40%">
                                    <input type="hidden" name="id" value="22">
                                    <img src="${sessionScope.product.pImage}" alt="${sessionScope.product.pName}" width="70" height="60"></td>
								<td width="20%"><a target="_blank"> ${sessionScope.product.pName}</a></td>
								<td width="10%">￥${sessionScope.product.iPrice}</td>
								<td width="10%">${sales.count}</td>
								<td width="10%"><span class="subtotal">￥${sales.totalPrice}</span></td>
                                <td>${sales.orderStatus}</td>
							</tr>
                            </c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="text-align: center;">
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">8</a></li>
					<li><a href="#">9</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</div>
		</div>
		<%@ include file="foot.jsp" %>
	</div>
</body>

</html>