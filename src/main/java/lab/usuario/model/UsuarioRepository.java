package lab.usuario.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsername(String username);

    @Query(value = "SELECT id, apelido, is_ativo, usuario FROM tb_usuario "
            + "WHERE is_ativo = true ORDER BY id ASC;", nativeQuery = true)
    @Override
    public List<Usuario> findAll();
}
