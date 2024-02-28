package tyz.corporation.cafeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tyz.corporation.cafeapplication.entity.IndividualEntrepreneur;

@Repository
public interface IndividualEntrepreneurRepository extends JpaRepository<IndividualEntrepreneur, Integer> {
}
