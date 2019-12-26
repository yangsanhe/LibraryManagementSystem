layui.use('table', function() {
    var $ = layui.$;
    var table = layui.table;
    table.render({
        elem: '#test'
        , url: '#'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , title: '读者信息表'
        , cols: [[
            {field: 'barcode', title: '条形码', align: 'center', unresize: true}
            , {field: 'readerName', title: '姓名', align: 'center', unresize: true}
            , {field: 'readerType', title: '读者类型', align: 'center', unresize: true}
            , {field: 'IDType', title: '证件类型', align: 'center', unresize: true}
            , {field: 'IDNumber', title: '证件号码', align: 'center', unresize: true}
            , {field: 'telephone', title: '电话', align: 'center', unresize: true}
            , {field: 'email', title: 'Email', align: 'center', unresize: true}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', align: 'center', unresize: true}
        ]]
        , page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        layer.open({
            type: 2,
            title: '添加读者信息',
            area: ['550px', '550px'],
            offset: '50px',
            btn: ['保存', '关闭'],
            shadeClose: true,
            shade: 0.4,
            resize: false,
            maxmin: true,
            content: 'addReader',
            yes: function (index, layero) {
                $.ajax({
                    type: "POST",
                    url: "#",
                    data: $("#add-reader-form").serialize(),
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
                title: '修改读者信息',
                area: ['550px', '550px'],
                offset: '50px',
                btn: ['确认', '取消'],
                shadeClose: true,
                resize: false,
                shade: 0.4,
                maxmin: true,
                content: 'editReaderMessage',
                success: function (layero, index) {
                    $.ajax({
                        url : '#',
                        dataType : 'json',
                        data : {
                            barcode:data.barcode
                        },
                        type : 'post',
                        success : function(res) {
                            var body = layer.getChildFrame('body',
                                index);
                            body.find("#readerName").val(
                                res.readerName);
                            body.find('input[name=sex][value=男]').attr("checked",res.sex=='男' ? true : false);
                            body.find('input[name=sex][value=女]').attr("checked",res.sex=='女' ? true : false);
                            body.find("#barcode").val(
                                res.barcode);
                            body.find("#readerType").val(
                                res.readerType);
                            body.find("#job").val(
                                res.job);
                            body.find("#birthday").val(
                                res.birthday);
                            body.find("#IDType").val(
                                res.IDType);
                            body.find("#IDNumber").val(
                                res.IDNumber);
                            body.find("#telephone").val(
                                res.telephone);
                            body.find("#email").val(
                                res.email);
                            body.find("#desc").val(
                                res.desc);
                            layui.form.render();
                        }
                    });
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#edit-reader-form").submit();
                    obj.update({
                        readerName: body.find(
                            "#readerName").val(),
                        readerType: body.find(
                            "#readerType").val(),
                        IDType: body.find(
                            "#IDType").val(),
                        IDNumber: body.find(
                            "#IDNumber").val(),
                        telephone: body.find(
                            "#telephone").val(),
                        email: body.find(
                            "#email").val(),
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