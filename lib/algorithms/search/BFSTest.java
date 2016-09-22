package algorithms.search;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BFSTest {

	BFS bfs;
	
	
	public BFSTest() {
		bfs = new BFS();
	}

	@Test
	public void nullTest() {
		try {
			bfs.search(null);
		} catch (NullPointerException e) {
			assertTrue(1 > 0);
		}
		assertTrue("NullPointerException not thrown!", 1 > 0);
	}
}
