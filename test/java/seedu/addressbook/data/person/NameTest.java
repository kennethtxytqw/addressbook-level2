package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;

public class NameTest {
	private Name JohnKSmith;
	private Name SmithJohn;
	private Name MaryAnn;
	
	@Before
	public void setUp() throws IllegalValueException{
		JohnKSmith = new Name("John K Smith");
		
		SmithJohn = new Name("Smith John"); 
		
		MaryAnn = new Name("Mary Ann");
	}
	
	@Test
	public void isSimilar_similarNames_trueReturned(){
		boolean actual = JohnKSmith.isSimilar(SmithJohn);
		boolean expected = true;
		assertEquals(expected, actual);
	}
}
