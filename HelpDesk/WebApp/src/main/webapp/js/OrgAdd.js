/**
 * Created by Maxim_Ozarovskiy on 21.03.2017.
 */


var main = {
    add_Org: function () {
        var organName = document.getElementById("OrgName").value;
        var orgAdress = document.getElementById("OrgAdress").value;
        var orgNumber = document.getElementById("OrgNumber").value;
        var departName = document.getElementById("DepName").value;

        $.ajax({
            type: "POST",
            url: "/HelpDesk",
            dataType: "json",
            data: {
                requestType: "Organization",
                organName: organName,
                orgAdress: orgAdress,
                orgNumber: orgNumber,
                departName: departName
            },
            success: function (data) {
                console.log(data);
            }
        });
    }
};