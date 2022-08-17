package com.lirik.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Жизненный цикл servlet состоит из трех стадий, указанных в классе!!!
 * В аннотации @WebServlet мы указываем endpoint по которому будет доступен этот Servlet (в браузере пишем localhost:8081/first и
 * увидим сообщение)
 */

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramValue = req.getParameter("param");
        Map<String, String[]> parameterMap = req.getParameterMap();

        req.getHeader("user-agent");   // возвращает header по ключу
        Enumeration<String> headerNames = req.getHeaderNames();  // возвращает все header
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header);
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name()); // так тоже можно установить кодировку
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("Hello from first servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap(); // передаем параметры запроса в боди с помощью метода POST
        System.out.println(parameterMap);

        try (BufferedReader reader = req.getReader(); // передали текст в теле запроса
             Stream<String> lines = reader.lines()) {
            lines.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
