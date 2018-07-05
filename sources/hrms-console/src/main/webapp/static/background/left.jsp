<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script>
var he=document.body.clientHeight-105
document.write("<div id=tt style=height:"+he+";overflow:hidden>")
</script>

<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="${pageContext.request.contextPath}/static/images/left_2.gif">

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="19%">&nbsp;</td>
        <td width="81%" height="20"><span class="STYLE1">管理菜单</span></td>
      </tr>
    </table></td>

  </tr>
  <tr>
    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>
        <!-- -----------------------开始-------------------------------------- -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="${pageContext.request.contextPath}/static/images/left_title.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">系统管理</td>
              </tr>
            </table>
            </td>
          </tr>
          <tr>
            <td background="${pageContext.request.contextPath}/static/images/main_51.gif" id="submenu1" style="DISPLAY: none">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title_l.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="authority/department/DepartmentList.jsp" target="mainFrame"  style="text-decoration:none" >部门管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title_l.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="authority/role/RoleList.jsp" target="mainFrame" style="text-decoration:none">角色管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title_l.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="authority/person/PersonList.jsp" target="mainFrame" style="text-decoration:none">用户管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title_l.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="authority/module/ModuleList.jsp" target="mainFrame" style="text-decoration:none">模块管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title_l.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="authority/log/LogList.jsp" target="mainFrame" style="text-decoration:none">日志列表</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="${pageContext.request.contextPath}/static/images/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table></div></td>
          </tr>
          
        </table>
        <!-- -----------------------结束-------------------------------------- -->
        
        <!-- -----------------------开始-------------------------------------- -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="${pageContext.request.contextPath}/static/images/left_title.gif" id="imgmenu2" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(2)" onMouseOut="this.className='menu_title';" style="cursor:hand">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">菜单管理</td>
              </tr>
            </table>
            </td>
          </tr>

          <tr>
            <td background="${pageContext.request.contextPath}/static/images/main_51.gif" id="submenu2" style="DISPLAY: none">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">

                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23">
                      <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">

                            <span class="STYLE3"><a href="${pageContext.request.contextPath}/city/selectAllCity" target="mainFrame" style="text-decoration:none">所在城市</a></span></td>

                        </tr>
                    </table>
                    </td>
                  </tr>

                    <tr>
                      <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td width="84%" height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">

                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/exptime/queryAll" target="mainFrame" style="text-decoration:none">工作年限</a></span></td>

                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td width="84%" height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/field/queryAll" target="mainFrame" style="text-decoration:none">行业领域</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td width="84%" height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/jobtype/queryAll" target="mainFrame" style="text-decoration:none">职位类型</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td width="84%" height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/massagetype/queryAll" target="mainFrame" style="text-decoration:none">接收消息状态</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                            <span class="STYLE3"><a href="${pageContext.request.contextPath}/resumetype/queryAll" target="mainFrame" style="text-decoration:none">接收简历状态</a></span></td>
                        </tr>
                    </table></td>
                  </tr>

                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                            <span class="STYLE3"><a href="${pageContext.request.contextPath}/salary/queryAll" target="mainFrame" style="text-decoration:none">期望月薪</a></span></td>
                        </tr>
                    </table></td>
                  </tr>

                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                            <span class="STYLE3"><a href="${pageContext.request.contextPath}/scale/queryAll" target="mainFrame" style="text-decoration:none">公司规模</a></span></td>
                        </tr>
                    </table></td>
                  </tr>

                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23">
                      <table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                            <span class="STYLE3"><a href="${pageContext.request.contextPath}/stage/queryAll" target="mainFrame" style="text-decoration:none">公司发展阶段</a></span></td>
                        </tr>
                    </table>
                    </td>
                  </tr>

                    <tr>
                      <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/status/liststatus" target="mainFrame" style="text-decoration:none">求职状态</a></span>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/tag/queryAll" target="mainFrame" style="text-decoration:none">公司标签</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/xueli/listxueli" target="mainFrame" style="text-decoration:none">最高学历</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                      <td height="23">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="20" background="${pageContext.request.contextPath}/static/images/left_title.gif" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                              <span class="STYLE3"><a href="${pageContext.request.contextPath}/year/listyear" target="mainFrame" style="text-decoration:none">工作年限</a></span></td>
                          </tr>
                    </table>
                      </td>
                    </tr>

                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="${pageContext.request.contextPath}/static/images/main_52.gif" width="151" height="5" /></td>
              </tr>

            </table></div></td>
          </tr>
          
        </table>
        <!-- -----------------------结束-------------------------------------- -->

        <!-- -----------------------开始-------------------------------------- -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="${pageContext.request.contextPath}/static/images/left_title.gif" id="imgmenu4" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(4)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">招聘管理</td>
              </tr>
            </table>
            </td>
          </tr>
          <tr>
            <td background="${pageContext.request.contextPath}/static/images/main_51.gif" id="submenu4" style="DISPLAY: none">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="engage/majorIssueList.jsp" target="mainFrame" style="text-decoration:none">职位发布</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="engage/NewEngageResumeList.jsp" target="mainFrame" style="text-decoration:none">简历管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="${pageContext.request.contextPath}/static/images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="engage/examList.jsp" target="mainFrame" style="text-decoration:none">考试管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="${pageContext.request.contextPath}/static/images/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table></div></td>
          </tr>
          
        </table>
        </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
        <!-- -----------------------结束-------------------------------------- -->

<script>

function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="${pageContext.request.contextPath}/static/images/left_title.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="${pageContext.request.contextPath}/static/images/left_title.gif";
}
}
</script>
