package models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrativo extends Usuario{
    private String area;
    private String experienciaPrevia;

    public Administrativo(String nombre,
                          String apellido1,
                          String apellido2,
                          Date fechaNacimiento,
                          int run,
                          String password,
                          int tipo_usuario,
                          String area,
                          String experienciaPrevia) {
        super(nombre, apellido1, apellido2, fechaNacimiento, run, password, tipo_usuario);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
}
