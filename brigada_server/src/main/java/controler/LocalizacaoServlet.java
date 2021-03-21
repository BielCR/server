/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.LocalizacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Localizacao;
import tools.Resposta;

/**
 *
 * @author gabri
 */
public class LocalizacaoServlet extends HttpServlet {

    private void envio (HttpServletRequest request, PrintWriter out){
        
        //Recebendo os request
        String latitudeTxt = request.getParameter("latitude");
        String longitudeTxt = request.getParameter("longitude");
        
        //checando se os valores foram passados
        if(latitudeTxt == null || longitudeTxt == null){
            
        }else{
            
            //verificando se os valores passados são numéricos ou do tipo Date
            try{
                //validando os atributos
                Date agora =  new Date();
                double latitude = Double.parseDouble(latitudeTxt);
                double longitude = Double.parseDouble(longitudeTxt);
                
                //instanciando a localiza  
                Localizacao novaLocalizacao = new Localizacao(latitude, longitude, agora);
                LocalizacaoDAO.enviarLocalizacao(novaLocalizacao);
                //localizacao enviada com sucesso
                out.println(new Resposta(200, "Envio realizado com sucesso: "+latitude + " / " + longitude + ": "+ agora));
            }catch(NumberFormatException ex){
                out.println(new Resposta(404, "Os valores têm que ser de tipo numerico"));
            }
            
           
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          //enviar localizacao
          String servico = request.getParameter("servico");
            if(servico == null){
                //exibir uma mensagem especificando que o servico está nulo
                out.println("serviço não foi especificado");
            }else{
                switch (servico){
                    case "envio":{
                        envio(request, out);
                    }break;
                    default :{
                        out.println("Serviço não disponível para o usuário");
                    }
                }
            }
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
