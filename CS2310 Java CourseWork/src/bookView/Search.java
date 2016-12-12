package bookView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Search {
	/**
	 * The BookIndexer whose indexes are to be searched through
	 */
	private BookIndexer bi;
	/**
	 * A Map mapping Integers to WordCoordinates i.e. kwickID to the WordCoordinate of the word
	 * for which the wider context is being found.
	 */
	private Map<Integer, WordCoordinate> widerContextSearchMap;
	
	/**
	 * The constructor of a new Search Object.
	 * @param bi - The BookIndexer to search through the indexes of.
	 */
	public Search(BookIndexer bi){
		this.bi = bi;
		widerContextSearchMap = new HashMap<>();
	}
	
	/**
	 * Search for the key word and return it and its context.
	 * @param inputSearch - the word whose context is being found.
	 * @param contextSize - the number of neighbouring words to search for.
	 * @return The results from the search.
	 */
	public String search(String inputSearch, int contextSize){
		StringBuffer sb = new StringBuffer();

		Map<String, ArrayList<WordCoordinate>> emmaWord = bi.getEmmaIndex();
		Map<String, ArrayList<WordCoordinate>> pandpWord = bi.getPandPIndex();
		Map<String, ArrayList<WordCoordinate>> mansfieldParkWord = bi.getMansfieldParkIndex();
		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		Map<Integer, String> pandpID = bi.getPandPIDIndex();
		Map<Integer, String> mansfieldParkID = bi.getMansfiledParkIDIndex();
		
		//reset the widerContext map
		widerContextSearchMap = new HashMap<>();
		
		//construct an ArrayList of WordCoordinates to search through
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
		
		//Construct a Map of all wordID's and their words to find neighbouring 
		//words from.
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
				//Find neighbouring words in context
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
	
	/**
	 * Search for the key word and return it and its context.
	 * <p>Default for kwic, uses contextSize of 10</p>
	 * @param inputSearch - the word whose context is being found.
	 * @return The results from the search.
	 */
	public String search(String inputSearch) {
		return search(inputSearch, 10);
	}
	/**
	 * Finds the wider context of given kwicID using its WordCoordinate
	 * @param kwicID - The ID of the result to find the wider context for.
	 * @return The wider context of the result.
	 */
	public String getWiderContext(String kwicID){
		
		if(widerContextSearchMap.containsKey(Integer.parseInt(kwicID))){
			return widerContextSearchMap.get(Integer.parseInt(kwicID)).toString();
		}else{
			return "\nThe ID: "+ kwicID +" doesn't exist in this context.";
		}
	}

}
