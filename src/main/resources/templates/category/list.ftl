<html>
    <#include "../common/head.ftl">
    <body>
    <div id ="wrapper" class="toggled">
        <#include "../common/nav.ftl">
        <div id ="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>类目id</th>
                                <th>名称</th>
                                <th>TYPE</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list categoryList as category>
                            <tr>
                                <td>${category.categoryId}</td>
                                <td>${category.categoryName}</td>
                                <td>${category.categoryType}</td>
                                <td>${category.createTime}</td>
                                <td>${category.updateTime}</td>
                                <td><a href="/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                            </tr>
                            </#list>
                            <#--<#list categoryList.content as category>-->
                            <#--<tr>-->
                                <#--<td>${category.categoryId}</td>-->
                                <#--<td>${category.productName}</td>-->
                                <#--<td>${category.productType}</td>-->
                                <#--<td>${category.createTime}</td>-->
                                <#--<td>${category.updateTime}</td>-->
                                <#--<td><a href="/seller/category/index?categoryId=${category.categoryId}">修改</td>-->
                            <#--</tr>-->
                            <#--</#list>-->
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>



    </body>
</html>