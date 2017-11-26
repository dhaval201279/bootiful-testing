/**
 * 
 */
package com.example.bootifultesting;

import static org.junit.Assert.fail;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dhaval
 *
 */
// Loads entire application context @SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationJpaTest {
	
	@Autowired
	private TestEntityManager tem;

	@Test
	public void mapping() {
		Reservation yatharth = this.tem.persistFlushFind(new Reservation(null, "Yatharth"));
		Assertions.assertThat(yatharth.getName()).isEqualTo("Yatharth");
		Assertions.assertThat(yatharth.getName()).isNotNull();
		Assertions.assertThat(yatharth.getId()).isGreaterThan(0);
	}

}
