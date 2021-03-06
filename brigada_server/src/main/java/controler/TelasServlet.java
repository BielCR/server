package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import model.Tela;
import dao.TelaDAO;
import tools.FabricaConexao;
import tools.Resposta;

/**
 *
 * @author gabri
 */

public class TelasServlet extends HttpServlet {
    
    private void leitura(HttpServletRequest request, PrintWriter out){
        String idStr = request.getParameter("id");
        if(idStr != null){
            try{
                int id = Integer.parseInt(idStr);
                Tela temp = TelaDAO.exibeTela(id);
                out.println(new Resposta(200, temp));
            }catch(NumberFormatException ex){
                out.println(new Resposta(403, "Para exibir a leitura é necessári informar o id;"));
            }
        }else{
            
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String servico = request.getParameter("servico");
            if(servico == null){
                //exibir uma mensagem especificando que o servico está nulo
                out.println("serviço não foi especificado");
            }else{
                switch (servico){
                    case "leitura":{
                        leitura(request, out);
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
