package models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrativo extends Usuario{
    private String area;
    private String experienciaPrevia;

}
