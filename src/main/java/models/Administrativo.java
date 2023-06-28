package models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrativo extends Usuario{
    private int idAdministrativo;
    private String area;
    private String experienciaPrevia;

    public Administrativo(int idUsuario, String nombre, String apellido1, String apellido2, Date fechaNacimiento, int run, String password, int tipo_usuario, int idAdministrativo, String area, String experienciaPrevia) {
        super(idUsuario, nombre, apellido1, apellido2, fechaNacimiento, run, password, tipo_usuario);
        this.idAdministrativo = idAdministrativo;
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
}
