package models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente extends Usuario{
    private int idCliente;
    private String razonSocial;
    private String giroEmpresa;
    private String rut;
    private String telefonoRepresentante;
    private String direccionEmpresa;
    private String comunaEmpresa;
}
