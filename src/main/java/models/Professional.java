package models;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Professional extends Usuario {
    String titulo;
    String fechaIngreso;

}
