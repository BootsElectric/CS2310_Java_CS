package bookView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Search {

	private BookIndexer bi;
	private Map<Integer, WordCoordinate> widerContextSearchMap;
	
	public Search(BookIndexer bi){
		this.bi = bi;
		widerContextSearchMap = new HashMap<>();
	}
	
	public String search(String inputSearch, int contextSize){
		StringBuffer sb = new StringBuffer();

		Map<String, ArrayList<WordCoordinate>> emmaWord = bi.getEmmaIndex();
		Map<String, ArrayList<WordCoordinate>> pandpWord = bi.getPandPIndex();
		Map<String, ArrayList<WordCoordinate>> mansfieldParkWord = bi.getMansfieldParkIndex();
		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		Map<Integer, String> pandpID = bi.getPandPIDIndex();
		Map<Integer, String> mansfieldParkID = bi.getMansfiledParkIDIndex();
		widerContextSearchMap = new HashMap<>();
		ArrayList<WordCoordinate> contexts = new ArrayList<>();
		if (emmaWord.containsKey(inputSearch)){
			contexts.addAll(emmaWord.get(inputSearch));	
		}
		if (pandpWord.containsKey(inputSearch)){
			contexts.addAll(pandpWord.get(inputSearch));
		}
		if (mansfieldParkWord.containsKey(inputSearch)){
			contexts.addAll(mansfieldParkWord.get(inputSearch));
		}
		Map<Integer, String> allWords = new HashMap<>();
		allWords.putAll(emmaID);
		allWords.putAll(pandpID);
		allWords.putAll(mansfieldParkID);

		if (!contexts.isEmpty()){
			for(WordCoordinate wc : contexts){
				int wordID = wc.getID();
				int kwicID = contexts.indexOf(wc);

				widerContextSearchMap.put(kwicID, wc);

				sb.append("ID ");
				sb.append(kwicID);
				sb.append(":\t");
				for(int i = wordID -contextSize; i <= wordID + contextSize; i++){
					String word = allWords.get(i);
					sb.append(word);
					sb.append(" ");
				}
				sb.append("\n");
			}

			return sb.toString();
		}
		return "No Results Found";
	}

	public String search(String inputSearch) {
		return search(inputSearch, 10);
	}
	
	public String getWiderContext(String kwicID){
		
			if(widerContextSearchMap.containsKey(Integer.parseInt(kwicID))){
				return widerContextSearchMap.get(Integer.parseInt(kwicID)).toString();
			}else{
				return "\nThe ID: "+ kwicID +" doesn't exist in this context.";
			}
	}

}
