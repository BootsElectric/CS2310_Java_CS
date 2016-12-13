package bookView;

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
	
	private BookIndexer bi;
	private Map<Integer, WordCoordinate> WIC;
	
	public Search(BookIndexer bi){
		
		this.bi=bi;
		WIC = new HashMap<>();
		
	}

	public String search(String string) {

		return search(string, 10);
	}

	public String search(String string, int contextSize) {
		
		BookIndexer bi = new BookIndexer();
		StringBuffer sb = new StringBuffer();

		Map<String, ArrayList<WordCoordinate>> emma = bi.getEmmaIndex();
		Map<String, ArrayList<WordCoordinate>> pandp = bi.getPandPIndex();
		Map<String, ArrayList<WordCoordinate>> mansfieldPark = bi.getMansfieldParkIndex();
		
		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		Map<Integer, String> pandpID = bi.getPandPIDIndex();
		Map<Integer, String> mansfieldParkID = bi.getMansfiledParkIDIndex();

		ArrayList<WordCoordinate> contexts = new ArrayList<>();
		Map<Integer, String> kwicIDs = new HashMap<>();
		
		if(emma.get(string) != null){
			contexts.addAll(emma.get(string));
		}
		if(pandp.get(string) != null){
			contexts.addAll(pandp.get(string));
		}
		if(mansfieldPark.get(string) != null){
			contexts.addAll(mansfieldPark.get(string));
		}
		
		kwicIDs.putAll(emmaID);
		kwicIDs.putAll(pandpID);
		kwicIDs.putAll(mansfieldParkID);
		
		WIC = new HashMap<>();

		if(!contexts.equals(null)){
			
			for(WordCoordinate w : contexts){
				int stringID = w.getID();
				int kwicID = contexts.indexOf(w);
				sb.append(kwicID);
				sb.append(":\t");
				WIC.put(kwicID, w);
				
				for(int i = stringID-contextSize; i<stringID+(contextSize+1); i++){
					if(emmaID.get(i) != null){
					sb.append(emmaID.get(i));
					sb.append(" ");
					}
				}
				sb.append("\n");
				
			}
		}else{
			
			return "List is Empty";
			
		}
		
		return sb.toString();
		
	}
	
	public String getWiderContext(String kwicID){

		if(WIC.containsKey(Integer.parseInt(kwicID))){
			return WIC.get(Integer.parseInt(kwicID)).toString();
			
		}else{
			
			return "User Input Error!!!";
			
		}
	}

}
