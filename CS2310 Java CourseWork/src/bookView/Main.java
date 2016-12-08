package bookView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import bookView.BookIndexer.WordCoordinate;

public class Main {
	
	public static void main(String[] args){
		Search s = new Search();
		long startTime = (new Date()).getTime();
		s.search("the");
		long endTime = (new Date()).getTime();
		System.out.println(endTime - startTime);
		
		
		BookIndexer bi = new BookIndexer();
		Hashtable<String, ArrayList<WordCoordinate>> emmaHt = bi.getEmmaIndex();
		Hashtable<String, ArrayList<WordCoordinate>> pandpHt = bi.getPandPIndex();
		Hashtable<String, ArrayList<WordCoordinate>> mansfieldParkHt = bi.getMansfieldParkIndex();
		
//		if(emmaHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords = emmaHt.get("the");
			for(WordCoordinate wordCoord : wordCoords){
				System.out.println(wordCoord);
			}
			System.out.println(wordCoords.size());
//		}
//		if(pandpHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords1 = pandpHt.get("the");
			for(WordCoordinate wordCoord : wordCoords1){
				System.out.println(wordCoord);
			}
			System.out.println(wordCoords1.size());
//		}
//		if(mansfieldParkHt.containsKey("the")){
			ArrayList<WordCoordinate> wordCoords2 = mansfieldParkHt.get("the");
			for(WordCoordinate wordCoord : wordCoords2){
				System.out.println(wordCoord);
			}
			System.out.println(wordCoords2.size());
//		}
		
	}
}
