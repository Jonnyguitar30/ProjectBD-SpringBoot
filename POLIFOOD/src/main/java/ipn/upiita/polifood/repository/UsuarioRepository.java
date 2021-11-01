package ipn.upiita.polifood.repository;

import ipn.upiita.polifood.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {


    @Procedure(name = "insertarUsuario")
    Usuario insertUsuarios(String p_correoInstitucional, String p_telefonoCelular,String p_noBoleta, String p_contrasenia);

    @Procedure(name = "borrarUsuario")
    void deleteUsuario(String p_correo);

    @Procedure(name = "buscarUsuario")
    Usuario findByCorreo(String p_correo);


}
