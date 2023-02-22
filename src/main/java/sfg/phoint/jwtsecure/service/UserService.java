package sfg.phoint.jwtsecure.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import sfg.phoint.jwtsecure.domain.AppUser;
import sfg.phoint.jwtsecure.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName) throws ChangeSetPersister.NotFoundException;
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
