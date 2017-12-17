package ufo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class UfoSightingFileReader {

	public static List<String> readTSVFile(String fileName) throws Exception {

		try {
			InputStream  inputFile = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
			if (inputFile == null) {
				throw new FileNotFoundException("Error: Given File not found");
			}
			List<String> ufoSightings = IOUtils.readLines(inputFile);

			return ufoSightings;
		}  catch (FileNotFoundException ex) {
			System.out.println("Error: Given File not found: " +ex.getMessage());
			throw ex;
		} catch (IOException ex) {
			System.out.println("Error: error occurred while reading given file: " +ex.getMessage());
			throw ex;
		}
	}


}
