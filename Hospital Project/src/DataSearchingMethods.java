import java.time.LocalDate;

public class DataSearchingMethods {
    public static void searchRoomPeriod(Hospital main) {
        int count = 1;
        System.out.println("Search for Rooms that are out of reach for a period of Time. ");
        System.out.println("From What date do you want ?");
        String[] sdates = PatientHospitalization.getScanner().nextLine().split(",");
        int[] sDates = new int[sdates.length];
        for(int s =0; s<sdates.length; s++){ sDates[s] = Integer.parseInt(sdates[s]); }
        LocalDate sDate = LocalDate.of(sDates[0],sDates[1],sDates[2]);
        System.out.println("To What date do you want ?");
        String[] fdates = PatientHospitalization.getScanner().nextLine().split(",");
        int[] fDates = new int[fdates.length];
        for(int s =0; s<fdates.length; s++){ fDates[s] = Integer.parseInt(fdates[s]); }
        LocalDate fDate = LocalDate.of(fDates[0],fDates[1],fDates[2]);
        System.out.println("Rooms within this Period of Time : from "+sDate+" to "+fDate);
        for(int p = 0; p<main.parts.size(); p++){
            for(int h = 0; h <main.parts.get(p).historyRoomsOutDates.size(); h++){
                if(sDate.compareTo(main.parts.get(p).historyRoomsOutDates.get(h).historyStartDate) <=0 && fDate.compareTo(main.parts.get(p).historyRoomsOutDates.get(h).historyFinishDate) >=0 ){
                    System.out.println("    "+count+".Room's Address :"+main.parts.get(p).historyRoomsOutDates.get(h).roomAddress+" , Out of Reach Time : from "+main.parts.get(p).historyRoomsOutDates.get(h).historyStartDate.toString()+" to "+main.parts.get(p).historyRoomsOutDates.get(h).historyFinishDate.toString());
                    count++;
                }
            }
        }
        if(count ==1){
            System.out.println("    There in no Room within this Period of Time.");
        }
        System.out.println();
    }
    public static void searchDoctorNurseCertainShift(Hospital main) {
        int count = 1;
        System.out.println("Which Shift do you want ?");
        System.out.println("Days :           Day's Shifts :");
        System.out.println("1.Saturday       1.First Shift");
        System.out.println("2.Sunday         2.Second Shift");
        System.out.println("3.Monday         3.Third Shift");
        System.out.println("4.Tuesday");
        System.out.println("5.Wednesday");
        System.out.println("6.Thursday");
        System.out.println("7.Friday");
        System.out.println("To Enter this part,Please write like this :Days,Day's Shift ; For example :1,3 ==> This means Third shift in Saturday.");
        String input = PatientHospitalization.getScanner().nextLine();
        String[] shifts = input.split(",");
        String[] shift = new String[2];
        shift[0] = Calender.weekly(Integer.parseInt(shifts[0]));
        shift[1] = Calender.shiftly(Integer.parseInt(shifts[1]));
        System.out.println("Doctor/Nurses :");
        for(int p = 0; p<main.parts.size(); p++){
            for(int d = 0; d<main.parts.get(p).doctors.size(); d++){
                for(int s = 0; s <3; s++){
                    if(main.parts.get(p).doctors.get(d).docCalender.week[s][0].equals(shift[0]) && main.parts.get(p).doctors.get(d).docCalender.week[s][1].equals(shift[1])){
                        System.out.println("    "+count+".Doctor "+main.parts.get(p).doctors.get(d).docName+" , "+main.parts.get(p).doctors.get(d).docPersonnelID);
                        count++;
                    }


                }
            }
            for(int n = 0; n<main.parts.get(p).nurses.size(); n++) {
                if(main.parts.get(p).nurses.get(n).nurseType == NurseType.PartForce){
                for (int s = 0; s < 6; s++) {
                    if (main.parts.get(p).nurses.get(n).nurseCalender.week[s][0].equals(shift[0]) && main.parts.get(p).nurses.get(n).nurseCalender.week[s][1].equals(shift[1])) {
                        System.out.println("    " + count + ".Nurse " + main.parts.get(p).nurses.get(n).nurseName + " , " + main.parts.get(p).nurses.get(n).nursePersonnelID);
                        count++;
                    }
                }
            }
           if(main.parts.get(p).nurses.get(n).nurseType == NurseType.DoctorsHelper) {
               for (int d = 0; d < 2; d++){
                   if (main.parts.get(p).nurses.get(n).nDocters[d] != null) {
                       for (int s =0; s<3; s++){
                           if(main.parts.get(p).nurses.get(n).nDocters[d].docCalender.week[s][0].equals(shift[0]) && main.parts.get(p).nurses.get(n).nDocters[d].docCalender.week[s][1].equals(shift[1])){
                               System.out.println("    " + count + ".Nurse " + main.parts.get(p).nurses.get(n).nurseName + " , " + main.parts.get(p).nurses.get(n).nursePersonnelID);
                               count++;
                           }
                       }
                   }

           }
           }
            }
        }
        if(count ==1){
            System.out.println("    There is no Doctor/Nurses in this Shift !");
        }
        System.out.println();
    }
}
