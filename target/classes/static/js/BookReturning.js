layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#returnTable',
        url: '#',
        page: true,
        title: '归还记录表',
        limit: 30,
        cols:[[ {field: 'bookName', title: '图书名称', align: 'center', unresize: true}
            , {field: 'borrowTime', title: '借阅时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.borrowtime, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'returnTime', title: '应还时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.returntime, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'press', title: '出版者', align: 'center', unresize: true}
            , {field: 'bookshelf', title: '书架', align: 'center', unresize: true}
            , {field: 'price', title: '价格', align: 'center', unresize: true}
            , {field : 'right', title : '完成归还', align : 'center', toolbar : '#barDemo'}
        ]],
    });

    $('searchreaderbtn').on('click',function () {
        $.ajax({
            url : '#',
            dataType : 'json',
            data : {
                barcode:$('barcode').val()
            },
            type : 'post',
            success : function(res) {
                $('#readerName').val(res.readerName);
                $('#sex').val(res.sex);
                $('#readerType').val(res.readerType);
                $('#IDType').val(res.IDType);
                $('#IDNumber').val(res.IDNumber);
                $('#borrownumber').val(res.borrownumber);
            }
        });
    });

    //监听行工具事件
    table.on('tool(returnBook)', function (obj) {
        var data = obj.data;
        if (obj.event === 'return') {
            $.ajax({
                type: "POST",
                url: "#",
                data: {
                    bookName:data.bookName
                },
                success: function (res) {
                    if (res === "fail") {
                        layer.msg('归还失败，请重新操作', {icon: 6, time: 1500});

                    } else {
                        layer.msg('归还成功', {icon: 6, time: 1500});

                    }
                }
            });
        }
    });


});