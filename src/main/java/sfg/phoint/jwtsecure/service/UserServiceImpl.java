package sfg.phoint.jwtsecure.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import sfg.phoint.jwtsecure.domain.AppUser;
import sfg.phoint.jwtsecure.domain.Role;
import sfg.phoint.jwtsecure.repository.RoleRepository;
import sfg.phoint.jwtsecure.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) throws ChangeSetPersister.NotFoundException {
        log.info("Adding role {} to user {}", roleName, username);
        AppUser user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(username + "Not Found"));
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException(roleName + "Not Found"));
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(username + "Not Found"));
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all user");
        return userRepository.findAll();
    }
}
