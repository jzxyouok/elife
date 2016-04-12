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
               <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>产品与服务<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="企业资料管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            企业资料管理
                        </a>
                    </li>
                    <li>
                        <a href="产品管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                            产品管理(石材等)
                        </a>
                    </li>
                    <li>
                        <a href="我的微网站.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right3"></i>
                            我的微网站
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
                <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>产品与服务<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="企业资料管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            企业资料管理
                        </a>
                    </li>
                    <li>
                        <a href="产品管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                            产品管理(石材等)
                        </a>
                    </li>
                    <li>
                        <a href="我的微网站.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right3"></i>
                            我的微网站
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
                <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>产品与服务<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="企业资料管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            企业资料管理
                        </a>
                    </li>
                    <li>
                        <a href="产品管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                            产品管理(石材等)
                        </a>
                    </li>
                    <li>
                        <a href="我的微网站.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right3"></i>
                            我的微网站
                        </a>
                    </li>
                </ul>
            </li>

            <li class="menu-list">
               <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>产品与服务<s class="sz"></s></a>
                <ul>
                    <li>
                        <a href="企业资料管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right1"></i>
                            企业资料管理
                        </a>
                    </li>
                    <li>
                        <a href="产品管理.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right2"></i>
                            产品管理(石材等)
                        </a>
                    </li>
                    <li>
                        <a href="我的微网站.html" target="menuFrame">
                            <i class="glyph-icon icon-chevron-right3"></i>
                            我的微网站
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
    </div>
    
    <!--菜单右边的iframe页面-->
    <div id="right-content" class="right-content">
        <div class="content">
            <div id="page_content">
                <iframe id="menuFrame" name="menuFrame" src="企业资料管理.html" style="overflow:visible;"
                        scrolling="no" frameborder="no" width="100%" height="90%"></iframe>
            </div>
        </div>
    </div>
</body>
</html>