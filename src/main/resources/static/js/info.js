function deleteBoard(boardnum) {
    if (confirm("삭제하시겠습니까?")) {
        location.href = "delete?boardnum=" + boardnum;
    }
}

function buyItem(boardnum) {
    if (confirm("구매하시겠습니까?")) {
        location.href = "buyItem?boardnum=" + boardnum;
    }
}
