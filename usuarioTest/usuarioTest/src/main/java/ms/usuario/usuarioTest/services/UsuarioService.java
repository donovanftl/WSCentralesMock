package ms.usuario.usuarioTest.services;

import ms.usuario.usuarioTest.model.Usuario;
import ms.usuario.usuarioTest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setPaterno(usuarioDetails.getPaterno());
            usuario.setMaterno(usuarioDetails.getMaterno());
            usuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
            usuario.setGenero(usuarioDetails.getGenero());
            usuario.setCurp(usuarioDetails.getCurp());
            usuario.setRfc(usuarioDetails.getRfc());
            usuario.setDireccion(usuarioDetails.getDireccion());
            return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
            usuarioDetails.setId(id);
            return usuarioRepository.save(usuarioDetails);
        });
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
