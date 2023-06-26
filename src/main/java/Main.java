import daoimpl.AdministrativoDaoImpl;
import models.Administrativo;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdministrativoDaoImpl administrativoDao = new AdministrativoDaoImpl(); // Crea una instancia del DAO
        Administrativo adm = new Administrativo("Contabilidad","12");
        Administrativo adm2 = new Administrativo("Recepcion","5");
        administrativoDao.delete(6);
        administrativoDao.create(1,adm2);
        administrativoDao.update(4,adm);
            for (Administrativo administrativo : administrativoDao.list()) {
                System.out.print("Area: "+administrativo.getArea());
                System.out.println(" Experiencia: "+administrativo.getExperienciaPrevia());

            }

    }
}
