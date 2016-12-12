package bookView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Search {

	private BookIndexer bi;
	
	public Search(BookIndexer bi){
		this.bi = bi;
	}
	
	public String search(String inputSearch, int contextSize){
		return null;
	}

	public String search(String inputSearch) {
		StringBuffer sb = new StringBuffer();
		
		Map<String, ArrayList<WordCoordinate>> emmaWord = bi.getEmmaIndex();
		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		ArrayList<WordCoordinate> contexts = emmaWord.get(inputSearch);
		
		for(WordCoordinate wc : contexts){
			int wordID = wc.getID();
			int kwicID = contexts.indexOf(wc);
			
			sb.append("ID ");
			sb.append(kwicID);
			sb.append(": ");
			for(int i = wordID -10; i <= wordID + 10; i++){
				String word = emmaID.get(i);
				if (! word.equals("CHAPTER") && ! word.equals("VOLUME")){
					sb.append(word);
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
