/**
 * 
 */
package com.example.bootifultesting;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dhaval
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	Collection <Reservation> findByName(String string); 

	//void save(Reservation reservation);

}
