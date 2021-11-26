package com.unittest.codecoverage.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AssertionsSampleTest {
	
	@Test
	public void whenAssertingArraysEquality_thenEqual() {
	    char[] expected = { 'J', 'a', 'v', 'a' };
	    char[] actual = "Java".toCharArray();

	    assertArrayEquals(expected, actual, "Arrays should be equal");
	}
	
	@Test
	public void whenAssertingEquality_thenEqual() {
	    float square = 2 * 2;
	    float rectangle = 2 * 2;

	    assertEquals(square, rectangle);
	}
	
	@Test
	public void whenAssertingConditions_thenVerified() {
	    assertTrue(5 > 4, "5 is greater the 4");
	    assertTrue(null == null, "null is equal to null");
	}
	
	@Test
	public void whenAssertingNull_thenTrue() {
	    Object object = null;

	    assertNull(object, () -> "The object should be null");
	}
	
	@Test
	public void whenAssertingNotNull_thenTrue() {
	    Object object = new Object();

	    assertNotNull(object, () -> "The object should not be null");
	}
	
	@Test
	public void whenAssertingSameObject_thenSuccessfull() {
	    String language = "Java";
	    Optional<String> optional = Optional.of(language);

	    assertSame(language, optional.get());
	}
	

	@Test
	void whenAssertingException_thenThrown() {
	    Throwable exception = assertThrows(
	      IllegalArgumentException.class, 
	      () -> {
	          throw new IllegalArgumentException("Exception message");
	      }
	    );
	    assertEquals("Exception message", exception.getMessage());
	}
	@Test
	void whenInsertingNullPerson_thenThrownException() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			PersonRepository repository = new PersonRepository();
			repository.insert(null);
		});

		assertEquals("person can't be null" ,exception.getMessage());
	}
	@Test
	void whenUpdatingNullPerson_thenThrownException() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			PersonRepository repository = new PersonRepository();
			repository.update(null);
		});

		assertEquals("person can't be null" ,exception.getMessage());
	}
	@Test
	void whenDeletingNullPerson_thenThrownException() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			PersonRepository repository = new PersonRepository();
			repository.delete(null);
		});

		assertEquals("name can't be null" ,exception.getMessage());
	}

	@Test
	void whenGettingNullPerson_thenThrownException() {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			PersonRepository repository = new PersonRepository();
			repository.get(null);
		});

		assertEquals("name can't be null" ,exception.getMessage());
	}
	@Test
	void testSetGetPersonAge(){
		Person person = new Person();
		person.setAge(15);
		assertEquals(15,person.getAge());
	}
}
