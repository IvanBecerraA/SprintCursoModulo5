package models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int run;
}
