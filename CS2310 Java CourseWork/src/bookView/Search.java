package bookView;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

public class Search {

	int countNum = 0;
	int countBuffer = 0;
	int countLine = 0;
	int lineNum = 0;

	String filePath = "\\Users\\RCHAN\\Documents\\Assignment\\2016-2017\\CS2310 - Data Str&Alg Java\\CS2310_Java_CS\\CS2310 Java CourseWork\\dataemmaEd11.txt";
	BufferedReader br;
	String line = "";

	public String search(String inputSearch) {
		try {
			br = new BufferedReader(new FileReader(filePath));
			try {
				while ((line = br.readLine()) != null) {
					countLine++;
					String[] words = line.split(" ");

					for (String word : words) {
						if (word.equals(inputSearch)) {
							countNum++;
							countBuffer++;
						}
					}
					if (countBuffer > 0) {
						countBuffer = 0;
						lineNum += countLine;
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Found" + countNum + "Times");
		System.out.println("Found on" + lineNum + "Line");
		return "";
	}
}
