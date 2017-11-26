/**
 * 
 */
package com.example.bootifultesting;

import java.util.Collection;
import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhaval
 *
 */
@RestController
public class ReservationRestController {
	private final ReservationRepository reservationRepository;
	
	/**
	 * @param reservationRepository
	 */
	public ReservationRestController(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}



	@GetMapping(value="/reservations", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	Collection <Reservation> reservations() {
		//return Collections.emptyList();
		return this.reservationRepository.findAll();
	}

}
