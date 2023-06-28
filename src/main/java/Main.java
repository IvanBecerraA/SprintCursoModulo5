import daoimpl.AdministrativoDaoImpl;
import daoimpl.UsuarioDaoImpl;
import models.Administrativo;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("hola");
        UsuarioDaoImpl usu = new UsuarioDaoImpl();
        //Administrativo adm = new Administrativo("Contabilidad","12");
        //Administrativo adm2 = new Administrativo("Recepcion","5");
        //administrativoDao.delete(6);
        //administrativoDao.create(1,adm2);
        //administrativoDao.update(4,adm);
        for (Usuario usuario : usu.list()) {
            String tipoUsuario="";
            switch (usuario.getTipo_usuario()){
                case 1: tipoUsuario= "Cliente";break;
                case 2: tipoUsuario= "Administrativo"; break;
                case 3: tipoUsuario= "Profesional"; break;
            }
            System.out.print("ID: "+usuario.getIdUsuario()+
                    " Nombre: "+usuario.getNombre()+
                    " Apellido1: "+usuario.getApellido1()+
                    " Apellido2 " +usuario.getApellido2()+
                    " Fecha de nacimiento: "+usuario.getFechaNacimiento()+
                    " run: "+usuario.getRun()+
                    " Tipo de usuario: "+tipoUsuario);

            System.out.println("...........");
        }

    }
}
