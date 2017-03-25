/**
 * Created by Ferotekh-Service on 15.03.2017.
 */

var main = {
        add_ticket: function () {
            var ticket_type = document.getElementById("ticket_type").value;
            var category = document.getElementById("category").value;
            var description = document.getElementById("description").value;
            var datetime = $("#date").value;
            var type = "add_ticket";
            var index = 1;
            var getid = main.get_id();
            $.ajax({
                type: "POST",
                url: "/HelpDesk",
                dataType: "json",
                data: {
                    requestType: "Ticket",
                    type: type,
                    ticket_type: ticket_type,
                    index: index,
                    datetime: datetime,
                    category: category,
                    description: description,
                    detid: getid
                },
                success: function (data) {
                    console.log(data);
                }
            });
        },
//данна ху*ня вроде должна тянуть id из cookie
        get_id: function () {
            var match = document.cookie.match('(?:^|;)\\s*_ga=([^;]*)');
            var raw = (match) ? decodeURIComponent(match[1]) : null;
            if (raw) {
                match = raw.match(/(\d+\.\d+)$/);
            }
            var gacid = (match) ? match[1] : null;
            if (gacid) {
                return gacid;
            }
        }

    };
/*

 $.ajax({
 cache: false,
 type: 'POST',
 url: {API сервера},
 data: {объект с данными формы},
 success: function(data){
 // 1. нужно скрыть модальное окно ручками

 // 2. дорисовать новый тикет

 // найти список тикетов
 var obj = $(класс или ID списка тикетов);

 // дописать в конец то, что пришло от сервера
 // в data
 obj.html(obj.html() + data);
 }
 });*/
