<%--
  Created by IntelliJ IDEA.
  User: bkniroula
  Date: 12/1/15
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
</head>
<body>

<input type="button" id="button" value="punch me" onclick="This()">
<br/>
<br/>
<label id="lbl1"></label><br/>
<label id="lbl2"></label><br/>
<label id="lbl3"></label><br/>
<label id="lbl4"></label><br/>

<script type="text/javascript">

    var myJSONObject = {"ircEvent": "PRIVMSG", "method": "newURI", "regex": "^http://.*"};

    var object;

    //adding value to json object
    for (var i = 0; i < 20; i++) {

        myJSONObject.object = "object" + i;

    }

    //adding value to json array
    var array = [1, 2]
    var object;
    for (var i = 0; i < 20; i++) {
        array.push("object" + i);

    }

    //adding array to json object
    myJSONObject.array = array;
    var url = "jsonObject";
   //var url = "jsonArray";

    if(url == "jsonArray"){

        myJSONObject = array;
    }

    function This() {
        $.ajax({

            url: url,
            data: JSON.stringify(myJSONObject), // JSON.stringify need to use in order to received by server
            dataType: "json", // receiving data type from server
            contentType: "application/json",// sending data type to server
            type: "post",
            success: function (data) {
                var ind = 1;

                if (url == "jsonArray") {
                    // using JsonArray
                    for (var j = 0; j < data.length; j++) {
                        console.log(data[j]);
                        $("#lbl" + (j + 1)).text(data[j]);

                    }

                } else {


                    //Using map or json object
                    $.each(data, function (i, item) {
                        console.log(i + " :  " + item);
                        $("#lbl" + ind).text(i + " :  " + item);
                        ind++;
                    });
                }

            },
            error: function (data) {
                console.log("error:", data);
            }
        });
    }


</script>

</body>
</html>
