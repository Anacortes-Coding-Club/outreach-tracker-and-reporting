import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MarkDownParser {
    private static ArrayList<Date> dateStorage = new ArrayList<Date>();
    private static ArrayList<String> textStorage = new ArrayList<String>();

    public static void main(String[] args)
    {
        parse();
        //print();
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
        for(int i = 0; i < dateStorage.size(); i++)
        {
            dateStorage.get(i);
            System.out.println("Boop");
        }
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