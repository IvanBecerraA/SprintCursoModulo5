package models;

import lombok.*;

import java.util.Date;
import java.util.PrimitiveIterator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private int run;
    private String password;
    private int tipo_usuario;

    public Usuario(int idUsuario, String nombre, String apellido1, String apellido2, Date fechaNacimiento, int run, int tipo_usuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.tipo_usuario = tipo_usuario;
    }


}
