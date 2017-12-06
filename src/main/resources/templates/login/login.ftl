<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <strong >${msg!""}</strong>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="get" action="/seller/login">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label><input name = "username" type="text" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input name ="password" type="password" class="form-control" id="exampleInputPassword1" />
                </div>
                  <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>