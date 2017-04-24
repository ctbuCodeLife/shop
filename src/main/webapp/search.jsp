<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>订单信息</title>
    <!--根据设备的宽度调整缩放比例   -->
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <!--引入bootstrap的CSS文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="css/bootstrap-theme.min.css" type="text/css" />
    <!--引入jquery的js文件-->
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">
        .center-block{
            border: 1px solid red;
            width: 170px;
        }
    </style>
</head>

<body>
<%@include file="head.jsp" %>
<!--创建查询DIV-->
<div class="container">
    <div class="row" style="width:1210px;">
            <div id="allsearch" class="center-block" v-for="product in mydata">
                <a href="product_info.jsp?id=${product.id}">
                    <img src="${product.pImage}" alt="${product.pName}"	width="170" height="170" style="display: inline-block;">
                </a>
                <p>
                    <a href="product_info.jsp?id=${product.id}" style='color:green'>${product.pName}</a>
                </p>
                <p>
                    <font color="#FF0000">商城价：&yen;${product.iPrice}</font>
                </p>
            </div>
    </div>
</div>
<!--创建footDIV-->
<div class="">
    <center>
        <img src="img/foot.png" align="center"/>
    </center>
</div>

<!--创建版权DIV-->
<div class="">
    <center>
        <a href="" target="_blank">关于商城</a>|
        <a href="" target="_blank">帮助中心</a>|
        <a href="" target="_blank">联系我们</a>|
        <a href="" target="_blank">发展历程</a>|
        <a href="" target="_blank">媒体报道</a>
        <br/>
        <span>&copy;2016  版权所有. 京ICP备XXXXXXXX号-XXX京ICP证XXXXXX号</span>
    </center>
</div>
<script type="text/javascript">
    function  searchByName(){
        var name = $("#searchText").val();
        alert(1);
        alert(name);
        $.ajax({
            type:"GET",
            url:"/shop/searchByName",
            data:{name:name},
            dataType:"json",
            success:function (data) {
                alert(2);
                var vm = new Vue({
                    el:"#allsearch",
                    data:{
                        mydata:data
                    }
                });
            },
            error:function () {
                alert("没有该商品");
            }
        });
        alert(3);
    }
</script>
</body>
</html>