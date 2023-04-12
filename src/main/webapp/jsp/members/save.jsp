<%@ page import="com.riss.hello.servlet.domain.member.Member" %>
<%@ page import="com.riss.hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response 는 그냥 사용 가능 (jsp 도 결국 서블릿으로 자동 변환 후 사용되기 때문에 가능 -> 서비스 로직이 그대로 호출된다고 생각하면 됨)
    MemberRepository memberRepository=MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
