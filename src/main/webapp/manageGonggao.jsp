<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>公告管理</title>
<link rel="stylesheet" type="text/css" href="/css/font.css">
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
</head>

<body topmargin="0" leftmargin="0" bottommargin="0">
<form name="form1" method="post" action="/notice/removeNoticeId">
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" bgcolor="#FFCF60"><div align="center" class="style1">公告管理</div></td>
  </tr>
  <tr>
    <td height="50" bgcolor="#666666"><table width="750" height="25" border="0" align="center" cellpadding="0" cellspacing="1">
	
      <tr>
        <td width="50" height="25" bgcolor="#FFFFFF"><div align="center">复选</div></td>
        <td width="621" bgcolor="#FFFFFF"><div align="center">公告主题</div></td>
        <td width="75" bgcolor="#FFFFFF"><div align="center">操作</div></td>
      </tr>

<c:forEach items="${requestScope.list}" varStatus="i" var="notice" >
        <tr>
        <td height="25" bgcolor="#FFFFFF"><div align="center"><input type="checkbox" value=${notice.id} name="removeNoticeId" ></div></td>
        <td height="25" bgcolor="#FFFFFF"><div align="left">${notice.title}</div></td>
	    <td height="25" bgcolor="#FFFFFF"><div align="center"><a href="/editGonggao.jsp">查看编辑</a></div></td>
	  </tr>

</c:forEach>
	      </table></td>
  </tr>
</table>
<br>
<table width="750" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
   
    <td align="right">
	   <input type="submit" value="删除选项" class="buttoncss">
	   </td>
  </tr>

</table>
</form>
</body>
</html>
