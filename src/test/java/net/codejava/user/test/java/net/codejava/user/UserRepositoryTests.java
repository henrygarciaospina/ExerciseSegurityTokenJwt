package net.codejava.user.test.java.net.codejava.user;

import net.codejava.user.User;
import net.codejava.user.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest

@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;


	public UserRepositoryTests() {
	}

	@Test
	public void testExisEmail() {

		String email = "nam@codejava.com";

		Optional<User> findUser;

		findUser = repo.findByEmail(email);

		assertThat(findUser.orElse(null)).isNotNull();
	}

	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String password = passwordEncoder.encode("nam2020");
		String email = "henry@codejava.com";

		Optional<User> findUser;
		User newUser = new User(email, password);

		findUser = repo.findByEmail(email);

		assertThat(findUser.orElse(null)).isNull();

		repo.save(newUser);
	}
}