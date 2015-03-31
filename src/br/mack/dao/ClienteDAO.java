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
public class ClienteDAO extends DAO<Object>{

    private static final String CHAVE = "Cliente"; //Nome tb e chave
    private static final String CAMPOS = "nome, endereco, cpf, email, "
            + "telefone, login, senha, status";
    private static String INSERT_SQL = "INSERT INTO " + CHAVE + " ("+
            CAMPOS+") VALUES (?,?,?,?,?,?,?,?)"; 
    private static String SELECT_SQL = "SELECT "+CAMPOS+ " from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+" SET"
            +CAMPOS.replaceAll(",", " =?,").concat(" =?")+ " where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+ " where "+
            CHAVE+ " = ?";
    
    /** Reference **/
    private DataSource datasource;
    
    @Override
    public void create(Object el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Set<Cliente> readAll() {
        Set<Cliente> list = new HashSet<>();
        try {
            Connection conn = datasource.getConnection();
            
            PreparedStatement stm = conn.prepareStatement(SELECT_ALL_SQL);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                c.setEndereco(rs.getString(2));
                c.setCpf(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setTelefone(rs.getString(5));
                c.setLogin(rs.getInt(6));
                c.setStatus(rs.getBoolean(8));
                list.add(c);
            }
                    rs.close();
                datasource.closeStatement(stm);
            datasource.closeConnection(conn);
        } catch(SQLException e) {}
        return list;
    }
}
