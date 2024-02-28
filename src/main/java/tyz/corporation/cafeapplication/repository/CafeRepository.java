package tyz.corporation.cafeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tyz.corporation.cafeapplication.entity.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
