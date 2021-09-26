import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Room {
    ArrayList<Bed> roomBeds = new ArrayList<>();
    ArrayList<PDoc> roomPDocsHistory = new ArrayList<>();
    int bedNumbers = roomBeds.size();
    LocalDate startDate;
    LocalDate finishDate;
    Period outOfReachPeriod ;
    double roomCost;
    double dailyCost;

    public void setBed (int i ){
        for(int e = 0; e<i; e++){
            roomBeds.add(e,new Bed());
        }
    }
    public  void setOutOfReachPeriod(){
          outOfReachPeriod = Period.between(startDate,finishDate);
    }
    public void setDailyCost(double cost, int numbers){
        dailyCost= cost - ((numbers - 1) * ((cost / 100) * 10));
    }
}