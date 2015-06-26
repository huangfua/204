<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	Vector orderList = (Vector)session.getAttribute(Constants.ORDER_LIST_KEY);
	Order order = null;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0054)http://beijing.book800.com/asp/shopinfo/Ordhistory.asp -->
<HTML><HEAD><TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK 
href="images/style.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript>
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedimages0].value+"'");
  if (restore) selObj.selectedimages0=0;
}
//-->
</SCRIPT>

<META content="Microsoft FrontPage 5.0" name=GENERATOR></HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center bgColor=#10777b 
border=0>
  <TBODY>
  <TR>
    <TD><IMG height=6 src="images/spacer.gif" width=72> 
      <IMG height=1 src="images/spacer.gif" width=62> </TD></TR>
  </TBODY></TABLE>
<SCRIPT language=javascript src="Ordhistory.files/check.js"></SCRIPT>

<SCRIPT language=javascript>
<!--//
function GoBack()
{
	window.history.go(-1);
}

function DoLogin()
{
	var sUser = document.form1.username.value;
	var sPswd = document.form1.password.value;
	if ((sUser.length<2 )||(sUser.length>30 ))
	{
		alert("用户号必须为 2 - 10 字符或数字\n请重新输入");
    form1.username.focus();
	}
	if ((sPswd.length < 2)||(sPswd.length >30))
	{
	alert("密码必须为 2 - 10 字符或数字\n请重新输入");
    form1.password.focus();
	}
	else
	{
		document.form1.action = '../customer/Loginhdl.asp?FromPage=/asp/ShopInfo/Ordhistory.asp';
		document.form1.submit();
	}
}


function opensub(id){

 var mybars= window.open("OrdCancel.asp?orderref="+id,"my","menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=no,resizable=no,screenX=200,screeY=100,width=400,height=300")

}
//-->
 </SCRIPT>
<BR>
<TABLE cellSpacing=0 cellPadding=0 width=676 align=center border=0>
  <TBODY>
  <TR>
    <TD width=763 bgColor=#55808f>
      <TABLE cellSpacing=1 cellPadding=1 border=0>
        <TBODY>
        <TR>
          <TD align=middle width=110><B><FONT class=p9 
            color=#ffffff>订单号码</FONT> </B></TD>
          <TD align=middle width=100><B><FONT class=p9 
            color=#ffffff>订购日期</FONT></B></TD>
          <TD align=right width=100><B><FONT class=p9 
            color=#ffffff>订单总价</FONT></B></TD>
          <TD align=middle width=80><B><FONT class=p9 
            color=#ffffff>订单取消</FONT></B></TD>
          </TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD width=763 bgColor=#c0d0c5>
      <TABLE cellSpacing=1 cellPadding=1 border=0>
        <TBODY>
        
    <%if(orderList != null ){

       for(int i = 0;i < orderList.size();i++)
       {  
       		order = (Order)orderList.get(i);
       %>
       
        
        <TR>
          <TD align=middle width=110><%=order.getId()%></FONT></TD>
          <TD class=p9 align=middle width=100><%=order.getTime()%></TD>
          <TD class=p9 align=right width=100><%=order.getTotal()%>元</TD>
          <TD align=middle width=80><A 
            href="delOrder.do?orderId=<%=order.getId()%>"><FONT class=p9 
            color=blue><U>取消此单</U></FONT></A> </TD>
          <TD align=middle width=80>&nbsp; </TD>
          </TR>
          
           <%
         }
      }
      %>
       
         
          
          </TBODY></TABLE></TD></TR>
  <TR>
    <TD height=7 width="763"></TD></TR>
  <TR>
    <TD width=763>
      <TABLE width=763 align=right>
        <TBODY>
        <TR>
          <TD class=p9 align=middle><FONT 
            class=p2>您的订单号码是将来查询订单及有关资料的依据，请妥善保存。</B> 
    </FONT></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD height=7 width="763"></TD></TR>
  <TR>
    <TD vAlign=bottom align=middle width=763><A 
      href="bookSearch.do"><U><FONT class=normal 
      color=blue>返回购书 </FONT></U></A></TD></TR></FORM></TBODY></TABLE><!--edit end /2000/7/24--><!--********begin***********
    编写者：xuxl 
    功能：前台尾部文件
    ********end*************-->
<TABLE width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <HR width="90%" SIZE=1>
    </TD></TR>
  <TR>
    <TD>
      <p align="center"></TD></TR></TBODY></TABLE></BODY></HTML>