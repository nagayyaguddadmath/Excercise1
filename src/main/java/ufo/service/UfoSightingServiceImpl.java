package ufo.service;

import java.util.List;
import java.util.stream.Collectors;

import ufo.dto.UfoSighting;
import ufo.util.Constants;
import ufo.util.UfoSightingFileReader;

public class UfoSightingServiceImpl implements UfoSightingService {

	private List<UfoSighting> ufoSightingsList;

	public List<UfoSighting> getAllSightings() {

		try {
			List<String> ufoSightings = UfoSightingFileReader.readTSVFile(Constants.FILENAME.getValue());

			ufoSightingsList = convertToUfoList(ufoSightings);

			return ufoSightingsList;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occurred while Reading given TSV File: " + e.getMessage());
		}
		return null;
	}

	public List<UfoSighting> search(int yearSeen, int monthSeen) {

		String search = yearSeen + "" + (monthSeen < 10 ? "0" + monthSeen : monthSeen);
		List<UfoSighting> ufoOnGivenMonth = ufoSightingsList.parallelStream().filter(u -> u.getDateSeen().startsWith(search)).collect(Collectors.toList());

		return ufoOnGivenMonth;
	}

	private List<UfoSighting> convertToUfoList (List<String> ufoSightings) {
		return ufoSightings.parallelStream()
				.filter(u -> u.split(Constants.TAB_DELIMITER.getValue()).length > 0)
				.map(this::createUfoObject)
				.collect(Collectors.toList());
	}

	private  UfoSighting createUfoObject (String u) {
		String[] ufo = u.split(Constants.TAB_DELIMITER.getValue());
		return new UfoSighting(ufo[0]
				,ufo.length > 1 ? ufo[1] : ""
					,ufo.length > 2 ? ufo[2] : ""
						,ufo.length > 3 ? ufo[3] : ""
							,ufo.length > 4 ? ufo[4] : ""
								,ufo.length > 5 ? ufo[5] : ""
				);

	}
}
