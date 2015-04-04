package br.mack.dao;

import br.mack.modeloEntidade.Pagamento;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento read(Pagamento key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pagamento key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pagamento key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
