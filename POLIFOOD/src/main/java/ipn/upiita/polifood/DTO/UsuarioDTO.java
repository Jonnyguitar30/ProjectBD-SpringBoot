package ipn.upiita.polifood.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class UsuarioDTO implements Serializable {
    private int id;
    private String correoInstitucional;
    private String noBoleta;
    private String telefonoCelular;
    private String contrasenia;


}
