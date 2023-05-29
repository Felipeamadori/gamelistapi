package com.example.gamelistapi.model;

import com.example.gamelistapi.dto.FollowDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "follow")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "following.id")
    private Usuario following;

    @ManyToOne
    @JoinColumn(name = "followe.id")
    private Usuario followe;

    public FollowDto toFollowDto() {
        return new FollowDto(id, following.toUsuarioDto(), followe.toUsuarioDto());
    }
}
