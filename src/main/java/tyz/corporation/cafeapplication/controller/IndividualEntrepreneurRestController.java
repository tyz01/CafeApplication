package tyz.corporation.cafeapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyz.corporation.cafeapplication.controller.response.IndividualEntrepreneurResponse;
import tyz.corporation.cafeapplication.service.IndividualEntrepreneurService;

@RestController
@RequestMapping("/ie")
@RequiredArgsConstructor
public class IndividualEntrepreneurRestController {
    private final IndividualEntrepreneurService individualEntrepreneurService;

    @PutMapping("/data")
    public ResponseEntity<String> addDataForIndividualEntrepreneur(IndividualEntrepreneurResponse individualEntrepreneurResponse){
       return individualEntrepreneurService.addDataForIndividualEntrepreneur(individualEntrepreneurResponse);
    }
}
