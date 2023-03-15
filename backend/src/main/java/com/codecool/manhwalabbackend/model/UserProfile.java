package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.enums.Gender;
import javax.persistence.*;

import com.codecool.manhwalabbackend.model.roles.ApplicationUserRoles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer age;
    @Column(unique = true)
    private String email;
    private String Password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;
    private LocalDate lastOnline;
    private LocalDate joined;
    @Enumerated(EnumType.STRING)
    private ApplicationUserRoles role;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "favourites",
            joinColumns = @JoinColumn(name = "comicProfileId"),
            inverseJoinColumns = @JoinColumn(name = "userProfileId"))
    private List<ComicProfile> favourites;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "read",
            joinColumns = @JoinColumn(name = "comicProfileId"),
            inverseJoinColumns = @JoinColumn(name = "userProfileId"))
    private List<ComicProfile> read;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "readLater",
            joinColumns = @JoinColumn(name = "comicProfileId"),
            inverseJoinColumns = @JoinColumn(name = "userProfileId"))
    private List<ComicProfile> readLater;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "finished",
            joinColumns = @JoinColumn(name = "comicProfileId"),
            inverseJoinColumns = @JoinColumn(name = "userProfileId"))
    private List<ComicProfile> finished;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> userComments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getGrantedAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//    profile picture

}

