let id = document.getElementById("memberid").value;
let pw = document.getElementById("memberpw").value;
let name = document.getElementById("membername").value;
let phone = document.getElementById("phone").value;

function check() {
    if (id.length < 3 || id.length > 10) {
        alert("ID는 3~10자로 입력하세요.");
        return false;
    } else if (pw.length < 3 || pw.length > 10) {
        alert("비밀번호는 3~10자로 입력하세요.");
        return false;
    } else if (name == "") {
        alert("이름을 입력하세요.");
        return false;
    } else if (phone == "") {
        alert("전화번호를 입력하세요");
        return false;
    }
    return true;
}

function reset() {
    id = "";
    pw = "";
    name = "";
    phone = "";
}
