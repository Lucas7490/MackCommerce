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
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(INSERT_SQL);
            stm.setLong(1, el.getID());
            
            stm.execute();
            
                    stm.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public Conta read(Conta key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(SELECT_SQL);
            stm.setLong(1, key.getID());
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Conta c = new Conta();
                c.setID(rs.getLong(1));
                return c;
            }
                    rs.close();
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public void delete(Conta key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(DELETE_SQL);
            stm.setLong(1, key.getID());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public void update(Conta key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(UPDATE_SQL);
            stm.setLong(2, key.getID());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
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
