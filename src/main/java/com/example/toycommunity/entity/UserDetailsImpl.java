package com.example.toycommunity.entity;

import com.example.toycommunity.dto.request.UserSignUpRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString @EqualsAndHashCode
@Entity
@Table(name = "community_user")
public class UserDetailsImpl implements UserDetails {

    @Id
    @Column(name = "user_id", length = 50)
    private String id;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "user_authority")
    private String authority;
    @Column(name = "user_is_enabled")
    private boolean enabled;
    @Column(name = "user_name")
    private String name;
    @CreationTimestamp
    @Column(name = "user_join_date", updatable = false)
    private LocalDate userJoinDate;

    public static UserDetailsImpl of(UserSignUpRequestDto userSignUpRequestDto) {
        return UserDetailsImpl.builder()
                .id(userSignUpRequestDto.getId())
                .password(userSignUpRequestDto.getPassword())
                .name(userSignUpRequestDto.getName())
                .authority("MEMBER")
                .enabled(true)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(authority));
        return auth;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
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
}
