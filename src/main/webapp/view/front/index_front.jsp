<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>前台主页</title>
    <%@ include file="/view/back/common/include.jsp"%>
</head>

<body class="gray-bg top-navigation">

<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom white-bg">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <i class="fa fa-reorder"></i>
                    </button>
                    <a href="#" class="navbar-brand">INDEX</a>
                </div>
                <div class="navbar-collapse collapse" id="navbar">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a aria-expanded="false" role="button" href="${ctx}/view/front/index_front.jsp">首页</a>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="${ctx}/view/front/index_front_faq.jsp"> 自我测试</a>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 随机展示</a>
                        </li>
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 卡包展示</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <a href="login.html">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="wrapper wrapper-content animated fadeInUp">
                            <ul class="notes">
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>HTML5 文档类型</h4>
                                        <p>Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型。在你项目中的每个页面都要参照下面的格式进行设置。</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>移动设备优先</h4>
                                        <p>在 Bootstrap 2 中，我们对框架中的某些关键部分增加了对移动设备友好的样式。而在 Bootstrap 3 中，我们重写了整个框架，使其一开始就是对移动设备友好的。这次不是简单的增……</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>排版与链接</h4>
                                        <p>Bootstrap 排版、链接样式设置了基本的全局样式。分别是： 为 body 元素设置 background-color: #fff; 使用 @font-family-base、@font-size-base 和……。</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>Normalize.css</h4>
                                        <p>为了增强跨浏览器表现的一致性，我们使用了 Normalize.css，这是由 Nicolas Gallagher 和 Jonathan Neal 维护的一个CSS 重置样式库。</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>布局容器</h4>
                                        <p>Bootstrap 需要为页面内容和栅格系统包裹一个 .container 容器。我们提供了两个作此用处的类。注意，由于 padding 等属性的原因，这两种 容器类不能互相嵌套。</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <small>2014年10月24日(星期五) 下午5:31</small>
                                        <h4>栅格系统</h4>
                                        <p>Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。它包含了易于使用的预定义类，还有强大的mixin 用于生成更具语义的布局。</p>
                                        <a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>
