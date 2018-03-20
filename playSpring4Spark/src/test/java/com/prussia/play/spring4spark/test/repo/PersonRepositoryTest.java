package com.prussia.play.spring4spark.test.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.prussia.play.spring4spark.PlayApplication;
import com.prussia.play.spring4spark.repo.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PersonRepository.class, PlayApplication.class})
@ActiveProfiles(value = { "test" })
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;

	@Before
	public void setup() {

	}

	@Test
	public void testCount() {
		assertEquals(0, personRepository.count());
	}

}
