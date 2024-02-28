package tyz.corporation.cafeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tyz.corporation.cafeapplication.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
