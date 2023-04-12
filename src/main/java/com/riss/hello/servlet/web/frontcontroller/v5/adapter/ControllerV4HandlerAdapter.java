package com.riss.hello.servlet.web.frontcontroller.v5.adapter;

import com.riss.hello.servlet.web.frontcontroller.ModelView;
import com.riss.hello.servlet.web.frontcontroller.MyView;
import com.riss.hello.servlet.web.frontcontroller.v4.ControllerV4;
import com.riss.hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        ModelView mv = creteModelView(model, viewName);

        return mv;
    }

    private static ModelView creteModelView(Map<String, Object> model, String viewName) {
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);
        return mv;
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap=new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
