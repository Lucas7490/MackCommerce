package br.mack.dao;

import br.mack.modeloEntidade.Pedido;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido read(Pedido key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pedido key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pedido key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
