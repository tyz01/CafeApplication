package tyz.corporation.cafeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tyz.corporation.cafeapplication.entity.User;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository
        extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

}