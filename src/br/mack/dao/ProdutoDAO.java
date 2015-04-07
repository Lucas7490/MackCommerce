package br.mack.dao;

import br.mack.modeloEntidade.Produto;
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
public class ProdutoDAO extends DAO<Produto>{
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
    public void create(Produto el) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(INSERT_SQL);
            stm.setString(1, el.getNome());
            stm.setDouble(2, el.getPreco());
            stm.setByte(3, el.getFoto()); //Verificar
            stm.setString(4, el.getDesc());
            
            stm.execute();
            
                    stm.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public Produto read(Produto key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(SELECT_SQL);
            stm.setString(1, key.getNome());
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString(1));
                p.setPreco(rs.getDouble(2));
                p.setFoto(rs.getByte(3));
                p.setDesc(rs.getString(4));
                return p;
            }
                    rs.close();
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public void delete(Produto key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(DELETE_SQL);
            stm.setString(1, key.getNome());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public void update(Produto key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(UPDATE_SQL);
            stm.setDouble(2, key.getPreco());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
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
