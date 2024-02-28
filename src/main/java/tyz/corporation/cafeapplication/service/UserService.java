package tyz.corporation.cafeapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tyz.corporation.cafeapplication.entity.IndividualEntrepreneur;
import tyz.corporation.cafeapplication.entity.User;
import tyz.corporation.cafeapplication.entity.type.Role;
import tyz.corporation.cafeapplication.registration.RegistrationRequest;
import tyz.corporation.cafeapplication.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG =
            "user with username %s not found";

    private final UserRepository userRepository;
    private final IndividualEntrepreneurService individualEntrepreneurService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, username)));
    }

    public void signUpUser(User user) {
        boolean userExists = userRepository
                .findByUsername(user.getUsername())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("username already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    public void singUpIndividualEntrepreneur(RegistrationRequest request) {
        User newUser = setAttributeForUser(request);
        signUpUser(newUser);

        IndividualEntrepreneur newIndividualEntrepreneur = new IndividualEntrepreneur();
        newIndividualEntrepreneur.setUser(newUser);
        individualEntrepreneurService.registerIndividualEntrepreneur(newIndividualEntrepreneur);
        newUser.setRole(Role.MODERATOR);
        userRepository.save(newUser);
    }

    private User setAttributeForUser(RegistrationRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        return newUser;
    }
}
