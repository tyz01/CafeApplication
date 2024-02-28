package tyz.corporation.cafeapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tyz.corporation.cafeapplication.entity.Cafe;
import tyz.corporation.cafeapplication.service.CafeService;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeRestController {

    private final CafeService cafeService;

    @PostMapping("/create")
    public ResponseEntity<String> createCafe(@RequestBody Cafe cafe){
        return cafeService.createCafe(cafe);
    }
}
