<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	Vector shopCartList = (Vector)session.getAttribute(Constants.BOOK_SHOPCART_KEY);
	ShopCart  shopCart = null;
%>

<HTML><HEAD><TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><LINK 
href="images/style.css" type="text/css" rel=stylesheet>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<div align="center">
  <center>
<TABLE cellSpacing=0 cellPadding=0 width=763 bgColor=#336699 
border=0 height="27" style="border-collapse: collapse" bordercolor="#111111">
  <TBODY>
  <TR>
    <TD height="27">
      　</TD></TR>
  </TBODY></TABLE>
  </center>
</div>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD width="85%">
      <FORM name=BasketForm action="updateShopCart.do"  method=post>
      <TABLE cellSpacing=0 cellPadding=8 width="100%" align=center 
        border=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD>
                <IMG src="images/book_002.gif" width="161" height="97"></TD>
                <TD align=middle width=400 
                background=images/book_004.gif>
                <IMG 
                  src="images/spacer(1).gif" width="1" height="1"> </TD>
                <TD>
                <IMG src="images/book_003.gif" width="142" height="97"> 
            </TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD class=small vAlign=top align=left><FONT                   color=#000000>若想改变购买图书数量，请改变数量标题下的数字，然后点击“更新订单”按钮；若想去掉购买的图书，请在“删除”标题下打上勾，然后点击“更新订单”按钮。</FONT> 
                </TD></TR>
              <TR>
                <TD>
                  <TABLE cellSpacing=0 cellPadding=2 width="747" 
                  bgColor=#336699 border=0 valign="top" style="border-collapse: collapse" bordercolor="#111111">
                    <TBODY>
                    <TR bgColor=#dcf0d5 height=15>
                      <TD class=normal bgcolor="#336699" width="358" align="center">
                      <b><font color="#FFFFFF">书 名</font></b></TD>
                      <TD class=normal width=124 bgcolor="#336699" align="center">
                      <b><font color="#FFFFFF">数量</font></b></TD>
                      <TD class=normal width="87" bgcolor="#336699" align="center">
                      <b><font color="#FFFFFF">单价（元）</font></b></TD>
                      <TD class=normal width="87" bgcolor="#336699" align="center">
                      <b><font color="#FFFFFF">小计（元）</font></b></TD>
                      <TD class=normal width=71 bgcolor="#336699" align="center">
                      <b><font color="#FFFFFF">删除此项</font></b></TD></TR>
                      
                  
     <%if(shopCartList != null ){

       for(int i = 0;i < shopCartList.size();i++)
       {  
       		shopCart = (ShopCart)shopCartList.get(i);
       %>
                 
                      
                    <TR vAlign=center align=middle bgColor=#ffffff>
                      <TD class=x13 align=left width="358">&nbsp;<FONT color=#666666><%=shopCart.getName()%> </FONT>
                      <INPUT 
                        type=hidden value=白色在白色之上 name=prdname> </TD>
                      <TD width="124">
                      
                       <INPUT maxLength=3 size=3 value=<%=shopCart.getCount()%> 
                        name=count> </TD>
                      <TD width="87"><FONT color=#666666><%=shopCart.getSalePrice()%></FONT> </TD>
                      <TD class=basketDescription width="87"><FONT 
                        color=#666666><%=shopCart.getSalePrice()*shopCart.getCount()%></FONT> </TD>
                      <TD width="71">
                      <INPUT type=checkbox value=<%=shopCart.getId()%> name=del> </TD>
                      </TR>
                     
           <%
         }
      }
      %>
                      
                      
                    <TR align=middle bgColor=#ffffff>
                      <TD class=small align=left width="358"><FONT 
                        color=#000000>单击“更新订单”按钮可以改变购买数量或删除购买记录。</FONT></TD>
                      <TD align=middle width="124"><input type="image" src="images/book_005.gif"></A></TD>
                      <TD align=right colSpan=2 width="178"><B></B></TD>
                      <TD align=middle width="71"><B></B></TD></TR>
                    </TBODY></TABLE>
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" 
                  bgColor=#ffffff border=0>
                    <TBODY>
                    <TR>
                      <TD><A 
                        href="bookSearch.do" >
                      <IMG alt=继续购书 
                        src="images/book_007.gif" border=0 width="69" height="25"></A> 
                        &nbsp;&nbsp;&nbsp;&nbsp; <A href="clearShopCart.do">
                      <IMG alt=清空购物车 
                        src="images/book_006.gif" border=0 width="69" height="25"></A> </TD></TR>
                    <TR>
                      <TD class=small align=right><FONT 
                        color=#000000>点击“</FONT><A 
                        href="userLogin.jsp"><FONT 
                        color=#ff0000>结算付款</FONT></A><FONT 
                        color=#000000>”，本站购物向导将陪您轻松完成网上订购！</FONT> </TD></TR>
                    <TR>
                      <TD align=right><A id=next 
                        href="userLogin.jsp" >
                      <IMG alt=结算付款 
                        src="images/book_008.gif" align=right 
                        border=0 width="69" height="25"></A> 
        </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM></TD></TR></TBODY></TABLE></TD></TR></TABLE></TD></TR></TABLE><BR>
<TABLE width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <HR width="90%" SIZE=1>
    </TD></TR>
  <TR>
    <TD height=20>
  </TBODY></TABLE></BODY></HTML>