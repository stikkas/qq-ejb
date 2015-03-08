/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public class SimpleTest {
	
	public SimpleTest() {
	}

    // TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}

	@org.testng.annotations.BeforeClass
	public static void setUpClass() throws Exception {
	}

	@org.testng.annotations.AfterClass
	public static void tearDownClass() throws Exception {
	}

	@org.testng.annotations.BeforeMethod
	public void setUpMethod() throws Exception {
	}

	@org.testng.annotations.AfterMethod
	public void tearDownMethod() throws Exception {
	}

	@Test
	public void hello() {
		System.out.println("Hello");
	}

	@Test
	public void testEquals() {
		String s1 = "a";
		String s2 = "a";
		assertTrue(s1.equals(s2), "The strings should be equal by value");
		assertTrue(s1.hashCode() == s2.hashCode(), "Hash codes of equal objects not equal");
	}
}
