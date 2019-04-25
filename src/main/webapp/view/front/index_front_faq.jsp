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
                        <li class="dropdown">
                            <a aria-expanded="false" role="button" href="${ctx}/view/front/index_front.jsp">首页</a>
                        </li>
                        <li class="active">
                            <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 自我测试</a>
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

                            <div class="ibox-content m-b-sm border-bottom">
                                <div class="text-center p-lg">
                                    <h2>自我测试，真实反馈,先看问题，再看答案</h2>
                                </div>
                            </div>

                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq1" class="faq-question">俄狄浦斯情节</a>
                                        <small><strong>故事</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">美女</span>
                                            <span class="tag-item">国家</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq1" class="panel-collapse collapse faq-answer">
                                            <p>
                                                通俗地讲是指人的一种心理倾向，喜欢和母亲在一起的感觉。恋母情结并非爱情，而大多产生于对母亲的一种欣赏敬仰。
                                                <br>是一种普遍的社会现象，男孩女孩都可能有恋母情结。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq2" class="faq-question">亚当斯密是谁</a>
                                        <small><strong>人物</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">男士</span>
                                            <span class="tag-item">英国</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq2" class="panel-collapse collapse faq-answer">
                                            <p>
                                                1723年他出生于苏格兰一个海关官员的家庭，14岁考入格拉斯哥大学，学习数学和哲学，并对经济学产生兴趣。17岁时转入牛津大学。毕业后，1748年到爱丁堡大学讲授修辞学与文学。
                                                <br>1751～1764年回格拉斯哥大学执教，期间他的伦理学讲义经修订在1759年以《道德情操论》为名出版，为他赢得了声誉
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq3" class="faq-question">索引卡片真的好用吗？</a>
                                        <small><strong>事例</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">人物</span>
                                            <span class="tag-item">经验</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq3" class="panel-collapse collapse faq-answer">
                                            <p>
                                                纳博科夫和钱钟书。前者依靠卡片拼接出文学史上著名的小说作品，后者通过积累读书卡片和索引成为中国近现代博闻强识的学者典范。钱钟书一生写过十万张卡片
                                                <br>从 1929 年考入清华外文系算起到 1998 年 12 月去世结束，70 年间，平均每年 1429 张卡片，按 365 天计算平均每天 3.91 张卡片，可以想象，钱钟书一生通过卡片习得了怎样海量的知识。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq4" class="faq-question">刻意练习为啥是刻意？</a>
                                        <small><strong>知识</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">学习方法</span>
                                            <span class="tag-item">学习时间</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq4" class="panel-collapse collapse faq-answer">
                                            <p>
                                                我们的心智可以分为舒适区、学习区、恐慌区，我们喜欢在舒适区里面呆着，但是这样只会越来越懒惰而失去竞争力，因此我们
                                                <br> 需要在专注的情景下，刻意控制自己远离舒适进入学习区，学习。如果不刻意而随意，那我们只会再度回归到舒适区。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq5" class="faq-question">容器为什么出现</a>
                                        <small><strong>技能</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">网络</span>
                                            <span class="tag-item">部署</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq5" class="panel-collapse collapse faq-answer">
                                            <p>
                                                没有容器的时候，我们部署环境需要拷贝各个项目中运用的进程，如果需要部署的机器过多时，这样一台一台很花费时间，而且如果出现问题
                                                <br>也不能很快的解决，就是所谓的扩展性和可用性都不好。容器像一个集装箱，把一个工程需要的所有进程环境装起来，而且可以轻易拷贝。
                                                <br>再互联网企业非常实用。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="faq-item">
                                <div class="row">
                                    <div class="col-md-7">
                                        <a data-toggle="collapse" href="faq.html#faq6" class="faq-question">万物互联与物联网友区别吗？</a>
                                        <small><strong>趋势</strong> <i class="fa fa-clock-o"></i> 今天15:34</small>
                                    </div>
                                    <div class="col-md-3">
                                        <span class="small font-bold">关键词</span>
                                        <div class="tag-list">
                                            <span class="tag-item">未来科技</span>
                                            <span class="tag-item">革命</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div id="faq6" class="panel-collapse collapse faq-answer">
                                            <p>
                                                目前各种传感器已经非常普遍，如：家电、服装、行车、住宿....，这是不是意味着未来的万物互联就是在所有物品上增加传感器呢？
                                                <br>绝不止如此，物联网还是物品上互联网，但万物互联应该不分物品，而只一个一个ID，这是一种思维革命，并不容易理解。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){$("#loading-example-btn").click(function(){btn=$(this);simpleLoad(btn,true);simpleLoad(btn,false)})});function simpleLoad(btn,state){if(state){btn.children().addClass("fa-spin");btn.contents().last().replaceWith(" Loading")}else{setTimeout(function(){btn.children().removeClass("fa-spin");btn.contents().last().replaceWith(" Refresh")},2000)}};
</script>
</body>

</html>
