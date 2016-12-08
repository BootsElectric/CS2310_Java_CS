package bookView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

public class BookIndexer {
	private Hashtable<String, String> emmaWordIndex;
	
	public BookIndexer(){
		emmaWordIndex = new Hashtable<>();
	}
	
	public Hashtable<String, String> getEmmaIndex(){
		return emmaWordIndex;
	}
	
	public void indexEmma(){
		String path = "C:\\Users\\Will\\Documents\\GitHub\\CS2310 Java CourseWork\\data\\emmaEd11.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			ArrayList<String> lines = new ArrayList<>();
			
			while((br.readLine()) != null){
				lines.add(br.readLine());
			}
			
			ArrayList<String> words = new ArrayList<>();
			int lineNumber = 0;
			int wordNumber = 0;
			
			while (lineNumber < lines.size()){
				
				String[] currentLineWords = lines.get(lineNumber).split(" ");
				while (wordNumber < currentLineWords.length){
//					words.add(currentLineWords[wordNumber]);
					emmaWordIndex.put( lineNumber + "," + wordNumber, currentLineWords[wordNumber]);
					wordNumber++;
				}
				lineNumber++;
			}
			
			/*for(String word : words){
				emmaWordIndex.put(word, wordPosition[lineNumber][wordNumber]);
			}*/
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
