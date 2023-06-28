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

    public Profesional(String nombre, String apellido1, String apellido2, String fechaNacimiento, String run, String cotrasena, String titulo, String fechaIngreso) {
    }
}
