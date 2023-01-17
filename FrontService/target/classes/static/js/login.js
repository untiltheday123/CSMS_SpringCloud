// 销售员
const signInBtn = document.getElementById("signIn");
// 管理员
const signUpBtn = document.getElementById("signUp");

// // 这两是登录
// const fistForm = document.getElementById("form1");
// //管理
// const secondForm = document.getElementById("form2");
// //销售

// const btn1 = document.getElementById("#btn1")
// const btn2 = document.getElementById("#btn2")

const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

// btn1.addEventListener("click", submit("1"));
// btn2.addEventListener("click", submit("2"));
// fistForm.addEventListener("submit", (e) => e.preventDefault());
// secondForm.addEventListener("submit", (e) => e.preventDefault());


function submit_(type) {
    // alert("111111111111111111111111")
    var uid = "#username"
    var pid = "#password"
    // alert("您已于其他设备登录");
    var username = document.querySelector(uid + type).value;
    // alert("uid+type="+uid+type)
    var password = document.querySelector(pid + type).value;
    // alert(username)
    // alert(password)
    // alert("type="+type)

    if (type === "1") {
        var manager = {
            manaUsername: username,
            manaPassword: password
        }
        axios.post("http://localhost:10010/managers", manager).then((res) => {
            if (res.data.code === 20041) {
                sessionStorage.setItem("manaId", res.data.data.manaId);
                sessionStorage.setItem("manaUsername", res.data.data.manaUsername);
                sessionStorage.setItem("manaName", res.data.data.manaName);

                location.href = "index_manager.html";
            } else if (res.data.code === 20040) {
                alert("用户名或密码输入有误！！！")
            } else {
                alert("系统繁忙！请稍后再试。。。")
            }
        })
    }
    else{
        var salesman = {
            saleUsername: username,
            salePassword: password
        }
        axios.post("http://localhost:10010/salesmen", salesman).then((res) => {
            if (res.data.code === 20041) {
                sessionStorage.setItem("saleId", res.data.data.saleId);
                sessionStorage.setItem("saleUsername", res.data.data.saleUsername);
                sessionStorage.setItem("saleName", res.data.data.saleName);

                location.href = "index_sale.html";
            } else if (res.data.code === 20040) {
                alert("用户名或密码输入有误！！！")
            } else {
                alert("系统繁忙！请稍后再试。。。")
            }
        })
    }
// else {

// }

}