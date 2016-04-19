<%--
  Created by IntelliJ IDEA.
  User: siv5l
  Date: 4/12/16
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes.jsp"%>

<html>
<head>
    <title>Messages</title>
    <link href="/resources/css/messagesStyle.css" rel="stylesheet" />


    <script type="text/javascript"
            src="http://code.jquery.com/jquery-2.2.2.min.js"> /* 1.10.1*/
    </script>

    <script type="text/javascript">
        function crunchifyAjax() {
            $.ajax({
                type: "GET",
                url : '/retrievemessage',
                dataType : 'json', // deodata vine in json, eu nu trebuie sa fac parse to json
                success : function(data) {
                    var output = "";
                    for (var i in data) {
                        output += "<div class=\"";
                        output += "userInputMsg\">";
                        output += "<a href=\"/messages/";
                        output += i;
                        output += "\"";
                        output += ">";
                        output += i;
                        output += "</a>";
                        output += "</div>";
                    }
                        $('#listBox').html(output);
                        console.log(output);
                }
            })
        }
    </script>

    <script type="text/javascript">
        var intervalId = 0;
        intervalId = setInterval(crunchifyAjax, 500);
    </script>

</head>
<body>
    <div id="messageContainer">

        <div id="fromTitle">
            <div id="personsBox">
                Persons
            </div>
            <div id="listBox">
                <%--// is coming async request from jQuery--%>
            </div>
        </div>

        <div id="messageContent">
            <div id="contentTitle">
                Content
            </div>
            <div id="contentText">
                <form id="messageForm" action="/insertmessage" method="post">

                    <div id="whomDiv">
                        <input id="inputWhom" type="text" name="toWhom"/>
                    </div>

                    <div id="outputBox">    
                        <c:forEach  items="${messagesArray}" var="message">
                            <div id="fullMessage">
                                <div id="fullContent">
                                    <c:out value="${message.from}" />:
                                    <c:out value="${message.contentMsg}"/>
                                </div>
                               <!-- <div id="fullDate">
                                    <c:out value="${message.date.toString()}"/>
                                </div>-->
                            </div>
                        </c:forEach>
                    </div>
                    
                    <div id="outputMsgBox">
                        <input type="text" id="msgToSend" name="sendMessage" />
                    </div>
                    
                    <div id="sendDiv">
                        <input type="submit" id="btnSend" value="send" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
