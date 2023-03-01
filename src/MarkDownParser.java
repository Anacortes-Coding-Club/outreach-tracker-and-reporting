import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MarkDownParser {
    private static ArrayList<Date> dateStorage = new ArrayList<>();
    private static ArrayList<String> textStorage = new ArrayList<>();

    public static void main(String[] args)
    {
        Person testA = new Person();
        testA.setFirstName("A");
        testA.setLastName("B");
        //testA.printFirstName();
        //testA.printLastName();

        //line();

        Note jefferey = new Note();
        jefferey.setNote("I enjoy eating christmas ornaments.");
        //jefferey.printNote();

        Tag ronaldo = new Tag();
        ronaldo.setTag("tave");
        //ronaldo.printTag();

        //line();

        testA.addNote(jefferey);
        testA.addTag(ronaldo);
        //testA.printNotes();
        //testA.printTags();

        //line();

        Visit crungle = new Visit();
        crungle.addPerson(testA);

        Date flimbus = new Date();
        flimbus.setDate("march", 1, 2022);
        flimbus.addVisit(crungle);

        //flimbus.printDate();
        //flimbus.printVisits();
        dateStorage.add(flimbus);

        //parse();
        print();
    }
    private static void parse ()
    {
        try
        {
            File myObj = new File("input/sample.md");
            Scanner scnr = new Scanner(myObj);
            while (scnr.hasNextLine())
            {
                String temp = scnr.nextLine();
                textStorage.add(temp);
            }
            scnr.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Mm bad");
            e.printStackTrace();
        }

        /*
        for loop through the whole text arraylist
        scan and populate the date arraylist
         */

    }
    private static void print()
    {
        for(Date date : dateStorage)
        {
            date.printDate();
            date.printVisits();
            line();
        }
    }
    private static void line()
    {
        System.out.println();
    }

}

/*
Dates:
 - Visits
  - People
   - Notes
   - Tags

Scan for single pound signs
 - with a space and a date, is the date
 - with no space and a tag, is a tag
Scan for triple pound signs
 - person within a date
Single asterisk, dash, underscore
 - means after notes / tags
Six dashes means end of date

 use a switch \/

 turn it into a temporarily stored string arraylist, line by line.
 scan through line by line adding things as necessary.
 if(new date)
    close previous
    add new to list
 if(new person)
    close previous
    add new to list
 if(new note)
    close previous
    add new to list
 if(new tag)
    close previous
    add new to list
 if(empty)
    do nothing
 if(end of file)
    done

 cycle through whole arraylist and print everything in order, indented.
 */