package br.mack.dao;

import br.mack.modeloEntidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import jdbc.DataSource;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class ProdutoDAO extends DAO<Object>{
    private static final String CHAVE = "Produto";
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
    public void create(Object el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Set<Produto> readAll() {
        Set<Produto> setList = new HashSet<>();
        try {
            super.dataSource.getConnection();          
                       
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString(1));
                p.setPreco(rs.getDouble(2));
                p.setFoto(rs.getByte(3));
                p.setDesc(rs.getString(4));
                setList.add(p);
            }
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
        return setList;
    }
}
