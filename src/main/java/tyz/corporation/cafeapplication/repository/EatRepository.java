package tyz.corporation.cafeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tyz.corporation.cafeapplication.entity.Eat;

@Repository
public interface EatRepository extends JpaRepository<Eat, Integer> {
}
