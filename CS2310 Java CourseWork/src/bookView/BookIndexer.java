package bookView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

<<<<<<< HEAD
public class BookIndexer {
	/**
	 * Hashtables pairing words with WordCoordinates.
	 **/
	private Map<String, ArrayList<WordCoordinate>> emmaWordIndex;
	private Map<String, ArrayList<WordCoordinate>> pandPWordIndex;
	private Map<String, ArrayList<WordCoordinate>> mansfieldParkWordIndex;
	
	/**
	 * Hashtables pairing word ID with words.
	 **/
	private Map<Integer, String> emmaIDIndex;
	private Map<Integer, String> pandpIDIndex;
=======
/**
 * Indexes Books for faster searching.
 * @author Will
 *
 */
public class BookIndexer {
	
	/**
	 * Map pairing the words of Emma with WordCoordinates.
	 */
	private Map<String, ArrayList<WordCoordinate>> emmaWordIndex;
	
	/**
	 * Map pairing the words of Pride And Prejudice with WordCoordinates.
	 */
	private Map<String, ArrayList<WordCoordinate>> pAndPWordIndex;
	
	/**
	 * Map pairing the words of Mansfield Park with WordCoordinates.
	 */
	private Map<String, ArrayList<WordCoordinate>> mansfieldParkWordIndex;
	
	/**
	 * Maps pairing word ID with the words from Emma.
	 */
	private Map<Integer, String> emmaIDIndex;
	
	/**
	 * Maps pairing word ID with the words from Pride And Prejudice.
	 */
	private Map<Integer, String> pAndPIDIndex;
	
	/**
	 * Maps pairing word ID with the words from Mansfield Park.
	 */
>>>>>>> master
	private Map<Integer, String> mansfieldParkIDIndex;
	
	/**
	 * The current line the BufferReader of index();
<<<<<<< HEAD
	 * <see>BookIndexer.index()</see> 
	 **/
	private String line = "";
	
	/**
	 * Files holding the books so that relative path can be used. 
	 **/
	private File emma = new File("data\\emmaEd11.txt");
	private File pandp = new File("data\\pandpEd12.txt");
	private File mansfieldPark = new File("data\\mansfieldParkEd10.txt");
	
	/**
	 *Constructor initialises the word indexes and id indexes to be the indexed files.
	 **/
	public BookIndexer(){
		try{
			Map[] emmaHashtables = index(emma);
			Map[] pandpHashtables = index(pandp);
			Map[] mansfieldParkHashtables = index(mansfieldPark);
		
		emmaWordIndex = emmaHashtables[0];
		pandPWordIndex = pandpHashtables[0];
		mansfieldParkWordIndex = mansfieldParkHashtables[0];
		
		emmaIDIndex = emmaHashtables[1];
		pandpIDIndex = pandpHashtables[1];
		mansfieldParkIDIndex = mansfieldParkHashtables[1];
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
=======
	 * @see {@link bookView.BookIndexer.index(File)}
	 */
	private String line = "";
	
	private int wordCount = 0;
	
	/**
	 * Files holding the books so that relative path can be used.
	 */
	private File emma = new File("data/emmaEd11.txt");
	private File pandp = new File("data/pandpEd12.txt");
	private File mansfieldPark = new File("data/mansfieldParkEd10.txt");
	
	/**
	 * Constructor initialises the word indexes and id indexes to be the indexed files.
	 */
	public BookIndexer(){
		emmaWordIndex = index(emma);
		pAndPWordIndex = index(pandp);
		mansfieldParkWordIndex = index(mansfieldPark);
		wordCount = 0;
		emmaIDIndex = indexID(emma);
		pAndPIDIndex = indexID(pandp);
		mansfieldParkIDIndex = indexID(mansfieldPark);
>>>>>>> master
	}
	
	/**
	 * @return emmaWordIndex
<<<<<<< HEAD
	 **/
=======
	 */
>>>>>>> master
	public Map<String, ArrayList<WordCoordinate>> getEmmaIndex(){
		return emmaWordIndex;
	}
	
<<<<<<< HEAD
	public Map<String, ArrayList<WordCoordinate>> getPandPIndex(){
		return pandPWordIndex;
	}
	
=======
	/**
	 * @return pandPWordIndex
	 */
	public Map<String, ArrayList<WordCoordinate>> getPandPIndex(){
		return pAndPWordIndex;
	}
	
	/**
	 * @return mansfieldParkWordIndex
	 */
>>>>>>> master
	public Map<String, ArrayList<WordCoordinate>> getMansfieldParkIndex(){
		return mansfieldParkWordIndex;
	}
	
<<<<<<< HEAD
=======
	/**
	 * @return emmaIDIndex
	 */
>>>>>>> master
	public Map<Integer, String> getEmmaIDIndex(){
		return emmaIDIndex;
	}
	
<<<<<<< HEAD
	public Map<Integer, String> getPandPIDIndex(){
		return pandpIDIndex;
	}
	
	public Map<Integer, String> getMansfiledParkIDIndex(){
		return mansfieldParkIDIndex;
	}

	public Map[] index(File file){
		
		Map[] hashtables = new HashMap[2];
		Map<String, ArrayList<WordCoordinate>> wordIndex = new HashMap<>();
		Map<Integer, String> IDIndex = new HashMap<>();
		hashtables[0] = wordIndex;
		hashtables[1] = IDIndex;
		
=======
	/**
	 * @return pandpIDIndex
	 */
	public Map<Integer, String> getPandPIDIndex(){
		return pAndPIDIndex;
	}
	
	/**
	 * @return mansfieldParkIDIndex
	 */
	public Map<Integer, String> getMansfiledParkIDIndex(){
		return mansfieldParkIDIndex;
	}
	
	/**
	 * Indexes files to two Maps. First words to WordCoordinates then wordIDs to words.
	 * <p>
	 * Returns and array of Maps untyped because the method returns two HashMaps of different types.
	 * </p>
	 * @param file - The file to index
	 * @return An array of Map objects containing two HashMaps
	 */
	public Map<String, ArrayList<WordCoordinate>> index(File file){

		Map<String, ArrayList<WordCoordinate>> wordIndex = new HashMap<>();

>>>>>>> master
		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			int lineNumber = 0;
			int chapterNumber = 0;
			int paragraphNumber = 1;
			int volumeNumber = 0;
<<<<<<< HEAD
			int wordID = 0;
			while((line = br.readLine()) != null){
				
				int wordNumber = 0;

				String[] currentLineWords = line.split(" ");
				
=======
			int wordID = wordCount;
			while((line = br.readLine()) != null){

				int wordNumber = 0;

				String[] currentLineWords = line.split(" ");

>>>>>>> master
				while (wordNumber < currentLineWords.length){

					if (currentLineWords[wordNumber].equals("")){
						paragraphNumber++;
					}else{
						if(!wordIndex.containsKey(currentLineWords[wordNumber])){
							wordIndex.put(currentLineWords[wordNumber], new ArrayList<WordCoordinate> ());
						}


						if (currentLineWords[wordNumber].equals("CHAPTER")){
							chapterNumber++;
							paragraphNumber = 1;
						}
						if (currentLineWords[wordNumber].equals("VOLUME")){
							volumeNumber++;
						}

						wordIndex.get(currentLineWords[wordNumber]).add(
								new WordCoordinate(wordID, wordNumber, lineNumber, paragraphNumber, chapterNumber, volumeNumber, file));
<<<<<<< HEAD
						IDIndex.put(wordID, currentLineWords[wordNumber]);
						wordID++;
					}
					wordNumber++;
					
				}
				lineNumber++;
			}

=======
						wordID++;
						wordCount++;
					}
					wordNumber++;

				}
				lineNumber++;
			}
>>>>>>> master
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		return hashtables;
	}
	
	public class WordCoordinate{
		int ID;
		int lineNumber;
		int wordNumber;
		int paragraphNumber;
		int chapter;
		int volume;
		File title;
		
=======
		return wordIndex;
	}
	
	private Map<Integer, String> indexID(File file){
		Map<Integer, String> IDIndex = new HashMap<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			int lineNumber = 0;
			int paragraphNumber = 1;
			while((line = br.readLine()) != null){

				int wordNumber = 0;

				String[] currentLineWords = line.split(" ");

				while (wordNumber < currentLineWords.length){

					if (currentLineWords[wordNumber].equals("")){
						paragraphNumber++;
					}else{
						IDIndex.put(wordCount, currentLineWords[wordNumber]);
						wordCount++;
					}
					wordNumber++;

				}
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return IDIndex;
	}
/*******************************************************************************************************************************************
 * Inner Class -- WordCoordinate
 * <p>
 * This class holds all of the required information to find the wider context of a word.
 * </p>
 * @author Will
 *
 *******************************************************************************************************************************************/
	public class WordCoordinate{
		private int ID;
		private int lineNumber;
		private int wordNumber;
		private int paragraphNumber;
		private int chapter;
		private int volume;
		private File title;
		
		/**
		 * Constructs a new WordCoordinate 
		 * @param ID - the position of the word in the text it originates from
		 * @param wNum - the position of the word in the line its on
		 * @param lNum - the line the word is on
		 * @param pNum - the paragraph the word is in
		 * @param chapter - the chapter the word is in
		 * @param volume - the volume the word is in
		 * @param title - the File the word is from -- used to get the name of the file for toString()
		 */
>>>>>>> master
		public WordCoordinate(int ID, int wNum, int lNum, int pNum, int chapter, int volume, File title){
			this.ID = ID;
			wordNumber = wNum;
			lineNumber = lNum;
			paragraphNumber = pNum;
			this.chapter = chapter;
			this.volume = volume;
			this.title = title;
		}
		
		public int getID(){
			return ID;
		}
		
		public int getWordNumber(){
			return wordNumber;
		}
		
		public int getLineNumber(){
			return lineNumber;
		}
		
		public int getParagraphNumber(){
			return paragraphNumber;
		}
		
		public int getChapter(){
			return chapter;
		}
		
		public int getVolume(){
			return volume;
		}
		
		public String getTitle(){
			return title.getName();
		}
		
<<<<<<< HEAD
=======
		/**
		 * Returns a string formatted thusly:
		 * <ul>
		 * 	<li>Title: {@value title}</li>
		 * 	<li>Volume: {@value volume}</li>
		 * 	<li>Chapter: {@value chapter}</li>
		 * 	<li>Paragraph: {@value paragraphNumber}</li>
		 * 	<li>Line: {@value lineNumber} at: {@value wordNumber}</li>
		 * 	<li>Word ID: {@value ID}</li>
		 * </ul>
		 * @return - the String representation of this WordCoordinate
		 */
>>>>>>> master
		public String toString(){
			StringBuffer sb = new StringBuffer();
			
			sb.append("Title: ");
			sb.append(getTitle());
			if(volume > 0){
			sb.append("\nVolume: ");
			sb.append(getVolume());
			}
			sb.append("\nChapter: ");
			sb.append(getChapter());
			sb.append("\nParagraph: ");
			sb.append(getParagraphNumber());
			sb.append("\nLine: ");
			sb.append(getLineNumber());
			sb.append(" at: ");
			sb.append(getWordNumber());
			sb.append("\nWord ID: ");
			sb.append(getID());
			sb.append("\n");
			
			return sb.toString();
		}
	}
<<<<<<< HEAD
=======
/*******************************************************************************************************************************************
* End of Inner Class -- WordCoordinte
********************************************************************************************************************************************/
>>>>>>> master
}
