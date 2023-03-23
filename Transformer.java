import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Transformer {

    static void outreachDays(ArrayList<Visit> visits) {
        LocalDate earliest = null;
        LocalDate latest = null;
        int dateCount = 0;
        // HashSet dates = new HashSet<LocalDate>();

        System.out.print("" + dateCount + " outreach service days ");
        System.out.println("between " + earliest + " and " + latest);
    }

    static void clients(ArrayList<Visit> visits) {
        int clients = 0;
        // HashMap clientMap = new HashMap<String,ArrayList<Visit>>();

        System.out.println(clients + " distinct clients served");
    }

    // tags should be case insensitive
    static void countTags(ArrayList<Visit> visits, String tag) {
        int tagCount = 0;
        // HashSet dates = new HashSet<LocalDate>();

        System.out.println(tagCount + " instances of " + tag);
    }

    static void clientsWithTag(ArrayList<Visit> visits, String tag) {
        int countClients = 0;

        // maybe change clients to return the HashMap?
        System.out.println(countClients + " living in " + tag);
    }

    public static void main(String[] args) {
        String filename = "visits.json";
        String json = Util.readFileAsString(filename);
        ArrayList<Visit> visits = Util.jsonToVisits(json);
        System.out.println("Read visits: " + visits.size());

        outreachDays(visits);
        clients(visits);
        countTags(visits, "#jobapp");
        clientsWithTag(visits, "#car");
    }
}
