package bookView;

public class ControllerManager implements Controller {
	
	private Search search;
	private BookIndexer bookIndexer;
	
	public ControllerManager(){
		bookIndexer = new BookIndexer();
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
