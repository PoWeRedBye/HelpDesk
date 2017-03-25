/**
 * Created by Ferotekh-Service on 15.03.2017.
 */
var main = {


    regist: function () {
        var login = document.getElementById("login").value;
        var password = document.getElementById("password").value;
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        //var customertype = document.getElementsByName("customertype").value;

        $.ajax({
            type: "POST",
            url: "/HelpDesk",
            dataType: "json",
            data: {
                requestType: "registration",
                login: login,
                password: password,
                firstName: firstName,
                lastName: lastName
            },
            success: function (data) {
                console.log(data);
                document.location.href = 'index.html';
            }
        });
    },


    log_in: function () {
        var login = document.getElementById("login").value;
        var password = document.getElementsByName("password").value;
        $.ajax({
            type: "POST",
            url: "/HelpDesk",
            dataType: "json",
            data: {requestType: "log_in", login: login, password: password},
            success: function (data) {
                if (data.name == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'single.html';
                window.onload = function () {
                    document.getElementById("name").innerHTML = data.name;
                    document.getElementById("index").innerHTML = data.indexNumber;
                }

            }
        });
    }


};