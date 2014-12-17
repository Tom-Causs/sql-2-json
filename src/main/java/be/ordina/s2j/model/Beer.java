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
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String brand;
	
	@Column(name="categoryid")
    private String category;
	
    @Column(name="alcohol")
    private double alcohol;
    
    @Column(name="price")
    private double price;

}
