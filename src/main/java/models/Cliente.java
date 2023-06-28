package models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente extends Usuario{
    private int id_cliente;
    private String razonSocial;
    private String giroEmpresa;
    private int rut;
    private String telefonoRepresentante;
    private String direccionEmpresa;
    private String comunaEmpresa;
    private int id_usuario;

    public Cliente(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, int run, String contrasenia,
                   int tipo_usuario, String razonSocial, String giroEmpresa, int rut, String telefonoRepresentante,
                   String direccionEmpresa, String comunaEmpresa) {
        super(nombre, apellido1, apellido2, fechaNacimiento, run, contrasenia, tipo_usuario);
        this.razonSocial = razonSocial;
        this.giroEmpresa = giroEmpresa;
        this.rut = rut;
        this.telefonoRepresentante = telefonoRepresentante;
        this.direccionEmpresa = direccionEmpresa;
        this.comunaEmpresa = comunaEmpresa;
    }

}
