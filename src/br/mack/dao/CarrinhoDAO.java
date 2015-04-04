package br.mack.dao;

import br.mack.modeloEntidade.Carrinho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class CarrinhoDAO extends DAO<Carrinho>{
    private static final String CHAVE = "Carrinho";
    private static final String CAMPOS = "nome, preco, foto, descricao"; //verificar foto
    private static String INSERT_SQL = "INSERT INTO " + CHAVE + " (" +
            CAMPOS+") VALUES (?,?,?,?)";
    private static String SELECT_SQL = "SELECT "+CAMPOS+ "from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+ "SET "+
            CAMPOS.replaceAll(",", " =?,").concat(" =?")+" where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+ " where "+ 
            CHAVE+" =?";
    @Override
    public void create(Carrinho el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrinho read(Carrinho key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Carrinho key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Carrinho key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Set<Carrinho> readAll() {
        Set<Carrinho> setList = new HashSet<>();
        try {
            super.dataSource.getConnection();
            
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while (rs.next()) {
                Carrinho c = new Carrinho();
                c.setID(rs.getInt(1));
                setList.add(c);
            }
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
        return setList;
    }
}
