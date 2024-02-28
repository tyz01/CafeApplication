package tyz.corporation.cafeapplication.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;

    public ResponseEntity<String> login(LoginRequest loginRequest) {
        ResponseEntity<String> response;

        if (!StringUtils.hasText(loginRequest.getUsername()) || !StringUtils.hasText(loginRequest.getPassword())) {
            return ResponseEntity.ok("Username or password is empty");
        }

        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
            Authentication authenticated = authenticationManager.authenticate(authentication);

            if (!authenticated.isAuthenticated()) {
                response = ResponseEntity.ok("User not authenticated");
            } else {
                SecurityContextHolder.getContext().setAuthentication(authenticated);
                response = ResponseEntity.ok("Login successful!");
            }

        } catch (AuthenticationException e) {
            response = ResponseEntity.ok("Check username or password");
        }

        return response;
    }
}
