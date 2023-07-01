package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conexion = null;
    private Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint_m5", "root", "admin");
            //conexion = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9629710", "sql9629710", "rzzwgfnJwA");
            conexion = DriverManager.getConnection("jdbc:mysql://db4free.net/prueba_bootcamp", "nelson_bootcamp", "bootcamp2023");
            if (conexion != null){
                System.out.println("Conexion correcta");
            }else{
                System.out.println("Fallo al conectar");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace(); // hola
        }
    }

    public static Connection getConexion() {
        if (conexion == null) {
            new Conexion();
        }
        return conexion;
    }

}
