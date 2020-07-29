package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@MockBean
	UserRepository userRepository;


	//@BeforeEach
	void saveUsers(){

		System.out.println(userRepository.count());

		User user1 = new User(1,"tudor1","root1");
		User user2 = new User(2,"tudor2","root2");
		User user3 = new User(3,"tudor3","root3");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		assertEquals(3,userRepository.count());
		System.out.println(userRepository.count());
	}


	@Test
	void loadUserByUsername() {
		when(userRepository.findByUsername("tudor1")).thenReturn(new User(1,"tudor1","root1"));

		assertEquals(new User(1, "tudor1", "root1"), userRepository.findByUsername("tudor1"));
	}


	//@AfterEach
	void deleteAll(){

		userRepository.deleteAll();

		assertEquals(0,userRepository.count());
	}

	//@Disabled
	@Test
	void contextLoads() {
	}

}
