package lab.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import lab.role.model.Permissao;
import lab.security.model.CustomUserDetails;
import lab.usuario.model.Usuario;
import lab.usuario.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado.");
        }
        return new CustomUserDetails(user.getApelido(), user.getUsername(), 
                user.getPassword(), getAuthorities(user));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        Collection<GrantedAuthority> regras = new ArrayList<>();
        Set<Permissao> permissoes = usuario.getGrupoUsuario().getPermissao();
        permissoes.forEach((permissao) -> {
            regras.add(new SimpleGrantedAuthority(permissao.getLabel()));
        });
        return regras;
    }
}
