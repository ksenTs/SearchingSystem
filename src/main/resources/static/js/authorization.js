// скрипт написан не до конца,долго сидела с валидацией, но набросок имеет место быть



// $.ajax({
//     url:"/getUsers",
//     type: "POST",
//     data:{
//         username:$("#username").val(),
//         password:$("#password").val()
//     },
//     dataType: "json"
// });

//
// function checkInput() {
//
//     var result = false;
//     $(function ()
//     {
//         $("#AsubmitButton").click(
//             function send(){
//                 $.ajax({
//                     url:"/getUsers",
//                     type: "POST",
//                     data:{
//                         username:$("#username").val(),
//                         password:$("#password").val()
//                     },
//                     dataType: "json",
//                     success:
//                         function (jq) {
//
//                             if(jq.length === 0) {
//
//                                 var nameField = document.getElementById("username").value;
//                                 var passwordField = document.getElementById("password").value;
//
//                                 if (nameField.length === 0 || passwordField.length === 0){
//                                     alert("Заполните пустые поля");
//
//
//                                 }
//                                 else{
//                                     alert("Неверный логин или пароль");
//
//                                 }
//
//                             }
//                             else {
//                                 alert("Нашел");
//                                 result = true;
//                             }
//                         }
//                 });
//             }
//         )
//
//     })
//
//     return result;
//
// }
//








function checkInput() {


       $.ajax({
                    url:"/getUsers",
                    type: "POST",
                    data:{
                        var1:$("#AeMail").val(),
                        var2:$("#Apassword").val()
                    },
                    dataType: "json"

   }),
           error:{
        alert("NO");
    }

    var i = 0;
    var email = document.getElementById("AeMail").value;
    if(email === var1)
        i++;
    else
        document.getElementById("AincorrectEMail").setAttribute("style", "color:red");
    var password = $("#Apassword").val();
    if (password === var2)
        i++;
    else
        document.getElementById("AincorrectPassword").setAttribute("style", "color:red");
    if (i === 2)
        document.getElementById("AsubmitButton").setAttribute("type", "submit");
}

function noErrorName() {
    document.getElementById("AincorrectEMail").setAttribute("style", "color:transparent");
    document.getElementById("error").setAttribute("style", "color:transparent");
}

function noErrorPassword() {
    document.getElementById("AincorrectPassword").setAttribute("style", "color:transparent");
    document.getElementById("error").setAttribute("style", "color:transparent");
}

$(function () {
        if (location.search === "?error") {
            $("#error").text("Неверный логин или пароль");
        }
    }
);

