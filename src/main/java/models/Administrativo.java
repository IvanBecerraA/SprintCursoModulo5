package models;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrativo extends Usuario{
    private int id_administrativo;
    private String area;
    private int experienciaPrevia;
    private int id_usuario;

    public Administrativo(String nombre,
                          String apellido1,
                          String apellido2,
                          LocalDate fechaNacimiento,
                          int run,
                          String contrasenia,
                          int tipo_usuario,
                          String area,
                          int experienciaPrevia) {
        super(nombre, apellido1, apellido2, fechaNacimiento, run, contrasenia, tipo_usuario);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
}
