package lab.security.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author lucas
 */
public class CustomUserDetails extends User {

    private static final long serialVersionUID = 1L;

    private final String alias;

    public CustomUserDetails(String alias, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
