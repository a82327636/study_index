<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>学习索引后台 - 主页</title>
    <%@ include file="/view/back/common/include.jsp"%>
    <meta name="keywords" content="学习索引后台 ">
    <meta name="description" content="学习索引后台 ">

    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->



</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="${ctx}/static/back/img/profile_small.jpg" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${user_account}</strong></span>
                                <span class="text-muted text-xs block">${user_name}</span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">S
                    </div>
                </li>
                <li>
                <li><a href="${ctx}/view/front/index_front.jsp" target="_blank"><i class="fa fa-columns"></i>前台主页</a></li>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">基本信息</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">修改头像</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">个人等级</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-envelope"></i>
                        <span class="nav-label">卡片管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="${ctx}/view/back/addcard.jsp">新增卡片</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片类型</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片关键词</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-edit"></i>
                        <span class="nav-label">卡片包管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">新增卡片包</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片包列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片包关键词</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-flask"></i>
                        <span class="nav-label">系统设置</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片提醒设置</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">卡片情景设置</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">用户等级设置</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-desktop"></i>
                        <span class="nav-label">统计分析</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">日卡片统计</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">月卡片统计</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="graph_echarts.html">年卡片统计</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <li><a class="J_menuItem" href="${ctx}/view/back/addcard.jsp"><i class="fa fa-table"></i>操作手册</a></li>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab">主页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${ctx}/login" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/view/back/search_results.jsp" frameborder="0"  seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
    </div>
</div>
</body>

</html>