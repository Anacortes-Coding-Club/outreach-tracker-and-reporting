import java.util.*;
/**
 * This class holds info about each person.
 * to avoid making duplicate people, YOU CAN NEVER CREATE A NEW PERSON DIRECTLY.
 * instead, call find, and if the person you are trying to find does not exist, find will create a new one for you.
 * holds name, tags and notes.
 * @extends Taggable
 * @author Kai G
 */
public class Person extends Taggable{
    public String name = null;
    private Person(String[] a){
        name = a[0];
        rawNotes += (name + "\n\n" + ParseMD.currentDate + "\n");
        for(int i=1; i < a.length; i++){
            rawNotes += (a[i]+"\n");
        }
        tagify();
    }
    public static Person find(String[] a){
        Person x = null;
        for(int i = 0; i < ParseMD.info.people.size(); i++){
            if(a[0].contains(ParseMD.info.people.get(i).name) || ParseMD.info.people.get(i).name.contains(a[0])){
                x = ParseMD.info.people.get(i);
                x.rawNotes += ("\n" + ParseMD.currentDate + "\n");
                for(int j=1; j < a.length; j++){
                    x.rawNotes += (a[j]+"\n");
                }
                x.tagify();
                break;
            }
        }
        if(x == null){
            x = new Person(a);
            ParseMD.info.people.add(x);
        }
        return x;
    }
}