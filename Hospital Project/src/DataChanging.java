import java.util.Scanner;

public class DataChanging {
    public static void main(Hospital main) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Patients Information Changing");
        System.out.println("2.Doctors & Nurses Information Changing");
        System.out.println("3.Parts Information Changing");
        System.out.println("4.Rooms Information Changing");
        System.out.println("5.Shifts Information Changing");
        int var = Integer.parseInt(scanner.nextLine());
        System.out.println();
        if(var==1){PatientChanging.main(main);}
        if(var==2){DocNurseChanging.main(main);}
        if(var==3){PartChanging.main(main);}
        if(var==4){RoomChanging.main(main);}
        if(var==5){ShiftsChanging.main(main);}

    }

}
