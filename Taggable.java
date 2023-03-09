import java.util.*;
/**
 * This class is to be extended by any class that has notes and tags.
 * it will store the notes and tags,
 * count tags,
 * and replace tags with translations
 * the only method you should call is tagify()
 * @author Kai G
 */
public abstract class Taggable{
    public String notes;
    public String rawNotes;
    /*the arrays below hold each hashtag, 
    the translation for each, 
    and the number of each found in the notes.
    below are the correspondencies for each.
    0- #CC
    met with client
    
    1- #TAVE
    on T Avenue
    
    2- #CAR
    living in car
    
    3- #RNPREF
    referral to RNP
    
    4- #GAScard
    provided a gas card
    
    5- #MATref
    referral for Medication Assisted Therapies (MAT) at Didgwalic
    
    6- #GIFTcard
    provided a gift card
    
    7- #RV
    living in RV
    
    8- #TENT
    living in Tent
    
    9- #BP
    provided a bus pass
    
    10- #CWS
    living in cold weather shelter
    
    11- #HousingApp
    completed a housing application
    
    12- #resume
    completed a resume
    
    13- #jobapp
    completed a job application
    
    14- #SUDref
    referred to Jennifer for SUD
    
    15- #MHref
    referred to Jennifer for Mental Health
    
    16- #HMIS
    entered in HMIS
    
    17- #FROM/BHAM
    from / bellingham
    
    18- #VetRef
    referred for a veteran voucher
    
    19- #MATinfo
    provided information about MAT
    
    20- #TicketCitation
    person received a citation ticket
    
    21- #HolidayMotel
    living in holiday motel
    
    22- #IOPref
    referred for intensive outpatient
    
    23- #Street
    Living on the street
    
    24- #COPEapp
    COPE application
    */    
    public final String[] tokens = {"#CC", "#TAVE", "#CAR", "#RNPREF", "#GAScard", "#MATref", "#GIFTcard", "#RV", "#TENT", "#BP", "#CWS", "#HousingApp", "#resume", "#jobapp", "#SUDref", "#MHref", "#HMIS", "#FROM/BHAM", "#VetRef", "#MATinfo", "#TicketCitation", "#HolidayMotel", "#IOPref", "#Street", "#COPEapp"};
    public final String[] translations = {"~met with client", "~on T Avenue", "~living in car", "~referral to RNP", "~provided a gas card", "~referral for Medication Assisted Therapies (MAT) at Didgwalic", "~provided a gift card", "~living in RV", "~living in Tent", "~provided a bus pass", "~living in cold weather shelter", "~completed a housing application", "~completed a resume", "~completed a job application", "~referred to Jennifer for SUD", "~referred to Jennifer for Mental Health", "~entered in HMIS", "~from / bellingham", "~referred for a veteran voucher", "~provided information about MAT", "~person received a citation ticket", "~living in holiday motel", "~referred for intensive outpatient", "~Living on the street", "~COPE application"};
    public int[] tags = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    /**
     * this method takes the notes of the taggable object, 
     * adds the number of each tag found to tags[],
     * and replaces every tag with the correct translation.
     */
    public void tagify(){
        //count
        for (int i = 0; i < tokens.length; i++){
            tags[i] += count(rawNotes, tokens[i]);
        }
        
        //replace
        notes = rawNotes;
        for(int i = 0; i < tokens.length; i++){
            notes = notes.replace(tokens[i], translations[i]);
        }
    }
    
    private static int count(String token, String input){
        String[] x = input.split(token);
        return (x.length -1);
    }
}