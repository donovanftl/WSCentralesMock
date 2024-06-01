package ms.usuario.usuarioTest.repository;

import ms.usuario.usuarioTest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
