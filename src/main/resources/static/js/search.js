function init() {
    $.ajax({
        url: "listAll",
        type: "get",
        dataType: "json",
        success: function (b) {
            let str = `
            <table><tr><th>번호</th><th>카테고리</th><th>제목</th></tr>;
            `;
            $(b).each(function (index, item) {
                str += `<tr>`;
                str += `<td>${item.boardnum}</td>`;
                str += `<td>${item.category}</td>`;
                str += `<td>${item.title}</td>`;
                str += `</tr>`;
            });
            str += `</table>`;
            $("#contentsArea").html(str);
        },
        error: function () {},
    });
}

function searchWord() {
    let keyword = $("#keyword").val();
    let category = $("#category option:selected").val();

    $.ajax({
        url: "searchWord",
        type: "post",
        data: { keyword: keyword, category: category },
        success: function (list) {
            let str = "<table><tr><th>번호</th><th>카테고리</th><th>제목</th></tr>";
            $(list).each(function (i, ob) {
                str += "<tr>";
                str += "<td>" + ob.boardnum + "</td>";
                str += "<td>" + ob.category + "</td>";
                str += "<td>" + ob.title + "</td>";
                str += "</tr>";
            });
            str += "</table>";
            $("#contentsArea").html(str);
        },
        error: function (e) {
            console.log(JSON.stringify(e));
        },
    });
}

function searchCategory() {
    let keyword = $("#keyword").val();
    let category = $("#category option:selected").val();

    if (keyword != null || keyword != "") {
        searchWord();
        return;
    }

    if (category == "all") {
        init();
    }

    $.ajax({
        url: "searchCategory",
        type: "post",
        data: { category: category },
        success: function (list) {
            let str = "<table><tr><th>번호</th><th>카테고리</th><th>제목</th></tr>";
            $(list).each(function (i, ob) {
                str += "<tr>";
                str += "<td>" + ob.boardnum + "</td>";
                str += "<td>" + ob.category + "</td>";
                str += "<td>" + ob.title + "</td>";
                str += "</tr>";
            });
            str += "</table>";
            $("#contentsArea").html(str);
        },
        error: function (e) {
            console.log(JSON.stringify(e));
        },
    });
}
