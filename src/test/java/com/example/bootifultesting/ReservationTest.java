package com.example.bootifultesting;

import static org.junit.Assert.fail;

import org.assertj.core.api.Assertions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReservationTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void creation() {
		Reservation r = new Reservation(1L, "Yatharth");
		Assert.assertEquals(r.getId(), (Long) 1L);
		/* Use BaseMatcher for creating stand alone packages that can be used in doing asserts for complex matches 
		 * to be done in JUnit
		 */
		/*Assert.assertThat(r.getId(), new BaseMatcher<Long>() {

			@Override
			public boolean matches(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void describeTo(Description arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
		Assert.assertThat(r.getId(), Matchers.equalTo(1L));
		/*
		 * Assertions provide type safe way of doing asserts
		 * */
		
		Assertions.assertThat(r.getId().equals(1L));
		
		Assertions.assertThat(r.getName()).isNotBlank();
		
		Assertions.assertThat(r.getName()).isEqualTo("Yatharth");
	}

}
