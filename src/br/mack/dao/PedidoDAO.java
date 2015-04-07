package br.mack.dao;

import br.mack.modeloEntidade.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class PedidoDAO extends DAO<Pedido>{
    private static final String CHAVE = "Produto";
    private static final String CAMPOS = "numero, dtPedido, dtEntrega, endEntrega"
            + ", valor, status, comentario, frete";
    private static String INSERT_SQL = "INSERT INTO " + CHAVE + " (" +
            CAMPOS+") VALUES (?,?,?,?,?,?,?,?)";
    private static String SELECT_SQL = "SELECT "+CAMPOS+ "from "+CHAVE+
            " where "+CHAVE+" =?";
    private static String SELECT_ALL_SQL = "SELECT * from "+CHAVE;
    private static String UPDATE_SQL = "UPDATE "+CHAVE+ "SET "+
            CAMPOS.replaceAll(",", " =?,").concat(" =?")+" where "+CHAVE+" =?";
    private static String DELETE_SQL = "DELETE from "+CHAVE+ " where "+ 
            CHAVE+" =?";
    @Override
    public void create(Pedido el) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(INSERT_SQL);
            stm.setInt(1, el.getNumero());
            
            stm.execute();
            
                    stm.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public Pedido read(Pedido key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(SELECT_SQL);
            stm.setInt(1, key.getNumero());
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Pedido p = new Pedido();
                p.setNumero(rs.getInt(1));
                //bla bla bla
                return p;
            }
                    rs.close();
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
        return null;
    }

    @Override
    public void delete(Pedido key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm;
            stm = super.dataSource.prepare(DELETE_SQL);
            stm.setInt(1, key.getNumero());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public void update(Pedido key) {
        try {
            super.dataSource.getConnection();
            
            PreparedStatement stm = super.dataSource.prepare(UPDATE_SQL);
            stm.setInt(1, key.getNumero());
            
            stm.execute();
            
                stm.close();
            super.dataSource.closeConnection();
        } catch (SQLException e) {e.printStackTrace();}
    }
    public Set<Pedido> readAll() {
        Set<Pedido> setList = new HashSet<>();
        try {
            super.dataSource.getConnection();
            
            ResultSet rs = super.dataSource.prepare(SELECT_ALL_SQL).executeQuery();
            
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setNumero(rs.getInt(1));
                p.setDtPedido(rs.getDate(2));
                p.setDtEntrega(rs.getDate(3));
                p.setEnderecoEntrega(rs.getString(4));
                p.setValor(rs.getDouble(5));
                p.setStatus(rs.getBoolean(6)); //verificar
                p.setComentario(rs.getString(7));
                p.setFrete(rs.getDouble(8));
                setList.add(p);
}
                    rs.close();
                super.dataSource.closeStatement();
            super.dataSource.closeConnection();
        } catch(SQLException e) {}
        return setList;
    }
}
