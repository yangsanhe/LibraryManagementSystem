layui.use('table', function(){
    var $=layui.$;
    var table = layui.table;
    table.render({
        elem: '#test'
        ,url:'#'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,title: '读者类型信息表'
        ,cols: [[
            {field:'readerType', title:'读者类型', align:'center', unresize: true}
            ,{field:'number', title:'可借数量', align:'center', unresize: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:'center', unresize: true}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        layer.open({
            type : 2,
            title : '添加读者类型信息',
            area : [ '450px', '210px' ],
            offset : '150px',
            btn : [ '保存', '关闭' ],
            shadeClose : true,
            shade : 0.4,
            resize : false,
            maxmin : true,
            content : 'addReaderType',
            success : function(layero, index) {
                var body = layer.getChildFrame('body',
                    index);
                body.find("#TypeName").val("");
                body.find("#BorrowNumber").val("");
                layui.form.render();
            },
            yes : function(index, layero) {
                $.ajax({
                    type:"POST",
                    url:"#",
                    data:$("#add-readertype-form").serialize(),
                    success:function(res){
                        if(res==="fail"){
                            layer.msg('保存失败，请重新输入', {icon: 6,time: 1500});

                        }else{
                            layer.msg('保存成功', {icon: 6,time: 1500});
                        }
                    }
                });
                layer.close(index);
            },
            cancel : function(index, layero) {
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
            });
        } else if(obj.event === 'edit'){
            layer.open({
                type : 2,
                title : '修改读者类型信息',
                area : [ '450px', '210px' ],
                offset : '150px',
                btn : [ '确认', '取消' ],
                shadeClose : true,
                resize : false,
                shade : 0.4,
                maxmin : true,
                content : 'editReaderType',
                success : function(layero, index) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#typename").val(
                        data.typename);
                    body.find("#borrownumber").val(
                        data.borrownumber);
                    layui.form.render();
                },
                yes : function(index, layero) {
                    var body = layer.getChildFrame('body',
                        index);
                    body.find("#edit-readertype-form").submit();
                    obj.update({
                        typetname : body.find(
                            "#typetname").val(),
                        borrownumber : body.find(
                            "#borrownumber").val(),
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