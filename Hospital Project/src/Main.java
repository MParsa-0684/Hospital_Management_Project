// Lines of Whole the Code : 2255 Lines
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Hospital mainHospital = new Hospital();
    mainHospital.parts.add(0,new Part("Main"));
    mainHospital.parts.add(1,new Part("Emergency"));
    int mainBed ;
    int emergencyBed ;
    double roomsCost;
        System.out.println();
        System.out.println("<< Thanks for the efforts of the World's Health & Essential Heroes. >>");
        System.out.println();
        System.out.print("=> Write the Hospital's Name : ");
        mainHospital.hospitalName = scanner.nextLine();
        System.out.print("=> Write the Hospital's Address : ");
        mainHospital.hospitalAddress = scanner.nextLine();
        System.out.print("=> Write the Main part's rooms number : ");
        mainHospital.parts.get(0).roomNumbers = Integer.parseInt(scanner.nextLine());//3
        mainHospital.parts.get(0).rooms = new Room[mainHospital.parts.get(0).roomNumbers];
        System.out.print("=> Write the Emergency part's rooms number : ");
        mainHospital.parts.get(1).roomNumbers = Integer.parseInt(scanner.nextLine());
        mainHospital.parts.get(1).rooms = new Room[mainHospital.parts.get(1).roomNumbers];
        System.out.print("=> Write a Number for Beds number for all the Main Part's rooms : ");
        mainBed = Integer.parseInt(scanner.nextLine());//5
        for (int i = 0; i<mainHospital.parts.get(0).rooms.length; i++) {
            mainHospital.parts.get(0).rooms[i] = new Room();
            mainHospital.parts.get(0).rooms[i].setBed(mainBed);

        }

        System.out.print("=> Write a Number for Beds number for all the Emergency Part's rooms : ");
        emergencyBed = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<mainHospital.parts.get(1).rooms.length; i++) {
            mainHospital.parts.get(1).rooms[i] = new Room();
            mainHospital.parts.get(1).rooms[i].setBed(emergencyBed);
        }
        System.out.print("=> Write a Room cost for all the Parts rooms : ");
        roomsCost = Double.parseDouble(scanner.nextLine());
        for(int i = 0 ; i < mainHospital.parts.get(0).rooms.length ; i++){
            mainHospital.parts.get(0).rooms[i].roomCost = roomsCost;
            mainHospital.parts.get(0).rooms[i].setDailyCost(mainHospital.parts.get(0).rooms[i].roomCost,mainHospital.parts.get(0).rooms[i].roomBeds.size());
        }
        for(int i = 0 ; i < mainHospital.parts.get(1).rooms.length ; i++){
            mainHospital.parts.get(1).rooms[i].roomCost = roomsCost;
            mainHospital.parts.get(1).rooms[i].setDailyCost(mainHospital.parts.get(1).rooms[i].roomCost,mainHospital.parts.get(1).rooms[i].roomBeds.size());

        }
        while (true) {
        System.out.println("=> Main Menu : ");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("1. Doctor Registration.");
        System.out.println("2. Nurse Registration.");
        System.out.println("3. Patient Hospitalization.");
        System.out.println("4. Information Changing.");
        System.out.println("5. Information Viewing.");
        System.out.println("6. Information Searching.");
        System.out.println("7. Patient Discharging ");
        System.out.println("0. Exit");
            int var = Integer.parseInt(scanner.nextLine());
            System.out.println();
            if(var==0){ System.out.println("Good Luck !!");break;}
            if(var==1){ DoctorR.main(mainHospital);}
            if(var==2){ NurseR.main(mainHospital);}
            if(var==3){PatientHospitalization.main(mainHospital);}
            if(var==4){DataChanging.main(mainHospital);}
            if(var==5){DataViewing.main(mainHospital);}
            if(var==6){DataSearching.main(mainHospital);}
            if(var == 7){PatientDischarging.PatientDischarging(mainHospital);}
    }
    }
}
