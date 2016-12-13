package bookView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import bookView.BookIndexer.WordCoordinate;

public class Main {

	public static void main(String[] args){
		TUI userInterface = new TUI(new ControllerManager());
	}
}
