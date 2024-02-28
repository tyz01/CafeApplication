package tyz.corporation.cafeapplication.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tyz.corporation.cafeapplication.entity.User;
import tyz.corporation.cafeapplication.entity.type.Role;
import tyz.corporation.cafeapplication.repository.UserRepository;
import tyz.corporation.cafeapplication.service.UserService;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final UserRepository userRepository;

    public ResponseEntity<String> register(RegistrationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.OK);
        }


        userService.singUpIndividualEntrepreneur(request);
       return new ResponseEntity<>("successfully registration", HttpStatus.OK);
    }

}

