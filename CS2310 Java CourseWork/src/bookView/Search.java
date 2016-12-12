package bookView;

<<<<<<< HEAD
import java.util.Scanner;

import bookView.BookIndexer.WordCoordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
		Map<String, ArrayList<WordCoordinate>> emma = bi.getEmmaIndex();
		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		
		ArrayList<WordCoordinate> aList = emma.get(string);
			
			if(!aList.isEmpty()){
				for(WordCoordinate w : emma.get(string)){
				int stringID = w.getID();
				
				}
			}else{
				return "List is Empty";
			}
		
		
		if(emma.containsKey(string)){
            System.out.println("Found" + string);
        } else {
            System.out.println("Word Not Found");
        }

		return string;
		
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Search {
	
	public String search(String inputSearch){
		
		return "";
	}
	
	public String search(String inputSearch, int contextSize){
		
		return "";
	}
	
	
	public String getWiderContext(String kwicID){
		
		return "";
>>>>>>> master
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	public String search(String word, int contextSize) {
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////
	
}
