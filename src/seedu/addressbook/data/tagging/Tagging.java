package seedu.addressbook.data.tagging;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

public class Tagging {
	final static String PREFIX_ADDED = "+ ";
	final static String PREFIX_DELETED = "- ";
	final static String PADDING = " ";
	final Boolean isAdd;
	final Person person;
	final Tag tag;
	
	
	public static ArrayList<Tagging> processTaggings(Person person, UniqueTagList tags){
		ArrayList<Tagging> taggings = new ArrayList<>();
		for(Tag tagToBeRemoved :  person.getTags()){
			if(!tags.contains(tagToBeRemoved)){
				Tagging tagging = new Tagging(false, person, tagToBeRemoved);
				taggings.add(tagging);
			}
		}
		for(Tag tag: tags){
			if(!person.getTags().contains(tag)){
				Tagging tagging = new Tagging(true, person, tag);
				taggings.add(tagging);
			}
		}
		return taggings;
	}
	
	public Tagging(){
		this.isAdd = null;
		this.person = null;
		this.tag = null;
	}
	public Tagging(Boolean isAdd, Person person, Tag tag){
		this.isAdd = isAdd;
		this.person = person;
		this.tag = tag;
	}
	
	public String toString(){
		if(isAdd){
			return PREFIX_ADDED + PADDING + person.getName().fullName + PADDING + tag.toString();
		}else{
			return PREFIX_DELETED + PADDING + person.getName().fullName + PADDING + tag.toString();
		}
	}

	public static ArrayList<Tagging> processInitialTagging(Person toAdd, UniqueTagList tags) {
		ArrayList<Tagging> taggings = new ArrayList<>();
		for(Tag tag: tags){
			Tagging tagging = new Tagging(true, toAdd, tag);
			taggings.add(tagging);
		}
		return taggings;
	}

}
