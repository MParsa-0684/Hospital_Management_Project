import java.time.LocalDate;

public class DataViewingMethods {
    public static void PatientViewing(Hospital main) {
    System.out.println("Which Part ?");
    System.out.println("* To choice an item , Please write it's number .");
    System.out.println("Parts :");
    for (int i = 0; i < main.parts.size(); i++) {
        System.out.println((i + 1) + "." + main.parts.get(i).name);
    }
    int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
    for(int q = 0; q<main.parts.size(); q++){
        if(var == q+1){

            for(int r = 0; r<main.parts.get(q).rooms.length; r++){
                System.out.println((r + 1) + ".Room "+(q+1)+"0" + r+" :");
                for(int b =0; b<main.parts.get(q).rooms[r].roomBeds.size(); b++){
                    System.out.print("  "+(b + 1) + ".Bed "+(q+3)+"4" + b+" : ");
                    if(main.parts.get(q).rooms[r].roomBeds.get(b).patientDocBed != null){
                        System.out.println(main.parts.get(q).rooms[r].roomBeds.get(b).patientDocBed.getpName()+" , "+main.parts.get(q).rooms[r].roomBeds.get(b).patientDocBed.getpCode());
                    }
                    else {
                        System.out.println(" *Emtpy* ");
                    }
                }
            }
        }
    }
}
    public static void FindPatientDoctor(Hospital main){
        System.out.println("Which Part ?");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int part = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        part = part-1;
        System.out.println("What Information are you going to enter?");
        System.out.println("1.Patients Code");
        System.out.println("2.Patients Document Number");
        int c = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        System.out.println("Please enter the Code:");
        String codee = PatientHospitalization.getScanner().nextLine();
        if(c == 1){
            int done = 0;
            int Rcount = 0;
            int Bcount = 0;

            while(Rcount < main.parts.get(part).rooms.length){
                while (Bcount < main.parts.get(part).rooms[Rcount].roomBeds.size()) {
                    if(main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed != null){
                        if (codee.equals(main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpCode())) {
                            System.out.println("Patients Name: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpName());
                            System.out.println("Patients Code: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDocNumb());
                            System.out.println("Patients Doctor: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDoctor().docName+" , "+main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDoctor().docPersonnelID);
                            done = 1;
                        }
                    }
                    Bcount++;
                }
                Bcount =0;
                Rcount++;
            }
            if(done == 0){
                System.out.println("There isn't any Patient with this Code.");
            }
            System.out.println();
        }
        if(c == 2){
            int done = 0;
            int Rcount = 0;
            int Bcount = 0;

            while(Rcount < main.parts.get(part).rooms.length) {
                if(main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed != null){
                    while (Bcount < main.parts.get(part).rooms[Rcount].roomBeds.size()) {
                        if (codee.equals(main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDocNumb())) {
                            System.out.println("Patients Name: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpName());
                            System.out.println("Patients Code: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDocNumb());
                            System.out.println("Patients Doctor: " + main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDoctor().docName+" , "+main.parts.get(part).rooms[Rcount].roomBeds.get(Bcount).patientDocBed.getpDoctor().docPersonnelID);
                            done = 1;
                        }
                        Bcount++;
                    }
                }
                Bcount =0;
                Rcount++;
            }
            if(done == 0) {
                System.out.println("There isn't any Patient with this Code.");
            }
            System.out.println();

        }

    }
    public static void DoctorHistoryPDocsViewing(Hospital main) {
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for(int p = 0; p<main.parts.size(); p++){
            if(var == p+1){
                System.out.println("Which Doctor ?");
                for(int d = 0; d<main.parts.get(p).doctors.size(); d++){
                    System.out.println((d+1)+".Doctor "+main.parts.get(p).doctors.get(d).docName+" , "+main.parts.get(p).doctors.get(d).docPersonnelID);
                }
                int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                for(int d = 0; d<main.parts.get(p).doctors.size(); d++){
                    if(varr == d+1){
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
                        for(int h = 0; h<main.parts.get(p).doctors.get(d).docPdocsHistory.size(); h++){
                            if(sDate.compareTo(main.parts.get(p).doctors.get(d).docPdocsHistory.get(h).gethDate()) <= 0 && fDate.compareTo(main.parts.get(p).doctors.get(d).docPdocsHistory.get(h).gethDate()) >= 0) {
                                System.out.println(main.parts.get(p).doctors.get(d).docPdocsHistory.get(h).getpName()+" , "+main.parts.get(p).doctors.get(d).docPdocsHistory.get(h).getpCode()+" , Hospitalization Time : "+main.parts.get(p).doctors.get(d).docPdocsHistory.get(h).gethDateTime());
                            }
                        }

                    }
                    System.out.println();
                }
            }
        }
    }
    public static void HospitalReceiptions(Hospital main){
        double Sum = 0.0;
        System.out.println("View Hospital Receipts in a Period of Time.");
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
        System.out.println("Hospital Receipts in this Period of Time : From "+sDate+" To "+fDate+" :");
        for(int r=0; r<main.hospitalDischargingFactor.size(); r++){
            if(sDate.compareTo(main.hospitalDischargingFactor.get(r).DischargingDate) <= 0 && fDate.compareTo(main.hospitalDischargingFactor.get(r).DischargingDate) <= 0){
                System.out.println("    Receipt's Date : "+main.hospitalDischargingFactor.get(r).DischargingDate+", Amount taken in this Receipt : "+main.hospitalDischargingFactor.get(r).finalPrice);
                Sum = Sum+main.hospitalDischargingFactor.get(r).finalPrice;
            }
        }
        System.out.println("Total of Amounts in this Period of Time : "+Sum);
    }
    public static void RoomPDocsHistoryViewing(Hospital main) {
        int done = 0;
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for(int r=0; r<main.parts.get(var-1).rooms.length; r++){
            System.out.println((r + 1) + ".Room "+(var)+"0" + r);
        }
        int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        System.out.println("Room "+var+"0" + (varr - 1) + "'s History of Patients :");
        for(int h = 0; h<main.parts.get(var-1).rooms[varr-1].roomPDocsHistory.size(); h++){
            System.out.println(main.parts.get(var-1).rooms[varr-1].roomPDocsHistory.get(h).getpName()+" , "+main.parts.get(var-1).rooms[varr-1].roomPDocsHistory.get(h).getpCode()+" , Hospitalization Time : "+main.parts.get(var-1).rooms[varr-1].roomPDocsHistory.get(h).gethDateTime());
            done = 1;
        }
        if(done ==0){
            System.out.println("No History of Patients !!");
        }
        System.out.println();
    }
    public static void HistoryPatientHospitalized(Hospital main){
        int done = 0;
        System.out.println("To Watch the History of Patients in a Period of Time :");
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
        System.out.println("The Patients in this Period of Time : From "+sDate+" To "+fDate);
        for(int h = 0; h<main.hospitalHistoryPDocs.size(); h++){
            if(sDate.compareTo(main.hospitalHistoryPDocs.get(h).gethDate()) <= 0 && fDate.compareTo(main.hospitalHistoryPDocs.get(h).gethDate()) >= 0) {
                System.out.println("    "+main.hospitalHistoryPDocs.get(h).getpName()+" , "+main.hospitalHistoryPDocs.get(h).getpCode()+" , Hospitalization Time : "+main.hospitalHistoryPDocs.get(h).gethDateTime()+" , Patient's Bed Address : "+main.hospitalHistoryPDocs.get(h).getpDocAddress());
                done = 1;
            }
        }
        if(done ==0){
            System.out.println("* No Patient in this Period of Time.");
        }

    }
    public static void PersonnelViewing(Hospital main) {
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for(int q = 0; q <main.parts.size(); q++){
            if(var == q +1){
                System.out.println("Write Doctor/Nurse Personnel ID : ");
                String ID = PatientHospitalization.getScanner().nextLine();
                for(int d = 0; d<main.parts.get(q).doctors.size(); d++){
                    if(main.parts.get(q).doctors.get(d).docPersonnelID.equals(ID)){
                        System.out.println("Doctor "+main.parts.get(q).doctors.get(d).docName+" , "+main.parts.get(q).doctors.get(d).docPersonnelID+" :");
                        System.out.println("Shifts :");
                        for(int e=0; e<3; e++){
                            System.out.println("    "+(e+1)+"."+main.parts.get(q).doctors.get(d).docCalender.week[e][0]+" , "+main.parts.get(q).doctors.get(d).docCalender.week[e][1]);
                        }
                    }
                }
                for(int n = 0; n <main.parts.get(q).nurses.size(); n++){
                    if(main.parts.get(q).nurses.get(n).nursePersonnelID.equals(ID)){
                        System.out.println("Nurse "+main.parts.get(q).nurses.get(n).nurseName+" , "+main.parts.get(q).nurses.get(n).nursePersonnelID+" :");
                        System.out.println("Shifts :");
                        for(int e = 0; e<6; e++){
                            System.out.println("    "+(e+1)+"."+main.parts.get(q).nurses.get(n).nurseCalender.week[e][0]+" , "+main.parts.get(q).nurses.get(n).nurseCalender.week[e][1]);
                        }
                    }
                }
                System.out.println("To Exit, Write Number 0.");
                if(PatientHospitalization.getScanner().nextLine().equals("0")){
                    System.out.println();
                    break;
                }

            }
        }
    }
    public static void ShiftsViewing(Hospital main) {
        int m =0;
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        String[] weekDays = Calender.weekDays();
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        System.out.println("Shifts :");
        for (int q = 0; q < main.parts.size(); q++) {
            if (var == q + 1) {
                for(int p = 0; p<weekDays.length; p++){
                    System.out.println((p+1)+"."+weekDays[p]+" :");
                    for(int e =0; e<main.parts.get(q).doctors.size(); e++){
                        for(int t = 0; t<3; t++){
                            if(main.parts.get(q).doctors.get(e).docCalender.week[t][0].equals(weekDays[p])) {
                                System.out.println(m + 1 + ". Doctor " + main.parts.get(q).doctors.get(e).docName + " , " + main.parts.get(q).doctors.get(e).docPersonnelID + " : " + main.parts.get(q).doctors.get(e).docCalender.week[t][1]);
                                m++;
                            }
                        }
                    }
                    m=0;
                    for(int e =0; e<main.parts.get(q).nurses.size(); e++){
                        for(int t = 0; t<6; t++){
                            if(main.parts.get(q).nurses.get(e).nurseCalender.week[t][0].equals(weekDays[p])) {
                                System.out.println(m + 1 + ". Nurse " + main.parts.get(q).nurses.get(e).nurseName + " , " + main.parts.get(q).nurses.get(e).nursePersonnelID + " : " + main.parts.get(q).nurses.get(e).nurseCalender.week[t][1]);
                                m++;
                            }
                        }
                    }

                }
                System.out.println("To Exit, Write Number 0.");
                if(PatientHospitalization.getScanner().nextLine().equals("0")){
                    System.out.println();
                    break;
                }
            }
        }
    }
    public static void PatientNurseViewing(Hospital main) {
        System.out.println("Patient Part,Room,Bed to Change :");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int p = 0; p < main.parts.size(); p++) {
            System.out.println((p + 1) + "." + main.parts.get(p).name);
        }
        int inputp = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        inputp = inputp-1;
        System.out.println(main.parts.get(inputp).name + " Part's Rooms :");
        for(int r=0; r<main.parts.get(inputp).rooms.length; r++){
            System.out.println((r + 1) + ".Room " + (inputp + 1) + "0" + r);
        }
        int inputr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        inputr = inputr-1;
        System.out.println("Room " + (inputp + 1) + "0" + (inputr) + "'s Beds :");
        for (int b = 0; b < main.parts.get(inputp).rooms[inputr].roomBeds.size(); b++) {
            System.out.print((b + 1) + ".Bed " + (inputp + 3) + "4" + b);
            if (main.parts.get(inputp).rooms[inputr].roomBeds.get(b).patientDocBed == null) {
                System.out.println("  ==> *Empty*");
            } else {
                System.out.println("  ==> " + main.parts.get(inputp).rooms[inputr].roomBeds.get(b).patientDocBed.getpName() + " , " + main.parts.get(inputp).rooms[inputr].roomBeds.get(b).patientDocBed.getpCode());
            }
        }
        System.out.println("To choice again the Patient's Bed, Enter '000'");
        int inputb = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        inputb = inputb-1;
        if(main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed !=null){
            System.out.println(main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpName()+"'s Nurses Who helps his Doctor : ");
            System.out.println(main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpDoctor().docName+"'s Nurses :");
            System.out.println("    "+main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpDoctor().docNurses[0].nurseName+" , "+main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpDoctor().docNurses[0].nursePersonnelID);
            System.out.println("    "+main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpDoctor().docNurses[1].nurseName+" , "+main.parts.get(inputp).rooms[inputr].roomBeds.get(inputb).patientDocBed.getpDoctor().docNurses[1].nursePersonnelID);
            System.out.println();
        }
        else {
            System.out.println("No Patient !!");
        }


    }

}
