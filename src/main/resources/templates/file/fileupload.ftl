<#--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<#--<html>-->
<#--<head>-->
    <#--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
    <#--<script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>-->
    <#--&lt;#&ndash;<script src="js/jquery-1.12.0.min.js"></script>&ndash;&gt;-->
    <#--&lt;#&ndash;<script src="js/jquery.form.js"></script>&ndash;&gt;-->
    <#--<title>Insert title here</title>-->
<#--</head>-->

<#--<body>-->
<#--<form id="upfile">-->
    <#--选择一个文件:-->
    <#--<input type="file" name="file" id="upload" / >-->
    <#--<br/><br/>-->
    <#--<input id="uploadFile" value="上传" type="button"/>-->
<#--</form>-->

<#--<div id="upFile"></div>-->
<#--</body>-->
<#--<script type="text/javascript">-->

    <#--$("#uploadFile").click(function(){-->
        <#--var upload_file = new FormData($("#upfile")[0]);-->
        <#--//formData.set('file', document.getElementById("upload").files[0]);-->
        <#--$.ajax({-->
            <#--url: '/file/upload',-->
            <#--type: 'POST',-->
            <#--cache: false,-->
            <#--data: upload_file,-->
            <#--processData: false,-->
            <#--contentType: false-->
        <#--}).done(function(res) {-->

        <#--});-->
    <#--});-->
<#--</script>-->
<#--</html>-->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Ajax异步上传图片</title>
    <-- 引入jQuery异步上传js文件 -->
    <#--<script src="/resource/jquery.form.js" type="text/javascript"></script>-->
    <script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>


    <!-- Ajax异步上传图片 -->
    <script type="text/javascript">
        function uploadPic() {
            // 上传设置
            var options = {
                // 规定把请求发送到那个URL
                url: "/file/upload",
                // 请求方式
                type: "post",
                // 服务器响应的数据类型
                dataType: "json",
                // 请求成功时执行的回调函数
                success: function(data, status, xhr) {
                    // 图片显示地址
                    $("#allUrl").attr("src", data.pathd);
                }
            };

            $("#jvForm").ajaxSubmit(options);
        }
    </script>
</head>
<body>
<form id="jvForm" action="o_save.shtml" method="post" enctype="multipart/form-data">
    <table>
        <tbody>
        <tr>
            <td width="20%">
                <span>*</span>
                上传图片(90x150尺寸):</td>
            <td width="80%">
                注:该尺寸图片必须为90x150。
            </td>
        </tr>
        <tr>
            <td width="20%"></td>
            <td width="80%">
                <img width="100" height="100" id="allUrl"/>
                <!-- 在选择图片的时候添加事件，触发Ajax异步上传 -->
                <input name="pic" type="file" onchange="uploadPic()"/>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>



































