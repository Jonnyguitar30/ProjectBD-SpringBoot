package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.UsuarioDTORequest;
import ipn.upiita.polifood.Entity.Usuario;
import ipn.upiita.polifood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario insertarUsuario(UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(usuarioDTORequest.getUsuarioDTO().getCorreoInstitucional());
        usuario.setContrasenia(usuarioDTORequest.getUsuarioDTO().getContrasenia());
        usuario.setTelefonoCelular(usuarioDTORequest.getUsuarioDTO().getTelefonoCelular());
        usuario.setNoBoleta(usuarioDTORequest.getUsuarioDTO().getNoBoleta());
        return usuarioRepository.save(usuario);
                //usuarioRepository.insertUsuarios(usuarioDTORequest.getUsuarioDTO().getCorreoInstitucional(),usuarioDTORequest.getUsuarioDTO().getBoleta(),usuarioDTORequest.getUsuarioDTO().getCelular(),usuarioDTORequest.getUsuarioDTO().getContrasenia());
/*        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse.setCorreoInstitucional(usuario.getCorreoInstitucional());
        usuarioDTOResponse.setNoBoleta(usuario.getNoBoleta());
        usuarioDTOResponse.setTelefonoCelular(usuario.getTelefonoCelular());
        usuarioDTOResponse.setContrasenia(usuario.getContrasenia());
        return usuarioDTOResponse;*/
    }

    public void borrarUsuario(String correoInstitucional){
        usuarioRepository.deleteUsuario(correoInstitucional);
    }

    public void borrarUsuarioId(int id){
        usuarioRepository.deleteById(id);
    }
/*
    public Optional<Usuario> buscarUsuario(String correoInstitucional){
        return usuarioRepository.findUser(correoInstitucional);
    }*/

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuariobyId(int id){
        return usuarioRepository.findById(id);
    }

/*    public Optional<Usuario> obtenerUsuariobyCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }*/
}
