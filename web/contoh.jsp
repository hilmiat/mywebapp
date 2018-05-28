<%-- 
    Document   : contoh
    Created on : May 28, 2018, 9:39:11 AM
    Author     : hilmiat
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    //dalam block declaration
    int a = 123;
    String nama = "Adi";
    public void test(){
        System.out.println("hello from jsp");
    }

%>

<%
    //dalam block scriptlet
    int a = 12345;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--directive include dgn kode std jsp-->
        <%@include file="header.jspf" %>
        <!--include dgn tag xml-->
        <jsp:directive.include file="header.jspf">  
        </jsp:directive.include>
        <!--expression dgn xml-->
        <jsp:expression>nama</jsp:expression>
        
        <h1>Hello World!</h1>
        <%=nama%><br/>
        <%=a%><br/>
        <%=this.a%>
    <ul>
        <% for(int i=1;i<=5;i++){ %>
        <li><%=i%></li>
        <% } %>
    </ul>
        <%=new Date()%>
        <%=test()%>
    </body> 
</html>
