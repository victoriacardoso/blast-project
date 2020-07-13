package application;

import java.io.IOException;
import java.util.Scanner;

import util.Blast;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int option;

		try {
			do {
				System.out.println("1- Format my reference file to database first");
				System.out.println("2- Compare my sequence file with database already formatted");
				System.out.println("3- Exit");
				option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.println("Enter the reference file path in fasta format: ");
					sc.nextLine();
					String referencePath = sc.nextLine();

					System.out.println("Choose the type of file: ");
					System.out.println("'T' for protein");
					System.out.println("'F' for nucleotide");
					char fileType = sc.next().charAt(0);

					System.out.println("Enter the path where you want save your database: ");
					sc.nextLine();
					String dbOutput = sc.nextLine();

					System.out.println("Choose a name for your database: ");
					String name = sc.nextLine();

					Blast.referenceFile(referencePath, fileType, dbOutput, name);

					break;

				case 2:
					System.out.println("Write the type of blast: ");
					System.out.println("blastn");
					System.out.println("blastp");
					System.out.println("blastx");
					System.out.println("tblastn");
					System.out.println("tblastx");
					sc.nextLine();
					String blastType = sc.nextLine().toLowerCase();

					System.out.println("Enter the file path of assembly sequence you want compare in fasta format: ");
					String queryPath = sc.nextLine();

					System.out.println("Enter the reference file path in database format");
					String dbPath = sc.nextLine();

					System.out.println("Choose the type of database file: ");
					System.out.println("'T' for protein");
					System.out.println("'F' for nucleotide");
					char dbType = sc.next().charAt(0);

					System.out.println("Enter the path where you want save the result file: ");
					sc.nextLine();
					String resultPath = sc.nextLine();
					System.out.println("Choose a name and a type of result file of compare (ex: name.txt)");
					String resultFile = sc.nextLine();

					Blast.queryFile(queryPath, blastType, dbPath, dbType, resultPath, resultFile);

					break;

				case 3:
					System.out.println("End of program");
				}
			}

			while (option != 3);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} finally {
			sc.close();
		}
	}
}
