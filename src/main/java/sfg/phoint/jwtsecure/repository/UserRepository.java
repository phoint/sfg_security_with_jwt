package sfg.phoint.jwtsecure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfg.phoint.jwtsecure.domain.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
