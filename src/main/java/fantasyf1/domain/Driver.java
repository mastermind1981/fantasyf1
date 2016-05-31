package fantasyf1.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Driver extends AutogeneratedPK implements Comparable<Driver>, PointScorer {
	
	@Column(unique = true)
	private int number;
	private String name;
	private int price;
	
	private boolean standin;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Integer, Integer> standinRoundsDrivers;

	@ManyToOne(targetEntity = Car.class, fetch = FetchType.EAGER)
	private Car car;
	private int fastestLaps;
	private long totalPoints;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Integer, Integer> pointsPerEvent = new LinkedHashMap<>();

	public Driver() {
	}

	public Driver(final String name, final int number, final Car car,
			final int price) {
		this.number = number;
		this.name = name;
		this.car = car;
		this.price = price;
	}
	
	public Driver(final String name, final int number, final Car car,
			final int price, Map<Integer, Integer> standinRoundsDrivers) {
		this.number = number;
		this.name = name;
		this.car = car;
		this.price = price;
		this.standin = true;
		this.standinRoundsDrivers = standinRoundsDrivers;
	}

	@Override
	public boolean equals(final Object otherDriver) {
		if (otherDriver instanceof Driver) {
			if (number == ((Driver) otherDriver).getNumber()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public int compareTo(final Driver o) {
		return name.compareToIgnoreCase(o.getName());
	}
}
