package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class UsuarioDTOResponse implements Serializable {

    private String correoInstitucional;
    private String noBoleta;
    private String telefonoCelular;
    private String contrasenia;
}
