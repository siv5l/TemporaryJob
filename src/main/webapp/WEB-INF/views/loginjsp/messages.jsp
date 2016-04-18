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
</head>
<body>
    <div id="messageContainer">

        <div id="fromTitle">
            <div id="personsBox">
                Persons
            </div>
            <div id="listBox">
                <c:forEach var="entry" items="${messageUsers}">
                    <div class="userInputMsg">
                        <a href="/messages/${entry.key}">
                            <c:out value="${entry.key}"/>
                        </a>

                    </div>
                </c:forEach>
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
                    <div id="msgLink">
                        <a id="getMsgLink" href="/retrievemessage" >Get</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
