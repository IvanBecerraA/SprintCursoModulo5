package models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profesional extends Usuario {
    private int id_profesional;
    private int id_usuario;
    private String titulo;
    private LocalDate fecha_ingreso;

    public Profesional(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, int run, String contrasenia, int tipoDeUsuario, String titulo, LocalDate fechaIngreso) {
        this.titulo=titulo;
        this.fecha_ingreso=fechaIngreso;
    }

}
