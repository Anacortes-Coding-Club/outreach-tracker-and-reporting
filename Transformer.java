import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Transformer {

    static void outreachDays(ArrayList<Visit> visits) {
        LocalDate earliest = null;
        LocalDate latest = null;
        // int dateCount = 0;
        Set<LocalDate> dates = new HashSet<LocalDate>();
        for (Visit v : visits) {
            LocalDate tripDate = v.getTripDate();
            dates.add(tripDate);
            if (earliest == null || tripDate.isBefore(earliest)) {
                earliest = tripDate;
            }
            if (latest == null || tripDate.isAfter(latest)) {
                latest = tripDate;
            }
        }

        System.out.print("" + dates.size() + " outreach service days ");
        System.out.println("between " + earliest + " and " + latest);

    }

    static Map<String, ArrayList<Visit>> clients(ArrayList<Visit> visits) {
        Map<String, ArrayList<Visit>> clientMap = new HashMap<String, ArrayList<Visit>>();

        for (Visit v : visits) {
            String[] clients = v.getPeople();
            for (String client : clients) {
                if (!clientMap.containsKey(client)) {
                    clientMap.put(client, new ArrayList<Visit>());
                }
                ArrayList<Visit> clientVisits = (ArrayList<Visit>) clientMap.get(client);
                clientVisits.add(v);
            }
        }
        System.out.println(clientMap.size() + " distinct clients served");
        return clientMap;
    }

    // tags should be case insensitive
    static void countTags(ArrayList<Visit> visits, String tag) {
        int tagCount = 0;
        for (Visit v : visits) {
            String[] tags = v.getHashtags();
            for (String t : tags) {
                if (t.equalsIgnoreCase(tag)) {
                    tagCount++;
                }
            }
        }

        System.out.println(tagCount + " instances of " + tag);
    }

    static boolean anyVisitHasTag(ArrayList<Visit> visits, String tag) {
        for (Visit v : visits) {
            String[] tags = v.getHashtags();
            for (String t : tags) {
                if (t.equalsIgnoreCase(tag)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void clientsWithTag(ArrayList<Visit> visits, String tag) {
        int countClients = 0;
        Map<String, ArrayList<Visit>> clientMap = clients(visits);
        for (String client : clientMap.keySet()) {
            ArrayList<Visit> clientVisits = clientMap.get(client);
            if (anyVisitHasTag(clientVisits, tag)) {
                countClients++;
            }
        }
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
        clientsWithTag(visits, "#HolidayMotel");
    }
}
