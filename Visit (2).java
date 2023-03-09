import java.util.*;
/**
 * This class holds information for each individual visit
 * Since you would never need to modify a visit object, literally all of the code is in the constructor.
 * Holds tags, notes, people and date(as a Calender object).
 * @extends Taggable
 * @author Kai G
 */
public class Visit extends Taggable{
    
    private Calendar visitDate = Calendar.getInstance();
    public static ArrayList<Person> visitPeople = new ArrayList<Person>();
    
    public Visit(String input){
        //taggable stuff. the visit notes will now have translations instead of tags, and the tags will be counted.
        rawNotes = input;
        tagify();
        
        //calender stuff
        String[] lines = input.split("\n");//split up input by line
        ParseMD.currentDate = lines[0];
        //set the month
        if(lines[0].contains("January")){visitDate.set(visitDate.MONTH, 0);}
        else if(lines[0].contains("February")){visitDate.set(visitDate.MONTH, 1);}
        else if(lines[0].contains("March")){visitDate.set(visitDate.MONTH, 2);}
        else if(lines[0].contains("April")){visitDate.set(visitDate.MONTH, 3);}
        else if(lines[0].contains("May")){visitDate.set(visitDate.MONTH, 4);}
        else if(lines[0].contains("June")){visitDate.set(visitDate.MONTH, 5);}
        else if(lines[0].contains("July")){visitDate.set(visitDate.MONTH, 6);}
        else if(lines[0].contains("August")){visitDate.set(visitDate.MONTH, 7);}
        else if(lines[0].contains("September")){visitDate.set(visitDate.MONTH, 8);}
        else if(lines[0].contains("October")){visitDate.set(visitDate.MONTH, 9);}
        else if(lines[0].contains("November")){visitDate.set(visitDate.MONTH, 10);}
        else if(lines[0].contains("December")){visitDate.set(visitDate.MONTH, 11);}
        
        int ofst = (lines[0].contains("#")) ? 1 : 0;//if this is the first line of a file, it will start with a #. ofst is here to account for that so that the code below can ignore it if it exists.
        
        
        String[] x = lines[0].split(" ");//split up the words in the first line to use for date and year setting
        //set the date
        String a = x[1+ofst].replace(",","");
        int b = Integer.parseInt(a);
        visitDate.set(visitDate.DATE, b);
        
        //set the year
        String c = x[2+ofst].replace(",","");
        int d = Integer.parseInt(c);
        visitDate.set(visitDate.YEAR, d);
        
        //find all the people in the visit and add them to visitPeopole
        Person p = null;
        String[] personNotes = input.split("###");
        for(int i = 0; i < personNotes.length; i++){
            visitPeople.add(Person.find(personNotes[i].split("\n")));
            System.out.println("got to person " +i);
        }

    }
}