
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    String firstVal="";
    String secondVal="";
    String name="";
    String length="";
    String result="";
    for(Cookie cookie:cookies) {
        if(cookie.getName().equals("cFirstValue")) {
            firstVal=cookie.getValue();
        }
        if(cookie.getName().equals("cSecondValue")) {
            secondVal=cookie.getValue();
        }
        if(cookie.getName().equals("cResult")) {
            result=cookie.getValue();
        }
        if(cookie.getName().equals("cName")) {
            name=cookie.getValue();
        }
        if(cookie.getName().equals("cLength")) {
            length=cookie.getValue();
        }
    }
    System.out.println("here");
    System.out.println(firstVal);
    System.out.println(secondVal);
    System.out.println(name);
%>


<html>
<head>
    <title>Calculate</title>
</head>
<body>
    <form id="myForm" method="post" action="<%=request.getContextPath()+"/CalServlet"%>">
        <table cellspacing="20">
            <tr>
                <td>First val: <input type="text" name="firstVal" id="firstVal" onchange="hint1()" value=<%=firstVal%>></td>
                <td>Enter a name: <input type="text" name="name" id="name" onchange="hint3()" value=<%=name%>></td>
            </tr>
            <tr>
                <td>Second val: <input type="text" name="secondVal" id="secondVal" onchange="hint2()" value=<%=secondVal%>></td>
                <td>Length:<input type="text" name="length" id="length"value=<%=length%>></td>
            </tr>
            <tr>
                <td>Result: <input type="text" name="result" id="result" value=<%=result%>>
            </tr>
        </table>
        <br>
        <input type="submit" value="Add" name="1">
        <input type="submit" value="Subtract" name="2">
        <input type="submit" value="Multiply" name="3">
        <input type="submit" value="Divide" name="4">
        <input type="submit" value="Compute Length" name="5">
        <input type="button" value="Reset" onclick="allreset()">
    </form>
    <script>
        function hint1() {
            var value = document.getElementById("firstVal").value;
            for(var i=0;i<value.length;i++) {
                if((value[i]<"0"||value[i]>"9")&&value[i]!=".") {
                    alert("All should be number");
                    return false;
                }
            }
            return true;
        }
        function hint2() {
            var value = document.getElementById("secondVal").value;
            for(var i=0;i<value.length;i++) {
                if((value[i]<"0"||value[i]>"9")&&value[i]!=".") {
                    alert("All should be number");
                    return false;
                }
            }
            return true;
        }
        function hint3() {
            var value = document.getElementById("name").value;
            for(var i=0;i<value.length;i++) {
                if((value[i]<"a"||value[i]>"z")&&(value[i]<"A"||value[i]>"Z")) {
                    alert("All should be word");
                    return false;
                }
            }
            return true;
        }
        function allreset() {
            $("#myForm").find('input[type=text],select').each(function() {
                $(this).val('');
            });
        }
    </script>
</body>

</html>
