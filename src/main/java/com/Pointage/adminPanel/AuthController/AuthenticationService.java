package com.Pointage.adminPanel.AuthController;


import com.Pointage.adminPanel.model.Role;
import com.Pointage.adminPanel.model.User;
import com.Pointage.adminPanel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService ;
    private final AuthenticationManager authenticationManager ;

    public AuthenticationResponse register(RegisterRequest request) {
        Role userRole = Role.valueOf(request.getRole().toUpperCase());

        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(userRole)
                .build();

        userRepository.save(user) ;
        var jwtToken = jwtService.generateToken(user) ;
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build() ;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail() ,
                        request.getPassword()
                )
        ) ;
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow() ;

        var jwtToken = jwtService.generateToken(user) ;
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build() ;
    }

    public User getUserFromToken(String token) {
        String username = jwtService.extractUsername(token);
        return userRepository.findByEmail(username).orElseThrow(
                () -> new IllegalArgumentException("User not found")
        );
    }

}

