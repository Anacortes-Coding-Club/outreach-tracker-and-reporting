import java.util.*;

public class Visit{
    
    private Calendar visitDate = Calendar.getInstance();
    public static ArrayList<Person> visitPeople = new ArrayList<Person>();
    public static int visits = 0;
    public Visit(String input){

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
        
        String[] x = lines[0].split(" ");//split up the words in the first line to use for date and year setting
        //set the date
        String a = x[1].replace(",","");
        int b = Integer.parseInt(a);
        visitDate.set(visitDate.DATE, b);
        
        
        //set the year
        String c = x[2].replace(",","");
        int d = Integer.parseInt(c);
        visitDate.set(visitDate.YEAR, d);
        
        Person p = null;
        String[] personNotes = input.split("###");
        
        for(int i = 0; i < personNotes.length; i++){
            Person.find(personNotes[i].split("\n"));
        }

    }
}