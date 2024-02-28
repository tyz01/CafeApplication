package tyz.corporation.cafeapplication.entity.type;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    MODERATOR,
    USER;
    @Override
    public String getAuthority() {
        return name();
    }
}
