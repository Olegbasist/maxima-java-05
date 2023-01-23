package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cat")
public class Servlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String isAngry = request.getParameter("angry");


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        try {
            printWriter.write("<h2>Встречайте - " +name + "</h2><p>" + catInfo(name,weight,name) + "</p>");
        } catch (IncorrectCatWeightException e) {
            throw new RuntimeException(e);
        }

        printWriter.flush();
        printWriter.close();
    }
    private String catInfo (String name, String weight, String angry) throws IncorrectCatWeightException {
        int intWeight = Integer.parseInt(weight);
        boolean isAngry = Boolean.getBoolean(angry);
        Cat cat = new Cat(name, intWeight,isAngry);

        return cat.toString();
    }
}
