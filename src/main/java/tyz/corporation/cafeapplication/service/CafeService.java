package tyz.corporation.cafeapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tyz.corporation.cafeapplication.entity.Cafe;
import tyz.corporation.cafeapplication.repository.CafeRepository;

@Service
@RequiredArgsConstructor
public class CafeService {

    private final CafeRepository cafeRepository;

    public ResponseEntity<String> createCafe(Cafe cafe) {
        cafeRepository.save(cafe);
        return new ResponseEntity<>("cafe created successfully", HttpStatus.OK);
    }
}
