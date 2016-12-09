package bookView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Main {
	
	public static void main(String[] args){
		Search s = new Search();
		long startTime = (new Date()).getTime();
		s.search("man");
		long endTime = (new Date()).getTime();
		System.out.println(endTime - startTime);
		
		
		BookIndexer bi = new BookIndexer();
		Map<String, ArrayList<WordCoordinate>> emmaHt = bi.getEmmaIndex();
		Map<String, ArrayList<WordCoordinate>> pandpHt = bi.getPandPIndex();
		Map<String, ArrayList<WordCoordinate>> mansfieldParkHt = bi.getMansfieldParkIndex();
		
		long start = (new Date()).getTime();
		int total = 0;
		if(emmaHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords = emmaHt.get("the");
			for(WordCoordinate wordCoord : wordCoords){
				System.out.println(wordCoord);
			}
			total += wordCoords.size();
			System.out.println(wordCoords.size());
		}else{
			System.out.println("No results found in emma");
		}
		if(pandpHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords = pandpHt.get("the");
			for(WordCoordinate wordCoord : wordCoords){
				System.out.println(wordCoord);
			}
			total += wordCoords.size();
			System.out.println(wordCoords.size());
		}else{
			System.out.println("No results found in pandp");
		}
		if(mansfieldParkHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords = mansfieldParkHt.get("the");
			for(WordCoordinate wordCoord : wordCoords){
				System.out.println(wordCoord);
			}
			total += wordCoords.size();
			System.out.println(wordCoords.size());
		}else{
			System.out.println("No results found in mansfieldPark");
		}
		
		System.out.println(total);
		long end = (new Date()).getTime();
		System.out.println(end - start);
	}
}
