import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Doctor {
    String docName ;
    String docPersonnelID;
    ArrayList<PDoc> docPDocs = new ArrayList<>(5);
    ArrayList<PDoc> docPdocsHistory = new ArrayList<>();
    Calender docCalender ;
    Nurse[] docNurses = new Nurse[2];

}

