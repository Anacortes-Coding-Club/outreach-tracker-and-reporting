import java.util.ArrayList;
public class Date
{
    private ArrayList<Visit> visitStorage = new ArrayList<Visit>();
    private int day = -1;
    private int month = -1;
    private int year = -1;

    public String getDate()
    {
        return (numToMonth(month) + " " + day + ", " + year);
    }
    public void setDate(int month, int day, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDate(String month, int day, int year)
    {
        this.day = day;
        this.month = monthToNum(month);
        this.year = year;
    }
    public void printDate()
    {
        String temp;
        temp = numToMonth(month);
        System.out.println(temp + " " + day + ", " + year);
    }
    private String numToMonth (int input)
    {
        String temp;
        switch (input)
        {
            case 1:
                temp = "January";
                break;
            case 2:
                temp = "February";
                break;
            case 3:
                temp = "March";
                break;
            case 4:
                temp = "April";
                break;
            case 5:
                temp = "May";
                break;
            case 6:
                temp = "June";
                break;
            case 7:
                temp = "July";
                break;
            case 8:
                temp = "August";
                break;
            case 9:
                temp = "September";
                break;
            case 10:
                temp = "October";
                break;
            case 11:
                temp = "November";
                break;
            case 12:
                temp = "December";
                break;
            default:
                temp = "Error";
                break;
        }
        return temp;
    }
    private int monthToNum(String input)
    {
        String tempInput = input.toLowerCase();
        int tempOutput;
        switch (input)
        {
            case "january":
                tempOutput = 1;
                break;
            case "february":
                tempOutput = 2;
                break;
            case "march":
                tempOutput = 3;
                break;
            case "april":
                tempOutput = 4;
                break;
            case "may":
                tempOutput = 5;
                break;
            case "june":
                tempOutput = 6;
                break;
            case "july":
                tempOutput = 7;
                break;
            case "august":
                tempOutput = 8;
                break;
            case "september":
                tempOutput = 9;
                break;
            case "october":
                tempOutput = 10;
                break;
            case "november":
                tempOutput = 11;
                break;
            case "december":
                tempOutput = 12;
                break;
            default:
                tempOutput = -1;
                break;
        }
        return tempOutput;
    }

    public ArrayList<Visit> getVisits ()
    {
        return visitStorage;
    }
    public void addVisit(Visit input)
    {
        visitStorage.add(input);
    }
    public void printVisits()
    {
        for (Visit visit: visitStorage)
        {
            visit.printPersons();
        }
    }
}