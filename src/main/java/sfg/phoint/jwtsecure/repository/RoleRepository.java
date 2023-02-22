package sfg.phoint.jwtsecure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfg.phoint.jwtsecure.domain.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
