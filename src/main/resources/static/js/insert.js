function check() {
    let t = document.getElementById("title").value;
    let c = document.getElementById("content").value;

    if (t.length < 5) {
        alert("제목을 입력하세요.");
        return false;
    } else if (c.length < 5) {
        alert("내용을 입력하세요.");
        return false;
    }
    return true;
}
