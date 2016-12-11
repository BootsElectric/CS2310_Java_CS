package bookView;

import java.util.Scanner;
import java.util.HashMap;
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
	
	//////////////////////////////////////////////////////////////////////////

	public String search(String string) {
		
		BookIndexer bi;
		bi = new BookIndexer();
		BookIndexer.get(emmaHashtables);
		
		if(emmaHashtables.containsValue(string)){
            System.out.println("Found" + string);
        } else {
            System.out.println("Word Not Found");
        }
		
		
		return string;
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	public String search(String word, int contextSize) {
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////
	
}
