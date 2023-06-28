package models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente extends Usuario{
    private String razonSocial;
    private String giroEmpresa;
    private int rut;
    private String telefonoRepresentante;
    private String direccionEmpresa;
    private String comunaEmpresa;
}
