
package model;

//import de models e tools
import model.Tela;
import tools.FabricaConexao;

//imports de sql
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class TelaDAO {
    
    public static Object exibeTela(int id){
        
        String sql = "SELECT * FROM telas WHERE id = " + id + ";";
        try(Connection con = FabricaConexao.criaConexao()){
            
            PreparedStatement transacao = con.prepareStatement(sql);
            return transacao.execute();
            
        }catch(SQLException ex){
            System.err.println("Erro na execução de exibição da tela");
        }
        Object o = "";
        return o;
    }
    
    public static void cadastraTela(Tela novaTela){
        
        String sql = "INSERT INTO telas(id, corpo, imagem, titulo, id_tab) VALUES (?, ?, ?, ?, ?)";
        try(Connection con = FabricaConexao.criaConexao()){
            
            PreparedStatement tran = con.prepareStatement(sql);
            
            //adicionando valores na Statment
            tran.setInt(1, novaTela.getId());
            tran.setString(2, novaTela.getCorpo());
            tran.setString(3, novaTela.getImagem());
            tran.setString(4, novaTela.getTitulo());
            tran.setInt(5, novaTela.getId_tab());
            
            //execiutando a statment
            tran.execute();
            
        }catch(SQLException ex){
            System.err.println("Erro na execução de criação da tela");
        }
      
    }
}
