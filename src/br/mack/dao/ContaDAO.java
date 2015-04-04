package br.mack.dao;

import br.mack.modeloEntidade.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class ContaDAO extends DAO<Conta>{
    private static final String CHAVE = "Conta";
    private static final String CAMPOS = "ID"; //temporáriamente
    private static String INSERT_SQL = "INSERT INTO "+CHAVE+" ("+
            CAMPOS+") VALUES (?)";
    private static String SELECT_SQL = "SELECT "+CAMPOS+" from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+ " SET "+
            CAMPOS+" =?"+ " where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+" where "+
            CHAVE+" =?";
    
    @Override
    public void create(Conta el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta read(Conta key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Conta key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Conta key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Set<Conta> readAll() {
        Set<Conta> setList = new HashSet<>();
        try {
            super.dataSource.getConnection();
                                    
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while(rs.next()) {
                Conta c = new Conta();
                c.setID(rs.getLong(1));
                setList.add(c);
            }
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
        return setList;
    }
}
