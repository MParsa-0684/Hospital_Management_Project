import java.util.Scanner;

public class NurseR {
    public static void main(Hospital main){
        System.out.println("Which Part does Nurse belong to ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for (int q = 0; q < main.parts.size(); q++) {
            if (varr == q + 1) {
            NurseR.setNurse(main,q);
            }
        }
    }

    public static void setNurse(Hospital main,int q){
        Scanner scanner = new Scanner(System.in);
        main.parts.get(q).nurses.add(main.parts.get(q).nurses.size(), new Nurse());
        main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nurseName = setNurseName();
        main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nursePersonnelID = setPersonnelID();
        System.out.println("Is this Nurse belongs to Doctors or Part force ?");
        System.out.println("1.Doctors helpers");
        System.out.println("2.Part force");
        int var = Integer.parseInt(scanner.nextLine());
        int select=0;
        if (var == 1) {
            main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nurseType = NurseType.DoctorsHelper;
            if(main.parts.get(q).emergencyDoctors.size()==0){
                System.out.println("    You will be selected by two different doctors.");
            }
            else {
            for(int d=0;d<main.parts.get(q).emergencyDoctors.size(); d++){
                if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] == null ){
                    main.parts.get(q).emergencyDoctors.get(d).docNurses[0] = main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1);
                    main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[0]=main.parts.get(q).emergencyDoctors.get(d);
                    select=d;
                    if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] != null && main.parts.get(q).emergencyDoctors.get(d).docNurses[1] != null){
                        main.parts.get(q).emergencyDoctors.remove(d);
                    }
                    break;
                }
                if( main.parts.get(q).emergencyDoctors.get(d).docNurses[1] == null){
                    main.parts.get(q).emergencyDoctors.get(d).docNurses[1] = main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1);
                    main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[0]=main.parts.get(q).emergencyDoctors.get(d);
                    select = d;
                    if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] != null && main.parts.get(q).emergencyDoctors.get(d).docNurses[1] != null){
                        main.parts.get(q).emergencyDoctors.remove(d);
                    }
                    break;
                }
            }
                for(int d=0;d<main.parts.get(q).emergencyDoctors.size(); d++){
                    if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] == null && d!=select){
                        main.parts.get(q).emergencyDoctors.get(d).docNurses[0] = main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1);
                        main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[1]=main.parts.get(q).emergencyDoctors.get(d);
                        if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] != null && main.parts.get(q).emergencyDoctors.get(d).docNurses[1] != null){
                            main.parts.get(q).emergencyDoctors.remove(d);
                        }
                        break;
                    }
                    if( main.parts.get(q).emergencyDoctors.get(d).docNurses[1] == null){
                        main.parts.get(q).emergencyDoctors.get(d).docNurses[1] = main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1);
                        main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[1]=main.parts.get(q).emergencyDoctors.get(d);
                        if(main.parts.get(q).emergencyDoctors.get(d).docNurses[0] != null && main.parts.get(q).emergencyDoctors.get(d).docNurses[1] != null){
                            main.parts.get(q).emergencyDoctors.remove(d);
                        }
                        break;
                    }
                }
            }
            // Doctor[] docs = setNurseDocHelp(main,q);
            // main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[0] = docs[0];
            // main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[1] = docs[1];
            // main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nurseCalender = new Calender(main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[0].docCalender.week,main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[1].docCalender.week);
            System.out.println("Nurse Doctors Will be :");
            for(int d=0; d<main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters.length; d++){
                if(main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[d]!=null){
                    System.out.println("    "+(d+1)+"."+main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nDocters[d].docName);
                }
                else {
                    System.out.println("    "+(d+1)+". Null");
                }
            }

        }
        if (var == 2) {
            main.parts.get(q).nurses.get(main.parts.get(q).nurses.size() - 1).nurseType = NurseType.PartForce;
            String[] shifts = setNursePartForce(main,q);
            main.parts.get(q).nurses.get(main.parts.get(q).nurses.size()-1).nurseCalender = new Calender(shifts[0],shifts[1],shifts[2],shifts[3],shifts[4],shifts[5]);

        }
        System.out.println();


}
    public static String setNurseName (){
        System.out.println("=> Enter the New Nurse's Information : ");
        System.out.println("Full Name :");
        return PatientHospitalization.getScanner().nextLine();

    }
    public static String setPersonnelID(){
        System.out.println("Nurse's Personnel ID :");
        return PatientHospitalization.getScanner().nextLine();

    }
    public static Doctor[] setNurseDocHelp(Hospital main,int q){
        for (int i = 1; i <= main.parts.get(q).doctors.size(); i++) {
            System.out.println(i + "." + main.parts.get(q).doctors.get(i - 1).docName);
        }
        System.out.println("To Enter this part,Please write like this : For example :1,3 ==> Means You selected Doctor Number 1 & Doctor Number 3 ");
        String doctorCode;
        String[] docterCodes ;
        int[] docterShifts = new int[2];
        doctorCode = PatientHospitalization.getScanner().nextLine();
        docterCodes = doctorCode.split(",");
        docterShifts[0] = Integer.parseInt(docterCodes[0]);
        docterShifts[1] = Integer.parseInt(docterCodes[1]);
        Doctor[] returnDoctors = new Doctor[2];
        for (int i = 1; i <= main.parts.get(q).doctors.size(); i++) {
            if (docterShifts[0] == i) {
                returnDoctors[0] = main.parts.get(q).doctors.get(i - 1);
            }
            if (docterShifts[1] == i) {
               returnDoctors[1] = main.parts.get(q).doctors.get(i - 1);

            }
        }
        return returnDoctors;
    }
    public static String[] setNursePartForce(Hospital main,int q){
        String[] shifts = new String[6];
        System.out.println("Nurse's Shifts :");
        System.out.println("Days :           Day's Shifts :");
        System.out.println("1.Saturday       1.First Shift");
        System.out.println("2.Sunday         2.Second Shift");
        System.out.println("3.Monday         3.Third Shift");
        System.out.println("4.Tuesday");
        System.out.println("5.Wednesday");
        System.out.println("6.Thursday");
        System.out.println("7.Friday");
        System.out.println("To Enter this part,Please write like this :Days,Day's Shift ; For example :1,3 ==> This means Third shift in Saturday.");
        System.out.print("Shift 1:");
        shifts[0] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 2:");
        shifts[1] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 3:");
        shifts[2] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 4:");
        shifts[3] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 5:");
        shifts[4] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 6:");
        shifts[5] = PatientHospitalization.getScanner().nextLine();
        return shifts;
    }
    }

