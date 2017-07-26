/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.Operacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sistemas-16
 */
public class Sumando extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Capturando lo parametros enviados por index.htmlñ
        String tnum1 = request.getParameter("num1");
        String tnum2 = request.getParameter("num2");
        
        // COnversion de los parametros a enteros
        int num1 = Integer.parseInt(tnum1);
        int num2 = Integer.parseInt(tnum2);
        
        // Llamo a la clase Operacion para sumar
        Operacion ope = new Operacion();
        int resultado = ope.sumar(num1, num2);
        
        // Agregando atributos al request para que el JSP los muestre
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);        
        request.setAttribute("respuesta", resultado);
        
        // Despachar el servlet a un archivo JSP
        // Crear el objeto que permite realizar el Dispatcher
        RequestDispatcher despacha;
        // Obtener el Dispatchet de request con el archivo JSP
        despacha = request.getRequestDispatcher("mostrar.jsp");
        // Reenviar el request al recurso establecido en getRequestDispatcher
        despacha.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
