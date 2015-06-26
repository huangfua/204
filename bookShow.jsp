<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	Book book = (Book)session.getAttribute(Constants.BOOK_DETAIL_KEY);
%>

<HTML><HEAD><TITLE>图书说明</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><LINK 
href="images/style.css" type="text/css" rel=stylesheet>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center bgColor=#a0c484 
border=0>
  <TBODY>
  <TR>
    <TD>
      <div align="center">
        <center>
      <TABLE  cellSpacing=0 cellPadding=0 width="764" bgcolor="#336699" style="border-collapse: collapse" bordercolor="#111111" >
        <TBODY>
        <TR>
          <TD align=middle width=599>　</TD>
          </TR></TBODY></TABLE></center>
      </div>
    </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=middle width="697"><BR>
      <DIV align=right>
        <img border="0" src="images/00-1.gif" width="82" height="59"><img border="0" src="images/00-2.gif" width="90" height="59"></DIV>&nbsp;&nbsp;&nbsp;<BR>
      <hr>
    <TABLE cellSpacing=0 cellPadding=0 width=625 align=center border=0 height="492">
        <TBODY>
        <TR>
          <TD width=600 height="291">
            <TABLE width=600 border=0>
              <TBODY>
              <TR>
                <TD vAlign=top width=100><IMG height=150 alt=图书封面 
                  src="<%=book.getImage()%>" width=100 align=left border=1 
                  valign="middle"></TD>
                <TD><FONT class=heading3 
                  color=#ff0000><B><%=book.getName()%></B></FONT><BR><B>作者:</B><FONT 
                  color=blue><%=book.getAuthor()%>
                  </FONT>&nbsp;&nbsp; <BR>&nbsp;&nbsp;&nbsp;&nbsp;<FONT                  class=small><%=book.getDescript()%></FONT> 
                  </FONT></TD></TR></TBODY></TABLE>
            <TABLE width=620 border=0 colspan="3">
              <TBODY>
                <TD><FONT class=p9><B>定价: </B><FONT 
                  color=red><%=book.getPrice()%>元</FONT></FONT></TD>
                <TD><FONT class=p9><B>本站价格：</B><FONT color=red><%=book.getSalePrice()%>元 
                  </FONT> </FONT>
                
              <TR>
                <TD align=left colspan="2"><A 
                  href="bookBuy.do?bookId=<%=book.getId()%>"><IMG 
                  height=17 src="images/order.gif" width=54 border=0></A></TD>
                </TR></TBODY></TABLE></TD></TR>
        <TR bgColor=#ececda>
          <TD width=621 height=26 bgcolor="#336699">
            <DIV align=left><FONT color=#FFFFFF><I>目录</I></FONT> </DIV></TD></TR>
        <TR>
          <TD width=620 height="145">
            <UL>
              <P><FONT              class=p9><%=book.getContents()%> 
              </FONT></P></UL></TD></TR>
        <TR>
          <TD height=30><hr>　</TD></TR>
        </TBODY></TABLE></TR></TBODY></TABLE></TD></TR></TABLE>
<TABLE width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <HR width="90%" SIZE=1>
    </TD></TR>
  <TR>
    <TD height=20>
      <DIV align=center></DIV></TD></TR>
  </TBODY></TABLE></BODY></HTML>