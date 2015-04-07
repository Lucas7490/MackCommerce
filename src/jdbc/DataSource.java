package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public abstract class DataSource {
    protected static String DB_SERVER = "localhost"; // <<- olhar aqui
    protected static int DB_PORT = 1527; // <<- olhar aqui
    protected static String DB_NAME = "UNDEFINED"; // <<- olhar aqui
    protected static String DB_USER = "UNDEFINED"; // <<- olhar aqui
    protected static String DB_PASS = "UNDEFINED";
    
    public abstract Connection getConnection();
    public abstract Connection getConnection (String db_user, String db_pass);
    public abstract void prepare(String sql);
    public abstract void closeStatement(PreparedStatement stm) throws SQLException;
    public abstract void closeConnection(Connection conn) throws SQLException;
}
