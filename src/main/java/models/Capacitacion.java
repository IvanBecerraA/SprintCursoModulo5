package models;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Capacitacion {

    private int id;
    private int idCliente;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private int duracion;
    private int cantidadAsistentes;
	
}
