package ipn.upiita.polifood.Controller;

import ipn.upiita.polifood.DTO.UsuarioDTOResponse;
import ipn.upiita.polifood.Entity.Usuario;
import ipn.upiita.polifood.Service.UsuarioService;
import ipn.upiita.polifood.commons.GenericResponseDTO;
import ipn.upiita.polifood.DTO.UsuarioDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UsuarioController extends CommonController {
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/nuevo",method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDTO<?>> insertar(@RequestBody UsuarioDTORequest usuarioDTORequest){
        Usuario usuario1= usuarioService.insertarUsuario(usuarioDTORequest);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El registro fue agregado",
                usuario1));
    }

    @RequestMapping(value = "/buscarCorreo/{p_correo}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<?>> buscarbyCorreo(@PathVariable("p_correo") String p_correo){
        UsuarioDTOResponse usuario = (UsuarioDTOResponse) usuarioService.obtenerUsuariobyCorreo(p_correo);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. Usuario encontrado",usuario));
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<?>> obtener(){
        List<Usuario> usuario1 = usuarioService.obtenerUsuarios();;
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. Usuario Encontrado",usuario1));
    }

    @RequestMapping(value = "/id/{id}",method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO<Optional<Usuario>>> obtenerbyId(@PathVariable("id") int id){
        Optional<Usuario> usuario = usuarioService.obtenerUsuariobyId(id);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. Usuario encontrado",
                usuario));
    }

    @RequestMapping(value = "/borrarCorreo/{correo}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseDTO<?>> borrarbyId(@PathVariable("correo") String correo){
        usuarioService.borrarUsuario(correo);
        return ResponseEntity.ok(new GenericResponseDTO<>(SUCCESS, HTTP_SUCCESS, null,
                null, "Servicio ejecutado exitosamente. El usuario fue eliminado",
                1));
    }


}
