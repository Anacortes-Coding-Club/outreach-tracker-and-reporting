import java.util.*;

public class Person{
    public String name = null;
    public String notes = "";
    //String 
    public Person(String[] a){
        name = a[0];
        notes += (name + "\n" + ParseMD.currentDate + "\n");
        for(int i=1; i < a.length; i++){
            notes += (a[i]+"\n");
        }
    }
    public static Person find(String[] a){
        Person x = null;
        for(int i = 0; i < ParseMD.info.people.size(); i++){
            if(ParseMD.info.people.get(i).name.contains(a[0])){
                x = ParseMD.info.people.get(i);
                x.notes += (ParseMD.currentDate + "\n");
                for(int j=1; j < a.length; j++){
                    x.notes += (a[j]+"\n");
                }
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