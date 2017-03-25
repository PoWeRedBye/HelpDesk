/**
 * Created by Ferotekh-Service on 15.03.2017.
 */
$(document).ready(function(){
    $("#my-tab a").click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
});