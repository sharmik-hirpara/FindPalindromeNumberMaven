package org.apache.maven.findpalindrome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;


	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void nextPalindromeTest1() {
		App.checkLength(121);		
		assertEquals("131", String.valueOf(outContent.toString()));
	}
	
	@Test
	public void nextPalindromeTest2() {
		App.checkLength(9999);		
		assertEquals("10001", String.valueOf(outContent.toString()));
	}
	
	@Test
	public void nextPalindromeTest3() {
		App.checkLength(-1);		
		assertEquals("131", String.valueOf(outContent.toString()));

	}
	
}
