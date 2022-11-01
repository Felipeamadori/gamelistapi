package com.example.gamelistapi.model;

import com.example.gamelistapi.dto.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String senha;
    @Email
    private String email;
    private String datanasc;
    @Transient
    private String accessToken;
    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    Set<UsuarioGames> usuarioGames;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
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

    public UsernamePasswordAuthenticationToken toAuth() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
    public UsuarioDto toUsuarioDto() {
        return new UsuarioDto(id,nome,email,datanasc);
    }
}
