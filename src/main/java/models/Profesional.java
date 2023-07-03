package models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profesional extends Usuario {
    private int id_professional;
    private int id_user;
    private String titulo;
    private LocalDate fecha_ingreso;
}
