<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A</title>
    <%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
    <%session.setAttribute("页面" , "A");%>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
    <link href="${APP_PATH }/comm/bootstrap-3.3.7-dist/css/bootstrap.min.css"  rel="stylesheet">
    <script src="${APP_PATH }/comm/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--表格--%>
<div class="row">
    <div class="col-md-12">
        <table class="table table-striped" id="stu_table">
            <thead>
            <tr>
                <th>　</th>
                <th><input type="checkbox" id="check_all"/></th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>专业</th>
                <th>系别</th>
                <th>宿舍楼号</th>
                <th>宿舍号</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>

            </tbody>
        </table>
    </div>
</div>

</body>
<script type="text/javascript">
    $(function () {
        // 一进来就加载首页
        to_page(1);

    });

    // 发送请求的函数
    function to_page(pn) {
        $.ajax({
            type: 'GET',
            data:"pn="+pn,
            dataType:"json",
            url:"${APP_PATH}/Stu/getAll",
            cache: false,
            async: true,
            success: function(result) {
                build_stu_table(result);
            }
        });
    }


    function build_stu_table(result) {
        $("#stu_table tbody").empty();//清空页面元素的一个方法，保证每次都清空再加载
        var stu=result.extend.PageInfo.list;
        $.each(stu,function (idnex,item) {
            var space=$("<td></td>").append(　);
            var chackBoxId = $("<td><input type='checkbox' class='check_item' /></td>");
            var stuIdTd = $("<td></td>").append(item.studentId);
            var stuName = $("<td></td>").append(item.studentName);
            var genderTd = $("<td></td>").append(item.studentGender=="0" ? "男" : "女");
            var professionName = $("<td></td>").append(item.pro.professionName);
            var professionDepartment = $("<td></td>").append(item.pro.professionDepartment);
            var buildingName = $("<td></td>").append(item.dorm.buildingName);
            var dormitoryName = $("<td></td>").append(item.dorm.dormitoryName);
            var button1 = $("<button></button>").addClass("btn btn-primary btn-sm update_bth")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
                .append("编辑");
            var button2 = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash"))
                .append("删除");
            var buttonAdd = $("<td></td>").append(button1).append(" ").append(button2);
            $("<tr></tr>")
                .append(space)
                .append(chackBoxId)
                .append(stuIdTd)
                .append(stuName)
                .append(genderTd)
                .append(professionName)
                .append(professionDepartment)
                .append(buildingName)
                .append(dormitoryName)
                .append(buttonAdd)
                .appendTo("#stu_table tbody");
        });
    }

</script>
</html>
