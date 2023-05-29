package com.example.gamelistapi.controller;

import com.example.gamelistapi.dto.FollowDto;
import com.example.gamelistapi.dto.UsuarioDto;
import com.example.gamelistapi.model.Follow;
import com.example.gamelistapi.model.Usuario;
import com.example.gamelistapi.repository.FollowRepository;
import com.example.gamelistapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/social")
public class FollowController {
    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/follow")
    public ResponseEntity<FollowDto> followUser(@RequestBody Follow follow, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            Follow f = followRepository.save(follow);
            URI uri = uriBuilder.path("follow/{id}").buildAndExpand(f.getId()).toUri();
            return ResponseEntity.created(uri).body(f.toFollowDto());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollowUser(@RequestBody Follow follow) throws Exception {
        try {
            followRepository.delete(follow);
            return ResponseEntity.ok("Entity deleted");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * @return list of users thats follows the
     * @param id
     * */
    @GetMapping("/find-followers/{id}")
    public ResponseEntity<List<UsuarioDto>> followersById(@PathVariable Long id) throws Exception {
        try {
            List<UsuarioDto> u = followRepository.findByFollowe_Id(id)
                    .stream()
                    .map(Follow::getFollowing).map(Usuario::toUsuarioDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/find-followings/{id}")
    public ResponseEntity<List<UsuarioDto>> followingsById(@PathVariable Long id) throws Exception {
        try {
            List<UsuarioDto> u = followRepository.findByFollowing_Id(id)
                    .stream()
                    .map(Follow::getFollowe).map(Usuario::toUsuarioDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}
