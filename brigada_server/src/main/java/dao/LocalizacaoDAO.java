/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Localizacao;
import java.sql.Connection;
import java.sql.SQLException;
import tools.FabricaConexao;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

/**
 *
 * @author gabri
 */
public class LocalizacaoDAO {
    public static void enviarLocalizacao (Localizacao l){
        
        String sql = "INSERT INTO localizacao(latitude, longitude, dataHora)  VALUES (?, ?, ?);";
        
        try(Connection con = FabricaConexao.criaConexao()){
            PreparedStatement transacao = con.prepareStatement(sql);
            
            transacao.setDouble(1, l.getLatitude());
            transacao.setDouble(2, l.getLongitude());
            transacao.setTimestamp(3, new Timestamp(l.getData().getTime()));
            transacao.execute();
            
        }catch(SQLException ex){
            System.err.println("Erro ao processar a SQL : "+ex);
        }
    }
}
