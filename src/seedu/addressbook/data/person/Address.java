package seedu.addressbook.data.person;

import java.util.regex.Pattern;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "e.g. a/123, Clementi Ave 3, #12-34, 231534";
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address should be entered in the following format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    private static final String ADDRESS_VALIDATION_REGEX = "(\\d+)(\\s*)([,])(.+)(,)(\\s*)(#.+),(\\s*)(\\d+)";
//    private static final String ADDRESS_VALIDATION_REGEX = "a/(\\d+)(\\s*),(.+),#(.+),(\\d+)";
    
    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] splittedAddress = address.split(",");
        this.block = new Block(splittedAddress[0]);
        this.street = new Street(splittedAddress[1]);
        this.unit = new Unit(splittedAddress[2]);
        this.postalCode = new PostalCode(splittedAddress[3]);
        this.value = ""+this.block+", "+this.street   +", "+this.unit+", "+this.postalCode ;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
//    	System.out.println("Hello2" +test.matches(ADDRESS_VALIDATION_REGEX));
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return (this.toString()).hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    private class Block{
    	private final String value;
    	
    	private Block(String block) {
			this.value = block.trim();
		}
    	
    	@Override
        public String toString() {
            return value;
        }
    }
    
    private class Street{
    	private final String value;
    	
    	public Street(String street) {
			this.value = street.trim();
		}
    	
    	@Override
        public String toString() {
            return value;
        }
    }
    
    private class Unit{
    	private final String value;
    	
    	public Unit(String unit){
    		this.value = unit.trim();
    	}
    	
    	@Override
        public String toString() {
            return value;
        }
    }
    
    private class PostalCode{
    	private final String value;
    	
    	public PostalCode(String postalCode){
    		this.value = postalCode.trim();
    	}
    	
    	@Override
        public String toString() {
            return value;
        }
    }
    
}