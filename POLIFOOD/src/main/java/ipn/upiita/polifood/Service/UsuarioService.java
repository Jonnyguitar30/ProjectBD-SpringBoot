package ipn.upiita.polifood.Service;

import ipn.upiita.polifood.DTO.UsuarioDTORequest;
import ipn.upiita.polifood.Entity.Usuario;
import ipn.upiita.polifood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;


@Service
    public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PersistenceContext
    EntityManager em;

    public Usuario insertarUsuario(UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(usuarioDTORequest.getUsuarioDTO().getCorreoInstitucional());
        usuario.setContrasenia(usuarioDTORequest.getUsuarioDTO().getContrasenia());
        usuario.setTelefonoCelular(usuarioDTORequest.getUsuarioDTO().getTelefonoCelular());
        usuario.setNoBoleta(usuarioDTORequest.getUsuarioDTO().getNoBoleta());
        return usuarioRepository.save(usuario);
        //usuarioRepository.insertUsuarios(usuarioDTORequest.getUsuarioDTO().getCorreoInstitucional(),usuarioDTORequest.getUsuarioDTO().getBoleta(),usuarioDTORequest.getUsuarioDTO().getCelular(),usuarioDTORequest.getUsuarioDTO().getContrasenia());
/*      UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse.setCorreoInstitucional(usuario.getCorreoInstitucional());
        usuarioDTOResponse.setNoBoleta(usuario.getNoBoleta());
        usuarioDTOResponse.setTelefonoCelular(usuario.getTelefonoCelular());
        usuarioDTOResponse.setContrasenia(usuario.getContrasenia());
        return usuarioDTOResponse;*/
    }

    public void borrarUsuario(String p_correo){
        usuarioRepository.deleteUsuario(p_correo);
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

    public Object obtenerUsuariobyCorreo(String p_correo){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("buscarUsuario");
        spq.setParameter("p_correo", p_correo);
        spq.execute();
        return spq.getSingleResult();
    }
}
