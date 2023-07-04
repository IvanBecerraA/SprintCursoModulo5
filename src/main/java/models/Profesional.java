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

    public Profesional(int id_usuario, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, int run, String contrasenia, int tipo_usuario, int id_profesional, String titulo, LocalDate fecha_ingreso) {
        super(id_usuario, nombre, apellido1, apellido2, fechaNacimiento, run, contrasenia, tipo_usuario);
        this.id_profesional = id_profesional;
        this.titulo = titulo;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Profesional(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, int run, String contrasenia, int tipoDeUsuario, String titulo, LocalDate fechaIngreso) {
        super(nombre, apellido1, apellido2, fechaNacimiento, run, contrasenia, tipoDeUsuario);
        this.titulo=titulo;
        this.fecha_ingreso=fechaIngreso;
    }

}
