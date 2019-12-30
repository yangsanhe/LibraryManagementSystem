layui.use('table', function() {
    var $ = layui.$;
    var table = layui.table;
    table.render({
        elem: '#test'
        , url: 'book/getAllBooks'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , title: '读者信息表'
        , cols: [[
            {field: 'bookbarcode', title: '条形码', align: 'center', unresize: true}
            , {field: 'bookname', title: '图书名称', align: 'center', unresize: true}
            , {field: 'booktype', title: '图书类型', align: 'center', unresize: true}
            , {field: 'author', title: '作者', align: 'center', unresize: true}
            , {field: 'translator', title: '译者', align: 'center', unresize: true}
            , {field: 'press', title: '出版者', align: 'center', unresize: true}
            , {field: 'price', title: '价格', align: 'center', unresize: true}
            , {field: 'pagenumber', title: '页码', align: 'center', unresize: true}
            , {field: 'bookshelf', title: '书架', align: 'center', unresize: true}
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
            title: '添加图书信息',
            area: ['550px', '550px'],
            offset: '50px',
            btn: ['保存', '关闭'],
            shadeClose: true,
            shade: 0.4,
            resize: false,
            maxmin: true,
            content: 'addBook',
            yes: function (index, layero) {
                var body = layer.getChildFrame('body', index);
                console.log(body.find("#add-book-form").serialize());
                $.ajax({
                    type: "POST",
                    url: "book/addBook",
                    data: body.find("#add-book-form").serialize(),
                    success: function (res) {
                        if (res.success) {
                            layer.msg('添加成功！', {icon: 6, time: 1500});

                        } else {
                            layer.msg('添加失败', {icon: 6, time: 1500});
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
                $.ajax({
                    type: "POST",
                    url: "book/deleteBookType",
                    data:{
                        bookbarcode : data.bookbarcode
                    },
                    success: function (res) {
                        if (res.success) {
                            layer.msg('删除成功！', {icon: 6, time: 1500});

                        } else {
                            layer.msg('删除失败', {icon: 6, time: 1500});
                        }
                    }
                });
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
                content: 'editBookMessage',
                success: function (layero, index) {
                    var body = layer.getChildFrame('body',
                                index);
                    body.find("#bookbarcode").val(
                        data.barcode);
                    body.find("#bookname").val(
                        data.bookname);
                    body.find("#booktype").val(
                        data.booktype);
                    body.find("#author").val(
                        data.author);
                    body.find("#translator").val(
                        data.translator);
                    body.find("#press").val(
                        data.press);
                    body.find("#price").val(
                        data.price);
                    body.find("#pagenumber").val(
                        data.pagenumber);
                    body.find("#bookshelf").val(
                        data.bookshelf);
                    layui.form.render();
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#edit-book-form").submit();
                    obj.update({
                        bookname: body.find(
                            "#bookname").val(),
                        booktype: body.find(
                            "#booktype").val(),
                        author: body.find(
                            "#author").val(),
                        translator: body.find(
                            "#translator").val(),
                        press: body.find(
                            "#press").val(),
                        price: body.find(
                            "#price").val(),
                        pagenumber: body.find(
                            "#pagenumber").val(),
                        bookshelf: body.find(
                            "#bookshelf").val(),
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