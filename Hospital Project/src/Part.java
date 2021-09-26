import javax.print.Doc;
import java.util.ArrayList;

public class Part  {
    String name = "" ;
    int roomNumbers;
    Room[] rooms = new Room[roomNumbers];
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Nurse> nurses = new ArrayList<>();
    ArrayList<HistoryRoom> historyRoomsOutDates = new ArrayList<>();
    public Part(String name) {
        this.name = name;
    }
    ArrayList<Doctor> emergencyDoctors = new ArrayList<>();
    int documentNumber = 300000;

}
