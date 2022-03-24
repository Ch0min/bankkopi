package com.opgave.banktorsdag;

import DomainObjects.Konto;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletKontosFront", value = "/ServletKontosFront")
public class ServletKontosFront extends HttpServlet {
    
    Map<String, Konto> kontosMap = new HashMap<>();

    public void init() {
        Konto konto1 = new Konto("t","t", 10000);   // Test account
        Konto konto2 = new Konto("Denis","1", 15442);
        Konto konto3 = new Konto("Mark","1", 100270);
        Konto konto4 = new Konto("Long","1", 153);
        Konto konto5 = new Konto("Kristoffer","1", 1500);
        Konto konto6 = new Konto("Søren","1", 2157);
        
        kontosMap.put(konto1.getName(), konto1);
        kontosMap.put(konto2.getName(), konto2);
        kontosMap.put(konto3.getName(), konto3);
        kontosMap.put(konto4.getName(), konto4);
        kontosMap.put(konto5.getName(), konto5);
        kontosMap.put(konto6.getName(), konto6);
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("kontosMap", kontosMap);

        String msg = "Her er en oversigt over alle kontoer";

        request.setAttribute("msg", msg);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}