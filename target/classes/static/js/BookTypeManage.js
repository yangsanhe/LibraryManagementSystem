layui.use('table', function(){
    var $=layui.$;
    var table = layui.table;
    table.render({
        elem: '#test'
        ,url:'book/getAllBookTypes'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,title: '图书类型信息表'
        ,cols: [[
            {field:'typename', title:'图书类型名称', align:'center', unresize: true}
            ,{field:'borrowdays', title:'可借天数', align:'center', unresize: true}
            ,{title:'操作', toolbar: '#barDemo',align:'center', unresize: true}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        layer.open({
            type : 2,
            title : '添加图书类型信息',
            area : [ '450px', '210px' ],
            offset : '150px',
            btn : [ '保存', '关闭' ],
            shadeClose : true,
            shade : 0.4,
            resize : false,
            maxmin : true,
            content : 'addBookType',
            yes : function(index, layero) {
                var body = layer.getChildFrame('body', index);
                $.ajax({
                    type:"POST",
                    url:"book/addBookType",
                    data:body.find("#add-booktype-form").serialize(),
                    success:function(res){
                        if(res.success){
                            layer.msg('保存成功', {icon: 6,time: 1500});
                        }else{
                            layer.msg('保存失败，请重新输入', {icon: 6,time: 1500});
                        }
                    },
                });
                layui.form.render();
                layer.close(index);
            },
            cancel: function(index, layero) {
                layer.close(index);
            }
        })
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
                $.ajax({
                    type: "POST",
                    url: "book/deleteBookType",
                    data:{
                        id : data.id
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
        } else if(obj.event === 'edit'){
            layer.open({
                type : 2,
                title : '修改图书类型信息',
                area : [ '450px', '250px' ],
                offset : '150px',
                btn : [ '确认', '取消' ],
                shadeClose : true,
                resize : false,
                shade : 0.4,
                maxmin : true,
                content : 'editBookType',
                success : function(layero, index) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#id").val(data.id),
                    body.find("#typename").val(
                        data.typename);
                    body.find("#borrowdays").val(
                        data.borrowdays);
                    layui.form.render();
                },
                yes : function(index, layero) {
                    var body = layer.getChildFrame('body', index);
                    $.ajax({
                        type:"POST",
                        url:"book/editBookType",
                        data:body.find("#edit-bookType-form").serialize(),
                        success:function(res){
                            if(res.success){
                                layer.msg('修改成功', {icon: 6,time: 1500});
                            }else{
                                layer.msg('修改失败，请重新输入', {icon: 6,time: 1500});
                            }
                        },
                    });
                    obj.update({
                        typename : body.find(
                            "#typename").val(),
                        borrowdays : body.find(
                            "#borrowdays").val(),
                    });
                    layer.close(index);
                },
                cancel : function(index, layero) {
                    layer.close(index);
                }
            })
        }
    });
});