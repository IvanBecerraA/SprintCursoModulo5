package models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profesional extends Usuario {
    private int id_professional;
    private int id_user;
    private String titulo;
    private String fecha_ingreso;
}
