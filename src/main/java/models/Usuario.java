package models;

import lombok.*;

import java.time.LocalDate;
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
    private LocalDate fechaNacimiento;
    private int run;
    private String password;
    private int tipo_usuario;




}
