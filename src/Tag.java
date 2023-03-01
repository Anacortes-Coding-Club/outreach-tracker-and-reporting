public class Tag
{
    private enum TagID {
        CC,             // 1  met with client
        TAVE,           // 2 on T Avenue
        CAR,            // 3 living in car
        RNPREF,         // 4 referral to RNP
        GASCARD,        // 5 provided a gas card
        MATREF,         // 6 referral for Medication Assisted Therapies (MAT) at Didgwalic
        GIFTCARD,       // 7 provided a gift card
        RV,             // 8 living in RV
        TENT,           // 9 living in Tent
        BP,             // 10 provided a bus pass
        CWS,            // 11 living in cold weather shelter
        HOUSINGAPP,     // 12 completed a housing application
        RESUME,         // 13 completed a resume
        JOBAPP,         // 14 completed a job application
        SUDREF,         // 15 referred to Jennifer for SUD
        MHREF,          // 16 referred to Jennifer for Mental Health
        HMIS,           // 17 entered in HMIS
        FROMBHAM,       // 18 from / bellingham
        VETREF,         // 19 referred for a veteran voucher
        MATINFO,        // 20 provided information about MAT
        TICKETCITATION, // 21 person received a citation ticket
        HOLIDAYMOTEL,   // 22 living in holiday motel
        IOPREF,         // 23 referred for intensive outpatient
        STREET,         // 24 Living on the street
        COPEAPP,        // 25 COPE application
        NULL            // 26 Undefined
    }
    private TagID tag = TagID.NULL;

    public TagID getTag()
    {
        return tag;
    }
    public void setTag(String input)
    {
        String tempInput = input.toUpperCase();
        TagID tempOutput;
        switch(tempInput)
        {
            case "CC":
                tempOutput = TagID.CC;
                break;
            case "TAVE":
                tempOutput = TagID.TAVE;
                break;
            case "CAR":
                tempOutput = TagID.CAR;
                break;
            case "RNPREF":
                tempOutput = TagID.RNPREF;
                break;
            case "GASCARD":
                tempOutput = TagID.GASCARD;
                break;
            case "MATREF":
                tempOutput = TagID.MATREF;
                break;
            case "GIFTCARD":
                tempOutput = TagID.GIFTCARD;
                break;
            case "RV":
                tempOutput = TagID.RV;
                break;
            case "TENT":
                tempOutput = TagID.TENT;
                break;
            case "BP":
                tempOutput = TagID.BP;
                break;
            case "CWS":
                tempOutput = TagID.CWS;
                break;
            case "HOUSINGAPP":
                tempOutput = TagID.HOUSINGAPP;
                break;
            case "RESUME":
                tempOutput = TagID.RESUME;
                break;
            case "JOBAPP":
                tempOutput = TagID.JOBAPP;
                break;
            case "SUDREF":
                tempOutput = TagID.SUDREF;
                break;
            case "MHREF":
                tempOutput = TagID.MHREF;
                break;
            case "HMIS":
                tempOutput = TagID.HMIS;
                break;
            case "FROMBHAM":
                tempOutput = TagID.FROMBHAM;
                break;
            case "VETREF":
                tempOutput = TagID.VETREF;
                break;
            case "MATINFO":
                tempOutput = TagID.MATINFO;
                break;
            case "TICKETCITATION":
                tempOutput = TagID.TICKETCITATION;
                break;
            case "HOLIDAYMOTEL":
                tempOutput = TagID.HOLIDAYMOTEL;
                break;
            case "IOPREF":
                tempOutput = TagID.IOPREF;
                break;
            case "STREET":
                tempOutput = TagID.STREET;
                break;
            case "COPEAPP":
                tempOutput = TagID.COPEAPP;
                break;
            default:
                tempOutput = TagID.NULL;
                break;
        }
        tag = tempOutput;
    }
    public void printTag ()
    {
        System.out.println(tag);
    }
}
