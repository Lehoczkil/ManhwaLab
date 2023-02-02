package com.codecool.manhwalabbackend.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationUserPermission {
    SAVE_FAVOURITE("save:favourite"),
    SAVE_LATER("save:later"),
    SAVE_READ("save:read"),
    POST_COMMENT("post:comment"),
    READ_COMMENT("read:comment"),
    RATE_COMIC("rate:comic"),
    EDIT_PROFILE("edit:profile");

    private final String permission;


}
