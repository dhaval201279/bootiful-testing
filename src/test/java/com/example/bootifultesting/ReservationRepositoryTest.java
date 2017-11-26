/**
 * 
 */
package com.example.bootifultesting;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dhaval
 *
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

	@Autowired
	ReservationRepository repository;
	
	@Test
	public void findByName() {
		this.repository.save(new Reservation(null, "Shruti"));
		
		Collection <Reservation> byReservationName = this.repository.findByName("Shruti");
		
		Assertions.assertThat(byReservationName.size()).isEqualTo(1);
		Assertions.assertThat(byReservationName.iterator().next().getId()).isGreaterThan(0);
		Assertions.assertThat(byReservationName.iterator().next().getName()).isEqualTo("Shruti");
	}

}
