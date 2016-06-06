package fantasyf1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class EventResult extends AutogeneratedPK implements Comparable<EventResult> {
	@Column(unique = true)
	private int round;
	private String venue;
	private int season;
	private boolean raceComplete;
	@OneToOne(targetEntity = TheoreticalTeam.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TheoreticalTeam bestTheoreticalTeam;
	@ManyToOne(targetEntity = Driver.class, fetch = FetchType.EAGER)
	private Driver fastestLapDriver;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, Position> qualifyingOrder;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, Position> raceOrder;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> remarks;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Integer> finishingBonuses;

	@Override
	public int compareTo(final EventResult otherEvent) {
		if (round > otherEvent.getRound()) {
			return 1;
		} else if (round < otherEvent.getRound()) {
			return -1;
		} else {
			return 0;
		}
	}

	public void addRemark(final String remark) {
		if (remarks == null) {
			remarks = new ArrayList<>();
		}

		if (!remarks.contains(remark)) {
			remarks.add(remark);
		}
	}
	
	public List<Integer> getFinishingBonuses() {
		if(finishingBonuses == null) {
			finishingBonuses = new ArrayList<>();
		}
		return finishingBonuses;
	}
}
