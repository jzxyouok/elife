<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tendina.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<title>后台主界面</title>
</head>
<body>
	<!--顶部-->
    <div class="top">
            <div style="float: left">
			<span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #fff">e生活后台管理中心</h1></span>
			</div>
            <div id="ad_setting" class="ad_setting">
                <a class="ad_setting_a" href="javascript:; ">某某管理员</a>
                <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i>个人中心</a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i>设置</a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
                </ul>
                <img class="use_xl" src="images/right_menu.png" />
            </div>
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="left-menu">
        <ul id="menu">
            <li class="menu-list">
               <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>商品管理<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="../../goodsservlet?type=7" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            商品排行
                        </a>
                    </li>
                    <li>
                        <a href="../../classservlet?type=1" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                           分类管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
                <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>社区管理<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="Topic.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            话题管理
                        </a>
                    </li>
                    <li>
                        <a href="News.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                           说说管理 
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
                <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>管理员管理<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="Admin.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            管理员管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
               <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>活动管理<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="/elife/queryBanner" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                           轮播图管理
                        </a>
                    </li>
                    <li>
                        <a href="Coupon.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
		代金券管理
                        </a>
                    </li>
                </ul>
            </li>
            
             <li class="menu-list">
                <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>用户管理<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="ManageUser.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                          用户管理
                        </a>
                    </li>
                    <li>
                        <a href="ManageBusiness.jsp" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                           商家管理 
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
    </div>
    
    <!--菜单右边的iframe页面-->
    <div id="right-content" class="right-content" >
        <div class="content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame" src="default.jsp" style="overflow:visible;"
                        scrolling="no" frameborder="no" width="100%" height="90%"></iframe>
            </div>
        </div>
    </div>
</body>
</html>
