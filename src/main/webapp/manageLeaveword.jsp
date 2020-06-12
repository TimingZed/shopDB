
<%@page import="java.util.List"%>
<%@ page import="com.timing.pojo.Message" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>用户留言管理</title>
<link  rel="stylesheet" type="text/css" href="/css/font.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<%
	List<Message> list=(List<Message>)request.getAttribute("list");
%>
<body topmargin="0" leftmargin="0" bottommargin="0">
 <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
<form name="form1" method="post" action="/message/removeMessageId">
  <tr bgcolor="#FFCF60"> 
    <td height="20" colspan="2"><div align="center"><font color="#FFFFFF">用户留言管理</font></div></td>
  </tr>
  <tr> 
    <td height="40" colspan="2" bgcolor="#333333"><table width="750"  border="0" align="center" cellpadding="0" cellspacing="1">
        <tr> 
          <td width="357" height="20" bgcolor="#FFFFFF"><div align="center">留言主题</div></td>
          <td width="80" bgcolor="#FFFFFF"><div align="center">留言者</div></td>
          <td width="156" bgcolor="#FFFFFF"><div align="center">留言时间</div></td>
          <td width="93" bgcolor="#FFFFFF"><div align="center">操作</div></td>
          <td width="58" bgcolor="#FFFFFF"><div align="center">删除</div></td>
        </tr>
        <%
        	for(Message mess:list){
        %>
		         <tr> 
          <td height="20" bgcolor="#FFFFFF"><div align="left"><%=mess.getTitle() %></div></td>
          <td height="20" bgcolor="#FFFFFF"><div align="center"><%=mess.getUser().getName() %>
		  		  </div></td>
          <td height="20" bgcolor="#FFFFFF"><div align="center"><%=mess.getTime() %></div></td>
          <td height="20" bgcolor="#FFFFFF"><div align="center"><a href="/message/findMessageId?id=<%=mess.getId()%>">查看</a></div></td>
          <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="removeMessage" value=<%=mess.getId()%>>
            </div></td>
        </tr>
        <%} %>
        
	
		
		
		
		      </table></td>
  </tr>
  <tr height="15px">
    <td></td>
  </tr>
  <tr >  
    <td width="100%" bgcolor="#FFFFFF" align="right">
	<input type="submit" value="删除选项" class="buttoncss"></td>
  </tr>
  </form>
</table>
	</body>
</html>
