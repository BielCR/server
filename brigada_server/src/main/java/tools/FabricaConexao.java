package tools;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FabricaConexao {
    
    private static Connection con;
    
    public static Connection criaConexao(){
        
        
        try{
            
            if(con != null && !con.isClosed()){
                return con;
            }
            
            Context contexto = new InitialContext();
            
            if(contexto == null){
                System.err.println("erro de configutação no netbeans");
            }else{
                Context envContext = (Context) contexto.lookup("java:comp/env/");
                DataSource ds = (DataSource) envContext.lookup("jdbc/bruno_gabriel");
                
                if(ds != null){
                  con = ds.getConnection();
                }
            }
            
        }catch(NamingException ex){
            System.err.println("Nao existe o datasource requisitado");
            
        }catch(SQLException ex){
            System.err.println("erro ao estabelecer a conexão com o banco de dados");
        }
        
        return con;
    }
}
