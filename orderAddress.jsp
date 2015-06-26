<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ page import = "BookStore.*" %>
<%@ page import = "java.util.*" %>	
<%
	User user = (User)session.getAttribute(Constants.LOGIN_USER_INFO_KEY);
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
      <FORM name=BasketForm action="addrConfirm.do" 
      method=post>
      <INPUT type=hidden value=2 name=txtOrigQty> <INPUT 
                        type=hidden value=白色在白色之上 name=prdname> 
      <TABLE cellSpacing=0 cellPadding=8 width="100%" align=center 
        border=0><INPUT type=hidden name=OP> 
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD>
                <IMG src="images/book_046.gif" width="122" height="84"></TD>
                <TD align=middle width=400 
                background=images/book_004.gif>
                <IMG 
                  src="H:\Struts交稿\bookstore\images\spacer(1).gif" width="1" height="1"> </TD>
                <TD>
                <IMG src="images/book_003.gif" width="142" height="97"> 
            </TD></TR></TBODY></TABLE></TD></TR>
        <tr>
          <TD align=right width="90%">
            <TABLE cellSpacing=0 cellPadding=0 width="612" align=right 
border=0 height="92">
              <TBODY>
              <TR>
                <TD align=left colSpan=2 height=20 width="612"><FONT class=large 
                  color=#0d7999>您的注册信息:</FONT></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>姓名：&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getName()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>联系地址：&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getAddress()%></TD>
                </TR>
              <TR>
                <TD class=p9 vAlign=top align=right 
                  width="106" height="18"><B>电话：&nbsp;</B></TD>
                <TD class=p9 width="506" height="18"><%=user.getTel()%></TD>
                </TR></TBODY></TABLE></TD>
        </tr>
        <TR>
          <TD>
			  <table cellSpacing="0" cellPadding="0" width="612" align="right" border="0" height="92">
              <tr>
                <td align="left" height="20" width="206">
                <font class="large" color="#0d7999">您的送货方式:</font></td>
                <td align="left" height="20" width="1018">　</td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="送货上门" name="deliv" checked>送货上门</font><b>：&nbsp;</b></td>
                <td class="p9" width="912" height="18"> 
					<font class="small">四环路以外(含西三旗、回龙观、天通苑、亦庄东高地、管庄、石景山部分地区)或四环路以内加急配送(加急需电话确认62269575)。每份订单收<font color="red">10元</font>送货费。</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small"><input type="radio" value="快递包裹" name="deliv" >快递包裹</font></td>
                <td class="p9" width="912" height="18"> 
					<font class="small">快递费为图书原价的<font color=red>20%</font>，不足<font color=red>20元</font>按<font color=red>20元</font>计算。</font>
                </td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small"><input type="radio" value="大陆挂号邮寄" name="deliv" >大陆挂号邮寄</font>
                </td>
                <td class="p9" width="912" height="18"> 
					<font class="small">邮费为图书原价的<font color=red>8%</font>，不足<font color=red>5元</font>按<font color=red>5元</font>计算。(<font color="red">购物超过200元,邮费8折</font>)</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="EMS特快专递" name="deliv" >EMS特快专递</font>
                </td>
                <td class="p9" width="912" height="18"> 
					<font class="small">按每单所选购图书原价的<FONT color=red>75%</FONT>收取EMS特快专递的费用，不足25.00元按
<FONT color=red>25.00</FONT>元计。</font></td>
              </tr>
            </table>
            <p>　</TD></TR>
        <TR>
          <TD>
            <table cellSpacing="0" cellPadding="0" width="612" align="right" border="0" height="92">
              <tr>
                <td align="left" height="20" width="206">
                <font class="large" color="#0d7999">您的付款方式:</font></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="现金支付" name="payment" checked ></font>现金支付<b>：&nbsp;</b></td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="邮寄" name="payment" ></font>邮寄</td>
              </tr>
              <tr>
                <td class="p9" width="100" height="18"><font class="small">
                <input type="radio" value="银行卡" name="payment" ></font>银行卡 
                </td>
              </tr>
            </table>
            <p>　</TD></TR>
        <TR>
          <TD>
            <p align="center">
            <input type="image" src="images/book_038.gif" width="76" height="30"></TD></TR></TBODY></TABLE></FORM></TD></TR></TBODY></TABLE></TD></TR></TABLE></TD></TR></TABLE><BR>
<TABLE width=763 align=center border=0>
  <TBODY>
  <TR>
    <TD>
      <HR width="90%" SIZE=1>
    </TD></TR>
  <TR>
    <TD height=20>
      </TD></TR>
  </TBODY></TABLE></BODY></HTML>