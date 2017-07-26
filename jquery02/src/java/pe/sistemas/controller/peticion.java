package pe.sistemas.controller;

import com.google.gson.Gson;
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

@WebServlet(name = "peticion", urlPatterns = {"/peticion"})
public class peticion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        //---- Respuesta ---
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // Map de parametros
        Map<String,String[]> reqParams = request.getParameterMap();
        // Map de respuesta
        Map<String, Object> resReturns = new HashMap<>();
        
        Gson gson = new Gson();
        String json;
        
        String[] notas = (String[])reqParams.get("notas[]");
        
        for(int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
        }        
        
        if (reqParams != null) {
            // Obtener el conjunto de keys
            Set setParams = reqParams.keySet(); 
            // Iteratos de keys para el while
            Iterator<String> iterParams = setParams.iterator(); 
            while (iterParams.hasNext())
            {
                // obtiene el nombre(key) del parametro
                String key = (String)iterParams.next();  
                // obtener el valor del parametro
                String[] values = (String[])reqParams.get(key);   

                if(values.length == 1){
                    resReturns.put(key, values[0]);
                    System.out.println("Parameter Name="+ key + 
                            " Value=" + values[0]);
                } 
                else if(values.length > 1) {
                    String[] subvalues = new String[values.length];
                    // recorrer los valores
                    for (int i = 0; i < values.length; i++) {   
                        subvalues[i] = values[i];
                        System.out.println("Parameter Name="+ key + 
                                " Value=" + values[i]);
                    }
                    resReturns.put(key, subvalues);
                }
            }
        } 
        
        resReturns.put("id", 100);
        resReturns.put("escuela", "Ing. de sistemas");
        resReturns.put("valor", request.getParameter("email"));
        
        json = gson.toJson(resReturns);
        
        try (PrintWriter out = response.getWriter()) {
            out.write(json);
        }  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
