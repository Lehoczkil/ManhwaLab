package com.codecool.manhwalabbackend.model.roles;

import static com.codecool.manhwalabbackend.security.ApplicationUserPermission.*;

import com.codecool.manhwalabbackend.security.ApplicationUserPermission;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Getter
public enum ApplicationUserRoles {
    USER(Sets.newHashSet(POST_COMMENT, SAVE_LATER, SAVE_FAVOURITE, SAVE_READ, POST_COMMENT, READ_COMMENT, RATE_COMIC, EDIT_PROFILE));

    private final Set<ApplicationUserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
