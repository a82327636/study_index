<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加卡片</title>
    <%@ include file="/view/back/common/include.jsp"%>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="get" class="form-horizontal">
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">卡片标题：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"> <span class="help-block m-b-none">卡片的概括</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">提问：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"> <span class="help-block m-b-none">用于自我测试</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">情景：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"> <span class="help-block m-b-none">帮助建立神经关联</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2  control-label">卡片内容：</label>
                            <div class="col-sm-8">
                                <textarea id="ccomment" name="comment" class="form-control" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">卡片类型：</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="account">
                                    <option>源头卡</option>
                                    <option>启蒙卡</option>
                                    <option>领悟卡</option>
                                    <option>金句卡</option>
                                    <option>概念卡</option>
                                    <option>反常识卡</option>
                                    <option>人民卡</option>
                                </select>
                                <div class="col-sm-4 m-l-n">
                                    <select class="form-control" multiple="">
                                        <option>源头卡</option>
                                        <option>启蒙卡</option>
                                        <option>领悟卡</option>
                                        <option>金句卡</option>
                                        <option>概念卡</option>
                                        <option>反常识卡</option>
                                        <option>人民卡</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="submit">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
</body>

</html>
