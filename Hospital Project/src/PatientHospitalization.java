import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class PatientHospitalization {
    public static Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
     public static void main(Hospital main) {
         PDoc pDoc = new PDoc();
         int var ;
         int varr;
         System.out.println("=> Enter the New Patient's Information : ");
         pDoc.setpName(PatientHospitalization.setpName());
         pDoc.setpCode(PatientHospitalization.setpCode());
         pDoc.setrDateTime(PatientHospitalization.setrDateTime());
         pDoc.setpSickness(PatientHospitalization.setpSickness());
         pDoc.setpInsurance(PatientHospitalization.setpInsurance());
         pDoc.setpGender(PatientHospitalization.setpGender());
         pDoc.setpAge(PatientHospitalization.setPAge());
         pDoc.setpDoctor(PatientHospitalization.setPDoctor(main,pDoc));
         pDoc.sethDateTime(LocalDateTime.now());
         pDoc.sethDate(LocalDate.now());
         pDoc.setpTypeReferaal(PatientHospitalization.setpTypeReferaal());
         setPBed(main,pDoc);
         main.hospitalHistoryPDocs.add(main.hospitalHistoryPDocs.size(),pDoc);
         System.out.println();
     }
        public static String setpName(){
            System.out.println("Full name :");
            return PatientHospitalization.getScanner().nextLine();
        }
        public static String setpCode(){
            System.out.println("Patient's Code:");
            System.out.println("Please don't write first zero of the Code.");
            return PatientHospitalization.getScanner().nextLine();
        }
        public static LocalDateTime setrDateTime(){
            System.out.println("What time is Patient's referral :");
            System.out.println("* Please write 'Year,Month,Month's day,Hour,Minute' in order. ");
            String[] dateTime = PatientHospitalization.getScanner().nextLine().split(",");
            return LocalDateTime.of(Integer.parseInt(dateTime[0]),Integer.parseInt(dateTime[1]),Integer.parseInt(dateTime[2]),Integer.parseInt(dateTime[3]),Integer.parseInt(dateTime[4]));
        }
        public static Sickness setpSickness(){
            System.out.println("What kind is sickness :");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("1.Burn");
            System.out.println("2.Damage");
            System.out.println("3.Accident");
            System.out.println("4.Others");
            switch (Integer.parseInt(PatientHospitalization.getScanner().nextLine())){
                case 1 :return Sickness.Burn;

                case 2 :return Sickness.Damage;
                case 3 :return Sickness.Accident;
                case 4 :return Sickness.Others;
            }

            return null;
        }
        public static Insurance setpInsurance(){
            System.out.println("What kind is Insurance:");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("1.socialSecurity");
            System.out.println("2.armedForces");
            System.out.println("3.healthService");
            switch (Integer.parseInt(PatientHospitalization.getScanner().nextLine())){
                case 1 :return Insurance.socialSecurity;
                case 2 :return Insurance.armedForces;
                case 3 :return Insurance.healthService;
            }
            return null;
        }
        public static Gender setpGender(){
            System.out.println("What is the patient's gender :");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("1.Male");
            System.out.println("2.Female");
            switch (Integer.parseInt(PatientHospitalization.getScanner().nextLine())){
                case 1 :return Gender.Male;
                case 2 :return Gender.Female;

            }
        return null;
        }
        public static int setPAge(){
            System.out.println("How old is the patient :");
            return Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        }
        public static Doctor setPDoctor(Hospital main,PDoc pDoc) {
            int doctorInput;
            System.out.println("Who is the Patient's Doctor :");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("Parts :");
            for (int i = 0; i < main.parts.size(); i++) {
                System.out.println((i + 1) + "." + main.parts.get(i).name);
            }
            int inputp = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
            inputp = inputp-1;
            Random rnd = new Random();
            while(true){
                if(main.parts.get(inputp).doctors.size()>0){
                    doctorInput = rnd.nextInt(main.parts.get(inputp).doctors.size());
                    for(int pd = 0; pd<main.parts.get(inputp).doctors.get(doctorInput).docPDocs.size(); pd++){
                        if(main.parts.get(inputp).doctors.get(doctorInput).docPDocs.get(pd) == null){
                            main.parts.get(inputp).doctors.get(doctorInput).docPDocs.set(pd,pDoc);
                            pDoc.setDocPDocAddress(pd);
                            main.parts.get(inputp).doctors.get(doctorInput).docPdocsHistory.add(main.parts.get(inputp).doctors.get(doctorInput).docPdocsHistory.size(),pDoc);
                            break;
                        }

                    }
                    System.out.println("Patient's Doctor is : "+main.parts.get(inputp).doctors.get(doctorInput).docName+" , "+main.parts.get(inputp).doctors.get(doctorInput).docPersonnelID);
                    System.out.println();
                    return main.parts.get(inputp).doctors.get(doctorInput);

                }
                else {
                    System.out.println("No Doctor in this Part to Choice !");
                    return null;

                }

            }
        }
    public static TypeReferral setpTypeReferaal(){
        System.out.println("What type is the referral ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("1.Ordinary");
        System.out.println("2.Emergency");
        switch (Integer.parseInt(PatientHospitalization.getScanner().nextLine())){
            case 1 : return TypeReferral.Ordinary;
            case 2 : return TypeReferral.Emergency;
        }
            return null;
    }
    public static void setPBed(Hospital main,PDoc pDoc){
        while(true) {
            Random rnd = new Random();
            System.out.println("Patient's Part,Room,Bed :");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("Parts :");
            for (int p = 0; p < main.parts.size(); p++) {
                System.out.println((p + 1) + "." + main.parts.get(p).name);
            }
            int inputp = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
            inputp = inputp -1;
            for(int r = 0; r<main.parts.get(inputp).rooms.length; r++) {
                if (main.parts.get(inputp).rooms[r].startDate != null & main.parts.get(inputp).rooms[r].finishDate != null){
                    if (main.parts.get(inputp).rooms[r].startDate.compareTo(LocalDate.now()) >= 0 && main.parts.get(inputp).rooms[r].finishDate.compareTo(LocalDate.now()) <= 0) {
                        for (int b = 0; b < main.parts.get(inputp).rooms[r].roomBeds.size(); b++) {
                            if (main.parts.get(inputp).rooms[r].roomBeds.get(b).patientDocBed == null) {
                                main.parts.get(inputp).rooms[r].roomBeds.get(b).patientDocBed = pDoc;
                                main.parts.get(inputp).rooms[r].roomPDocsHistory.add(main.parts.get(inputp).rooms[r].roomPDocsHistory.size(), pDoc);
                                pDoc.setpDocAddress(main.parts.get(inputp).name + "/" + "Room " + (inputp + 1) + "0" + (r) + "/" + "Bed " + (inputp + 3) + "4" + (b));
                                System.out.println("Patient's Bed Address : " + main.parts.get(inputp).name + "/" + "Room " + (inputp + 1) + "0" + (r) + "/" + "Bed " + (inputp + 3) + "4" + (b));
                                break;
                            }
                            break;
                        }
                        break;
                    }

            }
                else {
                    for (int b = 0; b < main.parts.get(inputp).rooms[r].roomBeds.size(); b++) {
                        if (main.parts.get(inputp).rooms[r].roomBeds.get(b).patientDocBed == null) {
                            main.parts.get(inputp).rooms[r].roomBeds.get(b).patientDocBed = pDoc;
                            main.parts.get(inputp).rooms[r].roomPDocsHistory.add(main.parts.get(inputp).rooms[r].roomPDocsHistory.size(), pDoc);
                            pDoc.setpDocAddress(main.parts.get(inputp).name + "/" + "Room " + (inputp + 1) + "0" + (r) + "/" + "Bed " + (inputp + 3) + "4" + (b));
                            System.out.println("Patient's Bed Address : " + main.parts.get(inputp).name + "/" + "Room " + (inputp + 1) + "0" + (r) + "/" + "Bed " + (inputp + 3) + "4" + (b));
                            main.parts.get(inputp).documentNumber = main.parts.get(inputp).documentNumber+rnd.nextInt(15);
                            pDoc.setpDocNumb(main.parts.get(inputp).documentNumber);

                            break;
                        }
                    }
                    break;
                }
            }
            break;
            }

        }
    }

