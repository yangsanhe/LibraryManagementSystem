layui.use('table', function() {
    var $ = layui.$;
    var table = layui.table;
    table.render({
        elem: '#test'
        , url: 'system/getAllManager'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , title: '管理员权限表'
        , cols: [[
             {field: 'adminname', title: '管理员名称', align: 'center', unresize: true}
            , {field: 'systemset', title: '系统设置', align: 'center', unresize: true}
            , {field: 'readersmanage', title: '读者管理', align: 'center', unresize: true}
            , {field: 'vbooksmanage', title: '图书管理', align: 'center', unresize: true}
            , {field: 'borrowingbooks', title: '图书借还', align: 'center', unresize: true}
            , {field: 'systemquery', title: '系统查询', align: 'center', unresize: true}
            , {title: '操作', toolbar: '#barDemo', align: 'center', unresize: true}
        ]]
        , page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        layer.open({
            type: 2,
            title: '添加管理员信息',
            area: ['500px', '320px'],
            offset: '150px',
            btn: ['保存', '关闭'],
            shadeClose: true,
            shade: 0.4,
            resize: false,
            maxmin: true,
            content: 'addAdministrator',
            yes: function (index, layero) {
                $.ajax({
                    type: "POST",
                    url: "#",
                    data: $("#add-admin-form").serialize(),
                    success: function (res) {
                        if (res === "fail") {
                            layer.msg('添加失败，请重新输入', {icon: 6, time: 1500});

                        } else {
                            layer.msg('添加成功', {icon: 6, time: 1500});
                        }
                    }
                });
                layer.close(index);
            },
            cancel: function (index, layero) {
                layer.close(index);
            }
        })
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: '修改管理员权限',
                area: ['450px', '450px'],
                offset: '50px',
                btn: ['保存', '取消'],
                shadeClose: true,
                resize: false,
                shade: 0.4,
                maxmin: true,
                content: 'setPermission',
                success: function (layero, index) {
                    var body = layer.getChildFrame('body',
                    index);
                    /**
                     * 从数据库读 或者 根据父表格渲染
                     */
                    // body.find("#readerName").val(
                    //     res.readerName);
                    // body.find('input[name=systemSet][value=男]').attr("checked",res.sex=='男' ? true : false);
                    // body.find('input[name=sex][value=女]').attr("checked",res.sex=='女' ? true : false);

                    layui.form.render();
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#edit-permission-form").submit();
                    obj.update({
                        // readerName: body.find(
                        //     "#readerName").val(),
                        // readerType: body.find(
                        //     "#readerType").val(),
                        // IDType: body.find(
                        //     "#IDType").val(),
                        // IDNumber: body.find(
                        //     "#IDNumber").val(),
                        // telephone: body.find(
                        //     "#telephone").val(),

                    });
                    layer.close(index);
                },
                cancel: function (index, layero) {
                    layer.close(index);
                }
            })
        }
    });
});