package util;

import java.io.IOException;

public class Blast {
	public static void referenceFile(String referencePath, char fileType, String dbOutput, String name)
			throws IOException {
		Runtime runReference = Runtime.getRuntime();
		String referenceCommand = "formatdb " + "-i " + referencePath + " -p " + fileType + " -n " + dbOutput + name;
		runReference.exec(referenceCommand);
		System.out.println();
		System.out.println("DONE.");
	}

	public static void queryFile(String queryPath, String blastType, String dbPath, char dbType, String resultPath,
			String resultFile) throws IOException  {
		Runtime runQuery = Runtime.getRuntime();
		String queryCommand = "blastall " + "-p " + blastType + " -i " + queryPath + " -d " + dbPath + " -F " + dbType
				+ " -o " + resultPath + resultFile + " -e " + "1e-05 " + "-m09";
		runQuery.exec(queryCommand);
		System.out.println();
		System.out.println("DONE.");

	}

}
