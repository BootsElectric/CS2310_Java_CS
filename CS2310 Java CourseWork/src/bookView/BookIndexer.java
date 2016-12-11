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
	private Map<Integer, String> mansfieldParkIDIndex;
	
	/**
	 * The current line the BufferReader of index();
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
	}
	
	/**
	 * @return emmaWordIndex
	 **/
	public Map<String, ArrayList<WordCoordinate>> getEmmaIndex(){
		return emmaWordIndex;
	}
	
	public Map<String, ArrayList<WordCoordinate>> getPandPIndex(){
		return pandPWordIndex;
	}
	
	public Map<String, ArrayList<WordCoordinate>> getMansfieldParkIndex(){
		return mansfieldParkWordIndex;
	}
	
	public Map<Integer, String> getEmmaIDIndex(){
		return emmaIDIndex;
	}
	
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
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			int lineNumber = 0;
			int chapterNumber = 0;
			int paragraphNumber = 1;
			int volumeNumber = 0;
			int wordID = 0;
			while((line = br.readLine()) != null){
				
				int wordNumber = 0;

				String[] currentLineWords = line.split(" ");
				
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
						IDIndex.put(wordID, currentLineWords[wordNumber]);
						wordID++;
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
}
