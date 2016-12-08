package bookView;

import java.util.Date;
import java.util.Hashtable;

public class Main {
	
	public static void main(String[] args){
		Search s = new Search();
		long startTime = (new Date()).getTime();
		s.search("the");
		long endTime = (new Date()).getTime();
		System.out.println(endTime - startTime);
		
		BookIndexer bi = new BookIndexer();
		bi.indexEmma();
		Hashtable<String, String> ht = bi.getEmmaIndex();
		int i = 0;
//		while (i < ht.size()){
			if(ht.containsKey("the")){
				System.out.println(ht.get(key));
//			}
		}
	}
}
