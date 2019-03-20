<%--
  Created by IntelliJ IDEA.
  User: jay
  Date: 3/18/19
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Department list</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //\u81ea\u9002\u5e94\u5c4f\u5e55\u5bbd\u5ea6
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--\u6846\u67b6\u9ad8\u5ea6\u8bbe\u7f6e-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">Department list</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--\u5217\u8868-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">name</th>
                    <th scope="col">address</th>
                    <th scope="col">execute</th>
                </tr>
                <c:forEach items="${LIST}" var="dep">
                <tr>
                    <td>${dep.name}</td>
                    <td>${dep.address}</td>
                    <td>
                        <a href="add.html" class="btn">edit</a>
                        <a href="" class="btn">delete</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <!--\u5217\u8868-->
            <!--\u53f3\u8fb9\u5e95\u90e8-->
            <div class="r_foot">
                <div class="r_foot_m">
                    <a href="add.html" class="btn">add</a>
                </div>
            </div>
            <!--\u53f3\u8fb9\u5e95\u90e8-->
        </div>
        <!--\u4f1a\u8bae\u5217\u8868-->
    </div>
</div>
</body>
</html>
