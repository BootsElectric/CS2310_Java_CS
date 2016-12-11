package bookView;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;

public class BookIndexerTest {
	private Map<Integer, String> emma; 
	private Map<Integer, String> mansfieldPark;
	private Map<Integer, String> pandp;
	
	@Before
	public void setUp(){
		BookIndexer bi = new BookIndexer();
		emma = bi.getEmmaIDIndex();
		mansfieldPark = bi.getMansfiledParkIDIndex();
		pandp = bi.getPandPIDIndex();
		
	}
	
	@Test
	public void emmaWordCountTest(){
		assertEquals(emma.size(), 158166);
	}
	
	@Test
	public void mansfieldParkWordCountTest(){
		assertEquals(mansfieldPark.size(), 159650);
	}
	
	@Test
	public void pandpWordCountTest(){
		assertEquals(pandp.size(), 121560);
	}
}
