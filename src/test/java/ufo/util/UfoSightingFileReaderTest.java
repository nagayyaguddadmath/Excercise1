package ufo.util;

import java.io.FileNotFoundException;

import org.junit.Test;

public class UfoSightingFileReaderTest {

	@Test (expected = FileNotFoundException.class)
	public void checkForWrongPathOfFile() throws Exception {

		UfoSightingFileReader.readTSVFile("wrongFile");
	}


}
