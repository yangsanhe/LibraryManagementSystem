layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#borrowMessage',
        height: 312,
        width: 1065,
        url: '#',
        id: 'borrowRecordReload',
        page: true,
        limit: 30,
        cols: [[
            {field: 'bookBarcode', title: '图书条形码', align: 'center', unresize: true}
            , {field: 'bookName', title: '图书名称', align: 'center', unresize: true}
            , {field: 'readerBarcode', title: '读者条形码', align: 'center', unresize: true}
            , {field: 'readerName', title: '读者名称', align: 'center', unresize: true}
            , {field: 'borrowTime', title: '借阅时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.createdate, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'returnTime', title: '应还时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.createdate, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'ifReturn', title: '是否归还', align: 'center', unresize: true}
        ]]
    });
    var $ = layui.$,
        active = {
            reload: function () {
                var content = $('#content');
                var startTime = $('#time1');
                var endTime = $('#time2');
                var basis = $('basis');

                if(basis.val()=="图书条形码"){
                    //执行重载
                    table.reload('borrowRecordReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        },
                        where: {
                            bookBarcode: content.val(),
                            startTime: startTime.val(),
                            endTime: endTime.val(),
                        }
                    });

                }else if(basis.val()=="图书名称"){
                    //执行重载
                    table.reload('borrowRecordReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        },
                        where: {
                            bookName: content.val(),
                            startTime: startTime.val(),
                            endTime: endTime.val(),
                        }
                    });

                }else if(basis.val()=="读者条形码"){
                    //执行重载
                    table.reload('borrowRecordReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        },
                        where: {
                            readerBarcode: content.val(),
                            startTime: startTime.val(),
                            endTime: endTime.val(),
                        }
                    });

                }else{
                    //执行重载
                    table.reload('borrowRecordReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        },
                        where: {
                            readerName: content.val(),
                            startTime: startTime.val(),
                            endTime: endTime.val(),
                        }
                    });
                }
            }
        };
    $('#searchBorrowRecord').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});