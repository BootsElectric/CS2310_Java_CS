package bookView;

import bookView.BookIndexer.WordCoordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Search {

	/**
	 * The BookIndexer to search through.
	 */
	private BookIndexer bi;
	/**
	 * A Map of Integers to WordCoordinates i.e. kwicID to the wider context of the word.
	 */
	private Map<Integer, WordCoordinate> WIC;


	/**
	 * Constructor.
	 * @param bi - The BookIndexer to be searched through.
	 */
	public Search(BookIndexer bi){

		this.bi=bi;
		WIC = new HashMap<>();

	}

	/**
	 * Calls the search(String string, int contextSize) method passing a context size of 10 as default.
	 * @param string - The string to search for.
	 * @return The results of the search: the key word in context.
	 */
	public String search(String string) {

		return search(string, 10);
	}

	/**
	 * Searches through the indexed books and finds the context of the key word.
	 * @param string - The string to search for.
	 * @param contextSize - The number of neighbouring words to find.
	 * @return The results of the search: the key word in context.
	 */
	public String search(String string, int contextSize) {

		BookIndexer bi = new BookIndexer();
		StringBuffer sb = new StringBuffer();

		//Get the indexed books from the BookIndexer
		Map<String, ArrayList<WordCoordinate>> emma = bi.getEmmaIndex();
		Map<String, ArrayList<WordCoordinate>> pandp = bi.getPandPIndex();
		Map<String, ArrayList<WordCoordinate>> mansfieldPark = bi.getMansfieldParkIndex();

		Map<Integer, String> emmaID = bi.getEmmaIDIndex();
		Map<Integer, String> pandpID = bi.getPandPIDIndex();
		Map<Integer, String> mansfieldParkID = bi.getMansfiledParkIDIndex();

		//Consolidate the resulting ArrayLists and Maps for easier iteration.
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
		//If there are any results:
		if(!contexts.isEmpty()){
			//Get every word in the resulting ArrayList.
			for(WordCoordinate w : contexts){
				int stringID = w.getID();
				int kwicID = contexts.indexOf(w);
				WIC.put(kwicID, w);
				
				sb.append("ID ");
				sb.append(kwicID);
				sb.append(":\t");

				//Get the neighbouring words.
				for(int i = stringID-contextSize; i<stringID+(contextSize+1); i++){
					if(kwicIDs.get(i) != null){
						sb.append(kwicIDs.get(i));
						sb.append(" ");
					}
				}
				sb.append("\n");

			}
		}else{

			return "List is empty: no results found";

		}

		return sb.toString();

	}

	/**
	 * Returns the wider context of the desired kwicID.
	 * @param kwicID
	 * @return
	 */
	public String getWiderContext(String kwicID){

		//If the kwickID exists return the wider context.
		if(WIC.containsKey(Integer.parseInt(kwicID))){
			return WIC.get(Integer.parseInt(kwicID)).toString();

		}else{

			return "User Input Error!\nThat kwicID doesn't exist in this context.";

		}
	}

}
