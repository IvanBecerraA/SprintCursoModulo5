package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection conectar(){
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "dayhip";
        String password = "Dd123123";
        String url = "jdbc:mysql://localhost/Sprint05";

        try
        {
            Class.forName(driver);

            con = DriverManager.getConnection(url, usuario, password);

            if (con != null) {
                System.out.println("Connectado");
            }

        }
        catch(SQLException e)

        {
            System.out.println("Error en la conexion a la BD");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
