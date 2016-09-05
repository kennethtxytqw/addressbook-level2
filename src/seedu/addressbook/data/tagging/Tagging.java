package seedu.addressbook.data.tagging;

import java.util.ArrayList;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

public class Tagging {
	final static String PREFIX_ADDED = "+ ";
	final static String PREFIX_DELETED = "- ";
	final ArrayList<String> processedTags;
	
	public Tagging(){
		processedTags = new ArrayList<>();
	}
	
	public void recordAdd(UniqueTagList tags){
		for(Tag tag: tags){
			processedTags.add(PREFIX_ADDED+tag.toString());
		}
	}
	
	public void recordDelete(UniqueTagList tags){
		for(Tag tag: tags){
			processedTags.add(PREFIX_DELETED+tag.toString());
		}
	}

	public String[] toArray() {
		return processedTags.toArray(new String[]{});
	}
}
