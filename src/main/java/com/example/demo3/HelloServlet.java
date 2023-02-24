package com.example.demo3;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form method='post' action='hello-servlet' >"+
                       "<input name='name'>"+"</br>"+
                       "<input name='details'>"+"</br>"+
                       "<button name='submit' value='submit'>Submit</button>"+
                     "</form>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}