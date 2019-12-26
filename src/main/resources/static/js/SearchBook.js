layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#booktable',
        height: 312,
        width: 1065,
        url: '#',
        id: 'bookReload',
        page: true,
        limit: 30,
        cols: [[
            {field: 'barcode', title: '条形码', align: 'center', unresize: true}
            , {field: 'bookName', title: '图书名称', align: 'center', unresize: true}
            , {field: 'bookType', title: '图书类型', align: 'center', unresize: true}
            , {field: 'author', title: '作者', align: 'center', unresize: true}
            , {field: 'translator', title: '译者', align: 'center', unresize: true}
            , {field: 'press', title: '出版者', align: 'center', unresize: true}
            , {field: 'price', title: '价格', align: 'center', unresize: true}
            , {field: 'pageNumber', title: '页码', align: 'center', unresize: true}
            , {field: 'bookshelf', title: '书架', align: 'center', unresize: true}
        ]]
    });
    var $ = layui.$,
        active = {
            reload: function () {
                var barcode = $('#barcode');
                var bookName = $('#bookName');
                var bookType = $('#bookType');
                var author = $('#author');
                var press = $('#press');
                var bookshelf = $('#bookshelf');
                //执行重载
                table.reload('bookReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    },
                    where: {
                        barcode: barcode.val(),
                        bookName: bookName.val(),
                        bookType: bookType.val(),
                        author: author.val(),
                        press: press.val(),
                        bookshelf: bookshelf.val()
                    }
                });
            }
        };
    $('#searchbookbtn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});