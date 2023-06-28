package models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profesional extends Usuario {
    private String titulo;
    private Date fecha_ingreso;

    public Profesional(String nombre, String apellido1, String apellido2, String fechaNacimiento, int run, String contrasena, int tipoDeUsuario, String titulo, String fechaIngreso) {
        this.titulo=titulo;
        //this.fecha_ingreso=fechaIngreso;
    }
}
