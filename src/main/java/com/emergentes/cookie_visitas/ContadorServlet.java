package com.emergentes.cookie_visitas;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int contador = 0;
    
    Cookie cookies[] = request.getCookies();
    
    if(cookies != null) {
      for(Cookie c : cookies) {
        if(c.getName().equals("visitas")) {
          contador = Integer.parseInt(c.getValue());
        }
      }
    }
    contador++;
    
    Cookie c = new Cookie("visitas", Integer.toString(contador));
    c.setMaxAge(30);
    response.addCookie(c);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("Visitante N° " + contador);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  
  }
}
