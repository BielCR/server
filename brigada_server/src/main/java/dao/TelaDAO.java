
package dao;

//import de models e tools
import model.Tela;
import tools.FabricaConexao;

//imports de sql
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Tela;


public class TelaDAO {
    
    public static Tela exibeTela(int id){
        
        Tela temp = null;
        String sql = "SELECT * FROM telas WHERE id = ?;";
        
        try(Connection con = FabricaConexao.criaConexao()){
        
            
            PreparedStatement transacao = con.prepareStatement(sql);
            transacao.setInt(1 ,id);
            ResultSet tuplas = transacao.executeQuery();
            
            while(tuplas.next()){
                temp = new Tela(tuplas.getInt("id"), tuplas.getString("corpo"),
                tuplas.getString("imagem"), tuplas.getString("titulo"));
            }
            
        }catch(SQLException ex){
            System.err.println("Erro na execução de exibição da tela");
        }
        return temp;
    }
    
    public static void cadastraTela(Tela novaTela){
        
        String sql = "INSERT INTO telas(id, corpo, imagem, titulo) VALUES (?, ?, ?, ?)";
        try(Connection con = FabricaConexao.criaConexao()){
            
            PreparedStatement tran = con.prepareStatement(sql);
            
            //adicionando valores na Statment
            tran.setInt(1, novaTela.getId());
            tran.setString(2, novaTela.getCorpo());
            tran.setString(3, novaTela.getImagem());
            tran.setString(4, novaTela.getTitulo());
            
            //execiutando a statment
            tran.execute();
            
        }catch(SQLException ex){
            System.err.println("Erro na execução de criação da tela");
        }
      
    }
}
