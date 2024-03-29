package com.codecool.manhwalabbackend.model.DTO;

import com.codecool.manhwalabbackend.model.roles.ApplicationUserRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    private String username;
    private String password;
    private String email;
    private ApplicationUserRoles role;
}
