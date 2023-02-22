package sfg.phoint.jwtsecure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sfg.phoint.jwtsecure.domain.AppUser;
import sfg.phoint.jwtsecure.domain.Role;
import sfg.phoint.jwtsecure.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class JwtsecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtsecureApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Arnol Schwarzenegger", "anorl", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_USER");
			userService.addRoleToUser("jim", "ROLE_USER");
			userService.addRoleToUser("anorl", "ROLE_USER");
			userService.addRoleToUser("anorl", "ROLE_ADMIN");
			userService.addRoleToUser("anorl", "ROLE_SUPER_ADMIN");
		};
	}
}
