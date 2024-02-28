package tyz.corporation.cafeapplication.login;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tyz.corporation.cafeapplication.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginRestController {
    private AuthenticationManager authenticationManager;
    private final UserService userService;


    @GetMapping()
    public String login(@RequestParam String username, @RequestParam String password) {
        try {
            UserDetails userDetails = userService.loadUserByUsername(username);

            if(username.isEmpty() || password.isEmpty()){
                return "userName or password is empty";
            }

            if (!userDetails.isEnabled()) {
                return "confirm your email";
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    password
            );

            Authentication authenticated = authenticationManager.authenticate(authentication);
            if (!authenticated.isAuthenticated()) {
                return "user not authenticated";
            }

            SecurityContextHolder.getContext().setAuthentication(authenticated);
            return "Login successful!";

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "check username or password";
        }
    }
}
