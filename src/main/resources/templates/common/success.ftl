<html>
<head>
    <meta charset="utf-8">
    <title>操作成功</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    ${msg!""}
                </h4> <strong>三秒钟跳回</strong>  <a href="${url}" class="alert-link">alert link</a>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    setTimeout('location.href="${url}"', 3000);
</script>

</html>