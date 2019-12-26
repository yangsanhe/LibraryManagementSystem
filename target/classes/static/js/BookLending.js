layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#borrowTable',
        url: '#',
        page: true,
        title: '借阅记录表',
        id : 'borrowReload',
        limit: 30,
        cols:[[ {field: 'bookName', title: '图书名称', align: 'center', unresize: true}
            , {field: 'borrowTime', title: '借阅时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.borrowtime, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'returnTime', title: '应还时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.returntime, 'yyyy-MM-dd')}}</div>", unresize: true}
            , {field: 'press', title: '出版者', align: 'center', unresize: true}
            , {field: 'bookshelf', title: '书架', align: 'center', unresize: true}
            , {field: 'price', title: '价格', align: 'center', unresize: true}
        ]],
    });


        $('#searchbookbtn').on('click', function () {
            form.on('radio(filter)', function(data) {
                var content = $('#content');
                if (data.value == '图书条形码') {
                    $.ajax({
                        url : '#',
                        dataType : 'json',
                        data : {
                            bookbarcode:content.val()
                        },
                        type : 'post',
                        success : function(res) {


                        }
                    });
                } else {
                    $.ajax({
                        url : '#',
                        dataType : 'json',
                        data : {
                            bookName:content.val()
                        },
                        type : 'post',
                        success : function(res) {


                        }
                    });
                }
            });
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


});