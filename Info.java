import java.io.Serializable;
import java.util.*;
/**
 * This class holds all the information.
 * it holds tags and notes for the entire file, all visits, and all people.
 * @extends Taggable
 * @author Kai G 
 */

public class Info extends Taggable{
    public ArrayList<Visit> visits = new ArrayList<Visit>();
    public ArrayList<Person> people = new ArrayList<Person>();
}
