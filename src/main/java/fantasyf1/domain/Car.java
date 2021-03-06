package fantasyf1.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Car extends AutogeneratedPK implements Comparable<Car>, PointScorer {	
	@Column(unique = true)
	private String name;
	private int price;
	@OneToOne(targetEntity = Engine.class, fetch = FetchType.EAGER)
	private Engine engine;

	private int bothCarsFinishBonuses;
	private long totalPoints;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Integer, Integer> pointsPerEvent = new LinkedHashMap<>();

	public Car() {
	}

	public Car(final String name, final int price, final Engine engine) {
		this.name = name;
		this.price = price;
		this.engine = engine;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(final Car car) {
		return name.compareToIgnoreCase(car.getName());
	}
}
