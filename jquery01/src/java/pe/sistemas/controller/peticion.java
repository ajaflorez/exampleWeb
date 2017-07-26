/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistemas.controller;

//import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joao
 */
@WebServlet(name = "peticion", urlPatterns = {"/peticion"})
public class peticion extends HttpServlet {

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
        //---- Respuesta ---
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // Map de parametros
        Map<String,String[]> reqParams = request.getParameterMap();
        // Map de respuesta
        Map<String, Object> resReturns = new HashMap<>();
        //Gson gson = new Gson();
        String json;
        
        String[] notas = (String[])reqParams.get("notas[]");
        
        for(int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
        }        
        
        if (reqParams != null) {
            Set setParams = reqParams.keySet(); // Obtener el conjunto de keys
            Iterator<String> iterParams = setParams.iterator(); // Iteratos de keys
            while (iterParams.hasNext())
            {
                String key = (String)iterParams.next();  // obtiene el nombre(key) del parametro
                String[] values = (String[])reqParams.get(key);   // obtener el valor del parametro

                if(values.length == 1){
                    resReturns.put(key, values[0]);
                    System.out.println("Parameter Name="+ key + " Value=" + values[0]);
                } 
                else if(values.length > 1) {
                    String[] subvalues = new String[values.length];
                    for (int i = 0; i < values.length; i++) {   // recorrer los valores
                        subvalues[i] = values[i];
                        System.out.println("Parameter Name="+ key + " Value=" + values[i]);
                    }
                    resReturns.put(key, subvalues);
                }
            }
        } 
        
        resReturns.put("id", 100);
        resReturns.put("escuela", "Ing. de sistemas");
        resReturns.put("valor", request.getParameter("email"));
        
        //json = gson.toJson(resReturns);
        
        try (PrintWriter out = response.getWriter()) {
            //out.write(json);
        }        
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
