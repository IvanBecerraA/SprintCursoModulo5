package models;

import lombok.*;

import java.time.LocalDate;
import java.util.PrimitiveIterator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private int run;
    private String contrasenia;
    private int tipo_usuario;

    public Usuario(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, int run, String contrasenia, int tipoUsuario) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.contrasenia = contrasenia;
        this.tipo_usuario = tipoUsuario;
    }
}
