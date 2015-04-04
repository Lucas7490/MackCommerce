package br.mack.dao;

import br.mack.modeloEntidade.Cliente;
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
public class ClienteDAO extends DAO<Cliente>{

    private static final String CHAVE = "Cliente"; //Nome tb e chave
    private static final String CAMPOS = "nome, endereco, cpf, email, "
            + "telefone, login, senha, status";
    private static String INSERT_SQL = "INSERT INTO " + CHAVE + " ("+
            CAMPOS+") VALUES (?,?,?,?,?,?,?,?)"; 
    private static String SELECT_SQL = "SELECT "+CAMPOS+ " from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+" SET "
            +CAMPOS.replaceAll(",", " =?,").concat(" =?")+ " where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+ " where "+
            CHAVE+ " = ?";
    
    
    @Override
    public void create(Cliente el) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(INSERT_SQL);
            stm.setString(1, el.getNome());
            stm.setString(2, el.getEndereco());
            stm.setString(3, el.getCpf());
            stm.setString(4, el.getEmail());
            stm.setString(5, el.getTelefone());
            stm.setInt(6, el.getLogin());
            stm.setInt(7, el.getSenha());
            stm.setBoolean(8, el.getStatus());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
    }

    @Override
    public Cliente read(Cliente key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(SELECT_SQL);
            stm.setObject(1, key);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                c.setEndereco(rs.getString(2));
                c.setCpf(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setTelefone(rs.getString(5));
                c.setLogin(rs.getInt(6));
                c.setSenha(rs.getInt(7));
                c.setStatus(rs.getBoolean(8));
              return c;
            } else {}            
                    rs.close();
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public void delete(Cliente key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(DELETE_SQL);
            stm.setString(3, key.getCpf());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
    }

    @Override
    public void update(Cliente key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(UPDATE_SQL);
            stm.setBoolean(8, key.getStatus());
            
            /** mais campos **/
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {}
    }
    public Set<Cliente> readAll() {
        Set<Cliente> setList = new HashSet<>();
        try {
            super.dataSource.getConnection();            
                        
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                c.setEndereco(rs.getString(2));
                c.setCpf(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setTelefone(rs.getString(5));
                c.setLogin(rs.getInt(6));
                c.setStatus(rs.getBoolean(8));
                setList.add(c);
            }
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch(SQLException e) {}
        return setList;
    }
}
