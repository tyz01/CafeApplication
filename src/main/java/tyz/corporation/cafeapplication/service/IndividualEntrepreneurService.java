package tyz.corporation.cafeapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tyz.corporation.cafeapplication.controller.response.IndividualEntrepreneurResponse;
import tyz.corporation.cafeapplication.entity.IndividualEntrepreneur;
import tyz.corporation.cafeapplication.repository.IndividualEntrepreneurRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IndividualEntrepreneurService {
    private final IndividualEntrepreneurRepository individualEntrepreneurRepository;
    public void registerIndividualEntrepreneur(IndividualEntrepreneur individualEntrepreneur) {
        individualEntrepreneurRepository.save(individualEntrepreneur);
    }

    public ResponseEntity<String> addDataForIndividualEntrepreneur(IndividualEntrepreneurResponse individualEntrepreneurResponse){
        Optional<IndividualEntrepreneur> individualEntrepreneur = individualEntrepreneurRepository.findById(individualEntrepreneurResponse.getId())
                .map(ie -> {
                    ie.setNumberIE(individualEntrepreneurResponse.getNumberIE());
                    ie.setNumberPhone(individualEntrepreneurResponse.getNumberPhone());
                    return ie;
                });
        IndividualEntrepreneur newIE = individualEntrepreneur.get();
        individualEntrepreneurRepository.save(newIE);
        return ResponseEntity.ok("ie was updated");
    }

}
