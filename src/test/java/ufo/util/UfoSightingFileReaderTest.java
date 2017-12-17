package ufo.util;

import java.io.FileNotFoundException;

import org.junit.Test;

public class UfoSightingFileReaderTest {

	@Test (expected = FileNotFoundException.class)
	public void checkForWrongPathOfFile() throws Exception {

		FileReader.readTSVFileAsList("wrongFile");
	}


}
