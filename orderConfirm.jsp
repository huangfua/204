<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	Vector shopCartList = (Vector)session.getAttribute(Constants.ORDER_DETAIL_KEY);
	ShopCart  shopCart = null;
	Order order = (Order)session.getAttribute(Constants.BOOK_ORDER_KEY);
	User user = (User)session.getAttribute(Constants.LOGIN_USER_INFO_KEY);
	System.out.println(shopCartList.size());
%>

<html>
<head>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="images/style.css" type="text/css" rel=stylesheet>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center bgColor=#10777b 
border=0>
  <TBODY>
  <TR>
    <TD><IMG height=6 src="images/spacer.gif" width=72> 
    <IMG 
      height=1 src="images/spacer.gif" width=62> </TD></TR>
  </TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=middle width="15%">
      <TABLE cellSpacing=0 cellPadding=0 width=64 border=0>
        <TBODY>
        <TR>
          <TD></TD></TR></TBODY></TABLE></TD>
    <TD vAlign=top><!-- Outer Table--><BR>
      <TABLE cellSpacing=0 cellPadding=0 width="90%" align=left border=0 height="483">
        <TBODY>
        <TR>
          <TD height="95">
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD><IMG src="images/book_040.gif" width="136" height="93"> </TD>
                <TD width=400 background=images/book_041.gif>
                <IMG 
                  src="C:\Documents and Settings\teacher\桌面\bookstore\订单收据.files\spacer(1).gif" width="1" height="1"></TD>
                <TD><IMG src="images/book_042.gif" width="135" height="93"> 
</TD></TR></TBODY></TABLE></TD>
        <TR>
          <TD align=right width="90%" height="124">
            <TABLE cellSpacing=0 cellPadding=0 width="100%" align=right 
border=0 height="58">
              <TBODY>
              <TR>
                <TD align=left colSpan=2 height=28><FONT class=large 
                  color=#0d7999>您的注册信息:</FONT></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="15%" height="1"><B>姓名：&nbsp;</B></TD>
                <TD class=p9 width="35%" height="1"><%=user.getName()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="15%" height="17"><B>联系地址：&nbsp;</B></TD>
                <TD class=p9 width="35%" height="17"><%=user.getAddress()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="15%" height="21"><B>电话：&nbsp;</B></TD>
                <TD class=p9 width="35%" height="21"><%=user.getTel()%></TD>
                </TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD height=5></TD></TR>
        <TR>
          <TD width=600 bgColor=#dcf0d5 height="22">
            <TABLE cellSpacing=1 cellPadding=1 width=600 border=0>
              <TBODY>
              <TR bgColor=#dcf0d5>
                <TD align=middle width=290><B><FONT class=p9 
                  color=#005574>&nbsp;书 名 </FONT></B></TD>
                <TD align=middle width=90><B><FONT class=p9 color=#005574>数 
                  量&nbsp;</FONT></B></TD>
                <TD align=right width=110><B><FONT class=p9 color=#005574>单 
                  价&nbsp;</FONT></B></TD>
                <TD align=right width=110><B><FONT class=p9 color=#005574>小 
                  计&nbsp;</FONT></B></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD width=600 height="22">
            <TABLE cellSpacing=1 cellPadding=1 border=0>
              <TBODY>

    <%if(shopCartList != null ){

       for(int i = 0;i < shopCartList.size();i++)
       {  
       		shopCart = (ShopCart)shopCartList.get(i);
       %>
                 

              <TR>
                <TD align=left width=290><FONT class=p9><%=shopCart.getName()%> 
                </FONT></TD>
                <TD align=middle width=80><FONT class=p9><%=shopCart.getCount()%></FONT></TD>
                <TD align=right width=110><B><FONT class=p9><%=shopCart.getSalePrice()%> 
                元</FONT></B></TD>
                <TD align=right width=110><B><FONT class=p9><%=shopCart.getSalePrice()*shopCart.getCount()%> 
                元</FONT></B></TD></TR>
                
           <%
         }
      }
      %>
                
         </TBODY></TABLE></TD></TR>       
        <TR>
          <TD height=14>&nbsp;</TD></TR>
        <TR>
          <TD width=600 height="127">
            <HR color=#dcf0d5 SIZE=1>

            <TABLE cellSpacing=1 cellPadding=0 width=210 align=right border=0>
              <TBODY>
              <TR>
                <TD><B><FONT class=p9 color=#0d7999>合 计:</FONT></B></TD>
                <TD align=right><B><FONT class=p9><%=order.getTotal()%>元</FONT></B></TD></TR>
              <TR>
                <TD colSpan=2>
                  <HR color=#dcf0d5 SIZE=1>
                </TD></TR>
              <TR>
                <TD><B><FONT class=p9 color=#0d7999>送货方式:</FONT></B></TD>
                <TD align=right><B><FONT class=p9><%=order.getDelivery()%></FONT></B></TD></TR>
              <TR>
                <TD><B><FONT class=p9 color=#0d7999>付款方式:</FONT></B></TD>
                <TD align=right><B><FONT 
            class=p9><%=order.getPayment()%></FONT></B></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD height="1"></TD></TR>
        <TR>
          <TD width=600 bgColor=#dcf0d5 height="20">
            <TABLE width=600 align=right bgColor=#dcf0d5>
              <TBODY>
              <TR>
                <TD width=80></TD>
                <TD class=Large align=middle><FONT 
                  color=#0d7999><B>您的订单号码是:</B></FONT> </TD>
                <TD class=p8 align=left width=170><FONT 
                  color=#000000><B><%=order.getId()%></FONT> </B></TD></TR>
              </TBODY></TABLE></TD></TR>
        <TR>
          <TD height="15">
            <HR color=#dcf0d5 SIZE=1>
          </TD></TR>
        <TR>
          <TD align=middle width=600 height="39">
            <TABLE>
              <TBODY>
              <TR>
                <TD align=middle width=290><A id=next 
                  href="bookSearch.do">
                <IMG alt=继续购书 
                  src="images/book_007.gif" border=0 width="69" height="25"></A> </TD>
                <TD align=middle width=300><A 
                  href="orderHistory.do">
                <IMG 
                  alt=查看订单 src="images/book_043.gif" border=0 width="76" height="31"></A> 
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE><!--********begin***********
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
    <p align="center">　</TD></TR></TBODY></TABLE></BODY></HTML>