package br.mack.dao;

import br.mack.modeloEntidade.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class PagamentoDAO extends DAO<Pagamento>{
    private static final String CHAVE = "Pagamento";
    private static final String CAMPOS = "id, data, valor"; //verificar foto
    private static String INSERT_SQL = "INSERT INTO " + CHAVE + " (" +
            CAMPOS+") VALUES (?,?,?)";
    private static String SELECT_SQL = "SELECT "+CAMPOS+ "from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+ "SET "+
            CAMPOS.replaceAll(",", " =?,").concat(" =?")+" where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+ " where "+ 
            CHAVE+" =?";
    @Override
    public void create(Pagamento el) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(INSERT_SQL);
            stm.setInt(1, el.getID());
            
            stm.execute();
            
                    stm.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public Pagamento read(Pagamento key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(SELECT_SQL);
            stm.setInt(1, key.getID());
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Pagamento p = new Pagamento();
                p.setID(rs.getInt(1));
                p.setData(rs.getDate(2));
                p.setValor(rs.getDouble(3));
                return p;
            }
                    rs.close();
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public void delete(Pagamento key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(DELETE_SQL);
            stm.setInt(1, key.getID());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public void update(Pagamento key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(UPDATE_SQL);
            stm.setInt(2, key.getID());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }
    public Set<Pagamento> readAll() {
        Set<Pagamento> setList = new HashSet<>();
        try{
            super.dataSource.getConnection();
            
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setID(rs.getInt(1));
                p.setData(rs.getDate(2));
                p.setValor(rs.getDouble(3));
                setList.add(p);
}
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
        return null;
    }
}
