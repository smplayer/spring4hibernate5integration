<%--
  Created by IntelliJ IDEA.
  User: Newbody
  Date: 2016/2/27
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="zh-CN">
<head>
    <title>产品列表</title>
    <c:import url="/WEB-INF/views/jsp/common/common-meta.jsp"/>
    <c:import url="/WEB-INF/views/jsp/common/common-link.jsp"/>
</head>
<body>
${param1}

<form id="form" action="/demo/modelMap/test1" method="post"></form>
<a id="confirm" href="javascript:void(0);">confirm</a>
<c:import url="/WEB-INF/views/jsp/common/common-script.jsp"/>
<script>
    $(function(){
        $("#confirm").click(function(){
            $("#form").append($("<input type='hidden' name='param2'/>").val("test2 form post"));
            $("#form").submit();
        });
    });
</script>

</body>
</html>
