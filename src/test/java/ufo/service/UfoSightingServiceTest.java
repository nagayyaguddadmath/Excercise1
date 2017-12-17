package ufo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ufo.dto.UfoSighting;

public class UfoSightingServiceTest {

	@Test
	public void matchUfoSightingListCount() {

		UfoSightingServiceImpl ufoService = new UfoSightingServiceImpl();
		List<UfoSighting> ufoSightingList = ufoService.getAllSightings();

		assertTrue("Total size of UFOSighting objects are not matching from given File", ufoSightingList.size() == 61393);
	}

	@Test
	public void matchUfoSightingCountForGivenMonth_1() {

		UfoSightingServiceImpl ufoService = new UfoSightingServiceImpl();
		List<UfoSighting> ufoSightingList = ufoService.getAllSightings();

		ufoSightingList = ufoService.search(1995, 10);
		assertTrue("Count of UFOSighting objects for given month is not matching", ufoSightingList.size() == 107);
	}

	@Test
	public void matchUfoSightingCountForGivenMonth_2() {

		UfoSightingServiceImpl ufoService = new UfoSightingServiceImpl();
		List<UfoSighting> ufoSightingList = ufoService.getAllSightings();

		ufoSightingList = ufoService.search(1995, 1);
		assertTrue("Count of UFOSighting objects for given month is not matching", ufoSightingList.size() == 91);
	}

}
