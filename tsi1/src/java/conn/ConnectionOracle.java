package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Conexion con la Base de datos
public class ConnectionOracle {
    // Si la conexión esta abierta uso la misma conexión 
    // En el caso de que no creo una nueva conexión
    public static ConnectionOracle instance;   // Instancia de conexion    ->  Singleton
    private Connection connection;    //  Objeto Conexion de java.sql.Connection
    
    private ConnectionOracle() {
        String host = "localhost";  //  Host del server Oracle
        String port = "1521";   //  Puerto de conexion del servidor oracle
        String sid  = "orcl";   //  SID de conexión
        String user = "hr";     //  Usuario de conecion
        String password = "Oracle11g";  //  Password del usuario de conexion
        
        // URL de conexión con Oracle
        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
        
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
           
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // synchronized -> Es para controlar o sincronizar las conexiones
    public static synchronized ConnectionOracle startConnection() {
        if(instance == null)
            instance = new ConnectionOracle();
        return instance;
    }
    public void closeConnection() {
        instance = null;        
    }

    public Connection getConnection() {
        return connection;
    }
    
    
}
