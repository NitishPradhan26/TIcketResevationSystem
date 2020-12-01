
package Theatre_elements;
/**
 * A simple class representing a movie theatre
 * @author Luka Petrovic
 * @since 11/27/20
 */
public class Theatre {
	/**
	 * The name of the theatre
	 */
    private String name;
    /**
     * The address of the theatre
     */
    private String address;

    /**
     * Default constructor. Initializes attributes to null.
     */
    public Theatre(){
        name = null;
        address = null;
    }

    /**
     * The recommended constructor, taking a name and address
     * @param name the theatre name
     * @param address the theatre address
     */
    public Theatre(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}