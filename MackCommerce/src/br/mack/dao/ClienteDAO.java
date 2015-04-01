package br.mack.dao;

import br.mack.modeloEntidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import jdbc.DataSource;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class ClienteDAO extends DAO<Object>{

    private static final String CHAVE = "Cliente";
    private static final String CAMPOS = "nome, endereco, cpf, email, telefone, login, senha, status";
    private static String INSERT_SQL = "INSERT INTO "+CHAVE+ " ("+CAMPOS+") VALUES(?,?,?,?,?,?,?,?,?)";
    private static String SELECT_SQL = "SELECT " +CAMPOS +" from "+ CHAVE+ " where " + CHAVE + " =?";
    private static String SELECT_ALL_SQL = "SELECT * from " + CHAVE;
    private static String UPDATE_SQL = "UPDATE "+ CHAVE +" SET "+ CAMPOS.replaceAll(",", " =?,").concat(" =?")+
            " where" + CHAVE + " = ?";
    private static String DELETE_SQL = "DELETE FROM "+ CHAVE + "where " + CHAVE + " = ?";
    
    //References
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
                Cliente cl = new Cliente();
                cl.setNome(rs.getString(1));
                cl.setCPF(rs.getString(2));
                list.add(cl);
            }
                    rs.close();
                datasource.closeStatement(stm);
            datasource.closeConnection(conn);

        } catch (Exception e) {
        }
        return list;
    }
}
