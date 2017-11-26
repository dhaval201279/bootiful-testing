/**
 * 
 */
package com.example.bootifultesting;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author Dhaval
 *
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class ReservationRestControllerTest {

	@MockBean
	private ReservationRepository reservationRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getReservations() throws Exception {
		Mockito.when(this.reservationRepository.findAll())
			.thenReturn(Collections.singletonList(new Reservation(1L,"Yatharth")));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
			.andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Yatharth")) // Ideally this should be done as a separate test case :) this is just for quick impl
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	/* Below is a crude / raw way of mocking the dependent objects present in ReservationRestController
	 * Hence it should not be used.
	 * 
	 * 
	 * @Configuration
	public static class MyConfig {
		@Bean
		ReservationRepository reservationRepository() {
			ReservationRepository mockReservationRepository = Mockito.mock(ReservationRepository.class);
			Mockito.when(mockReservationRepository.findAll()).thenReturn(Arrays.asList(new Reservation(1L,"Yatharth")));
			return mockReservationRepository;
		}
	}*/
}
