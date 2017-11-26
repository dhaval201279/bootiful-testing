/**
 * 
 */
package com.example.bootifultesting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dhaval
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

}
