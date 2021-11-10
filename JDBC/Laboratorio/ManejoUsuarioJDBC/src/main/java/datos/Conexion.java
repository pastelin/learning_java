package datos;

import java.sql.*;

/**
 * Clase que tiene como objetivo crear una conexion a nuestra base de datos y 
 * metodos para cerrar la conexion de los objetos ResulSet, Connection y PreparedStatement
 *
 * @author Juan pastelin Brioso
 * @version 1.0
 */
public class Conexion {

    private static final String JDBC_URL = 
            "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
            
    
    public static Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        
    }
    
    public static void close(ResultSet rs) {
    
        try {
            
            rs.close();
            
        } catch(SQLException ex) {
            
            ex.printStackTrace(System.out);
            
        }
        
    }
    
    public static void close(PreparedStatement stmt) {
        
        try {
            
            stmt.close();
            
        } catch(SQLException ex) {
            
            ex.printStackTrace(System.out);
            
        }
        
    }
    
    public static void close(Connection conn) {
        
        try {
            
            conn.close();
            
        } catch(SQLException ex) {
            
            ex.printStackTrace(System.out);
            
        }
        
        
    }
    
    
}
