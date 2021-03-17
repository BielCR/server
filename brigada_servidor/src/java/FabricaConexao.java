
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.tomcat.jdbc.pool.DataSource;

public class FabricaConexao {

    private static Connection con;

    public static Connection criaConexao() {
        try {
            Context contexto = new InitialContext();

            if (contexto == null) {
                System.err.println("erro de configuração do servidor no netbeans");
            } else {
                Context envContext = (Context) contexto.lookup("java:comp/env/");
                DataSource ds = (DataSource) envContext.lookup("jdbc/server");

                if (ds == null) {
                    con = ds.getConnection();
                }
            }
        } catch (NamingException ex) {
            System.err.println("Não existe o dataSource requisitado");
        } catch (SQLException ex) {
            System.err.println("Erro ao estabelecer a conexão");
        }
        return con;
    }
}
