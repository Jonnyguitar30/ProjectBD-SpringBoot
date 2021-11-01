package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class UsuarioDTOResponse implements Serializable {

    private int id;
    private String correoInstitucional;
    private String noBoleta;
    private String telefonoCelular;
    private String contrasenia;

    public UsuarioDTOResponse(int id, String correoInstitucional, String noBoleta, String telefonoCelular, String contrasenia) {
        this.id = id;
        this.correoInstitucional = correoInstitucional;
        this.noBoleta = noBoleta;
        this.telefonoCelular = telefonoCelular;
        this.contrasenia = contrasenia;
    }
}
