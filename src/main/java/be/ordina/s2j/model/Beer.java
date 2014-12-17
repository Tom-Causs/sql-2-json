package be.ordina.s2j.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Beers")
@Data
public class Beer {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String brand;
	
	@Column(name="CategoryId")
    private String category;
	
    @Column(name="Alcohol")
    private double alcohol;
    
    @Column(name="Price")
    private double price;

}
