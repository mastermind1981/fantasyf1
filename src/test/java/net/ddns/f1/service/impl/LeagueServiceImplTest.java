package net.ddns.f1.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import net.ddns.f1.FantasyF1Application;
import net.ddns.f1.domain.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FantasyF1Application.class)
@WebAppConfiguration
public class LeagueServiceImplTest {
	
	@Autowired
	private LeagueServiceImpl service;

	@Test
	public void calculateLeagueStandingsTest() {
		List<Team> standings = service.calculateLeagueStandings();
		assertTrue(standings.size() > 0);
	}

}
