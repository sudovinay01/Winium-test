package Winium.WiniumTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	/**
	 * sayhello method test
	 */
	@Test
	public void sayhelloTest() {
		assertEquals(App.sayHello(), "Hello");
	}

	/**
	 * sayhello method negative scenario test
	 */
	@Test
	public void sayhelloNegativeTest() {
		assertNotEquals(App.sayHello(), "hello");
	}
}
