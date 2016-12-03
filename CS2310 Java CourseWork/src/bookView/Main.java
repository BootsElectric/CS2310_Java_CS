package bookView;

import java.util.Date;

public class Main {
	
	public static void main(String[] args){
		Search s = new Search();
		long startTime = (new Date()).getTime();
		s.search("the");
		long endTime = (new Date()).getTime();
		System.out.println(endTime - startTime);
	}
}
