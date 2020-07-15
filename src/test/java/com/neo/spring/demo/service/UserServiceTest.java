package com.neo.spring.demo.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.spring.demo.model.User;
import com.neo.spring.demo.model.UserDetails;
import com.neo.spring.demo.model.UserEducation;
import com.neo.spring.demo.model.UserEmployment;
import com.neo.spring.demo.repository.UserRepository;
import com.neo.spring.demo.serviceImpl.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepo;

	User user1;
	User user2;

	//	void setUser(User user) {
	//		user.getUserEducation().setUser(user);
	//        user.getUserDetails().setUser(user);
	//        user.getUserEducation().setUser(user);
	//        user.getUserEmployment().forEach(userEmployment -> userEmployment.setUser(user));
	//    }
	//	


	@BeforeEach
	public void setUp() {

		user1 = new User(1,
				"john",
				"P@ssw0rd",
				true,
				Calendar.getInstance(),
				new UserDetails(1,
						"john",
						"cena",
						"dombivali",
						"a@gmail.com",
						"female",
						Calendar.getInstance()),
				new UserEducation(1,
						86.32f,
						81.83f,
						9f,
						"mh",
						"mh",
						"mu",
						Calendar.getInstance()),
				Arrays.asList(new UserEmployment(1,
						"neosoft",
						new Date(),
						new Date(),
						"java",
						"rabale",
						Calendar.getInstance()),
						new UserEmployment(2,
								"nsdl",
								new Date(),
								new Date(),
								"java",
								"parel",
								Calendar.getInstance())));
		//setUser(user1);

		user2 = new User(2,
				"john",
				"P@ssw0rd",
				true,
				Calendar.getInstance(),
				new UserDetails(2,
						"john",
						"cena",
						"dombivali",
						"a@gmail.com",
						"female",
						Calendar.getInstance()),
				new UserEducation(2,
						86.32f,
						81.83f,
						9f,
						"mh",
						"mh",
						"mu",
						Calendar.getInstance()),
				Arrays.asList(new UserEmployment(2,
						"neosoft",
						new Date(),
						new Date(),
						"java",
						"rabale",
						Calendar.getInstance()),
						new UserEmployment(4,
								"nsdl",
								new Date(),
								new Date(),
								"java",
								"parel",
								Calendar.getInstance())));
		//setUser(user2);
	}


	//	@Test
	//    public void getUsers() throws Exception{
	//        List<User> expectedResult = Arrays.asList(user1);
	//
	//        doReturn(expectedResult).when(userRepo).findActiveUser();
	//
	//        String actualResult = userService.getAllActiveUsers();
	//
	//        assertThat(expectedResult).isEqualTo(actualResult);
	//
	//        verify(userRepo).findActiveUser();
	//    }

//	@Test
//	public void addUser() throws Exception{
//
//		doReturn(user1).when(userRepo).save(user1);
//
//		User expectedResult = user1;
//
//		String actualResult = userService.addUser(user1.toString());
//
//		assertThat(expectedResult).isEqualTo(actualResult);
//
//		verify(userRepo).save(any());
//	}
	@Test
	public void getUsersTest() throws Exception {
		System.out.println("!!!!!!!!!"+user1);
		System.out.println("!!!!!!!!!"+user2);

		List<User> expectedResult = Arrays.asList(user1,user2);
		System.out.println("@@@@@@"+userRepo.findActiveUser());

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+expectedResult);
		System.out.println("@@@@@@"+userRepo.findAll());

		System.out.println("@@@@@@"+userRepo.findActiveUser());
		when(userRepo.findActiveUser()).thenReturn(expectedResult);
		String actualResult = userService.getAllActiveUsers();
		assertThat(expectedResult).isEqualTo(actualResult);

	}



}
