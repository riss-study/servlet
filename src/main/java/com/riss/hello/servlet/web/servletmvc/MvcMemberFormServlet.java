package com.riss.hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);   //servlet -> jsp 호출 (제어권을 이 경로의 jsp 에게 넘겨줌)
        // => 서버 안에서 내부적으로 함수 호출하듯이 호출 (클라이언트에서 호출하는 게 아님) --> 실제 웹브라우저 url 보면 http://~~~.jsp 가 아닌 현재 서블릿 url 에서 머무름
        // WEB-INF 속의 자원들은 외부에서 호출 안되고, 컨트롤러 등에서 forward 같은 걸 해서 호출해야 볼 수 있음 (WAS 에서 그렇게 정해놈)
    }
}
