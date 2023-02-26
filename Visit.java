import java.util.*;

public class Visit{
    private Calendar visitDate = Calendar.getInstance();
    private ArrayList<Person> people = new ArrayList<Person>();
    public Visit(String when){
        if(when.contains("January")){visitDate.set(visitDate.MONTH, 0);}
        else if(when.contains("February")){visitDate.set(visitDate.MONTH, 1);}
        else if(when.contains("March")){visitDate.set(visitDate.MONTH, 2);}
        else if(when.contains("April")){visitDate.set(visitDate.MONTH, 3);}
        else if(when.contains("May")){visitDate.set(visitDate.MONTH, 4);}
        else if(when.contains("June")){visitDate.set(visitDate.MONTH, 5);}
        else if(when.contains("July")){visitDate.set(visitDate.MONTH, 6);}
        else if(when.contains("August")){visitDate.set(visitDate.MONTH, 7);}
        else if(when.contains("September")){visitDate.set(visitDate.MONTH, 8);}
        else if(when.contains("October")){visitDate.set(visitDate.MONTH, 9);}
        else if(when.contains("November")){visitDate.set(visitDate.MONTH, 10);}
        else if(when.contains("December")){visitDate.set(visitDate.MONTH, 11);}
        
        String[] x = when.split(" ");
        String a = x[1].replace(",","");
        int b = Integer.parseInt(a);
        String c = x[2].replace(",","");
        int d = Integer.parseInt(c);
        System.out.println("YEAR!!!"+d);
        visitDate.set(visitDate.DATE, b);
        visitDate.set(visitDate.YEAR, d);
    }
    public void addPerson(Person p){
        people.add(p);
    }
}