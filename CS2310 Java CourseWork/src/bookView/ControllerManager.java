package bookView;

public class ControllerManager implements Controller {
	
	private Search search;
<<<<<<< HEAD
	
	public ControllerManager(){
=======
	private BookIndexer bookIndexer;
	
	public ControllerManager(){
		bookIndexer = new BookIndexer();
>>>>>>> master
		search = new Search();
	}
	
	@Override
	public String getKWIC(String word) {
		
		return search.search(word);
	}

	@Override
	public String getKWIC(String word, int contextSize) {
		
		return search.search(word, contextSize);
	}

	@Override
	public String getWiderContext(String kwicID) {
		
		return search.getWiderContext(kwicID);
	}

}
