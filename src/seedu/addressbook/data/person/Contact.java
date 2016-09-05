package seedu.addressbook.data.person;

public class Contact {
	public final String value;
    private boolean isPrivate;
    
    public Contact(String value, boolean isPrivate){
    	this.isPrivate = isPrivate;
    	this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (this.getClass() == other.getClass() && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
}
