package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
	
	private Object[] nullTestCase;
	private Object[] noNullTestCase;
	private ArrayList<Object> withDuplicateTestCase;
	private ArrayList<Object> withoutDuplicateTestCase;
	
	@Before
	public void setUp(){
		nullTestCase = new Object[]{"a","b","c",null,"a"};
		noNullTestCase = new Object[]{new String[]{}, new ArrayList<String>()};
		withDuplicateTestCase = new ArrayList<Object>();
		withoutDuplicateTestCase = new ArrayList<Object>();
		for(Object e : nullTestCase){
			withDuplicateTestCase.add(e);
		}
		for(Object f : noNullTestCase){
			withoutDuplicateTestCase.add(f);
		}
		
	}
	
	@Test
	public void isAnyNull_nullTestCase_trueReturned(){
		Boolean actual = Utils.isAnyNull(nullTestCase);
		Boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void isAnyNull_noNullTestCase_falseReturned(){
		Boolean actual = Utils.isAnyNull(noNullTestCase);
		Boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void elementsAreUnique_withoutDuplicateTestCase_trueReturned(){
		Boolean actual = Utils.elementsAreUnique(withoutDuplicateTestCase);
		Boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void elementsAreUnique_withDuplicateTestCase_falseReturned(){
		Boolean actual = Utils.elementsAreUnique(withDuplicateTestCase);
		Boolean expected = false;
		assertEquals(expected, actual);
	}

}
