import java.time.LocalDate;

public class PatientDischarging {
    public static void PatientDischarging(Hospital main) {
        System.out.println("Patient Part,Room,Bed to Discharge :");
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
        System.out.println("Room " + (inputp + 1) + "0" + (inputr-1) + "'s Beds :");
        for (int b = 0; b < main.parts.get(inputp).rooms[inputr-1].roomBeds.size(); b++) {
            System.out.print((b + 1) + ".Bed " + (inputp + 3) + "4" + b);
            if (main.parts.get(inputp).rooms[inputr-1].roomBeds.get(b).patientDocBed == null) {
                System.out.println("  ==> *Empty*");
            } else {
                System.out.println("  ==> " + main.parts.get(inputp).rooms[inputr-1].roomBeds.get(b).patientDocBed.getpName() + " , " + main.parts.get(inputp).rooms[inputr-1].roomBeds.get(b).patientDocBed.getpCode());
            }
        }
        System.out.println("To choice again the Patient's Bed, Enter '000'");
        int inputb = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        if(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed != null){
            System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpName() + "'s Information :");
            System.out.println("    * To choice an item , Please write it's number .");
            System.out.print("    *Name : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpName() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpName());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Code : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpCode() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpCode());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Referral Time : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getrDateTime() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getrDateTime().toString());
            } else {
                System.out.println("Null");
            }
            System.out.println("    * Document's Number : " + main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpDocNumb());
            System.out.println("    * Hospitalization Time (UnChangeable) : " + main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.gethDateTime().toString());
            System.out.print("    *Sickness : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpSickness() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpSickness().toString());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Insurance : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpInsurance() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpInsurance().toString());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Gender : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpGender() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpGender().toString());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Age : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpAge() != 0) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpAge());
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Doctor : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpDoctor() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpDoctor().docName + " , " + main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpDoctor().docPersonnelID);
            } else {
                System.out.println("Null");
            }
            System.out.print("    *Type Referral : ");
            if (main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpTypeReferaal() != null) {
                System.out.println(main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpTypeReferaal().toString());
            } else {
                System.out.println("Null");
            }
            System.out.println("    *Bed (Address) : " + main.parts.get(inputp).rooms[inputr - 1].roomBeds.get(inputb - 1).patientDocBed.getpDocAddress());
            System.out.println();
            System.out.println("    *This Patient's Room Daily Cost : " + main.parts.get(inputp).rooms[inputr-1].dailyCost);
        Insurance ins = main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.getpInsurance();
        int dis = 1;
        if (ins.equals(Insurance.socialSecurity)){
            System.out.println("    *Percent of Discount by Insurance: 10%");
            dis = 10;
        }
        if (ins.equals(Insurance.armedForces)){
            System.out.println("    *Percent of Discount by Insurance: 50%");
            dis = 50;
        }
        if (ins.equals(Insurance.healthService)){
            System.out.println("    *Percent of Discount by Insurance: 25%");
            dis = 25;
        }
        int hDays = LocalDate.now().compareTo(main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.gethDate());
            System.out.println("    *Duration of Hospitalization : "+hDays+" Days.");
        double total = hDays *main.parts.get(inputp).rooms[inputr-1].dailyCost;
            System.out.println("    *Total Price: " + total);
            System.out.println("    *Final Price: " + (total-((total*dis)/100)));

        System.out.println();
        System.out.println();
        System.out.println("        *Are you sure you want to Discharge the Patient?");
        System.out.println("        1.Yes");
        System.out.println("        2.Exit");
        int C = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        if(C == 1){
            int count = 0;
            main.hospitalDischargingFactor.add(main.hospitalDischargingFactor.size(),new DischargingFactor());
            main.hospitalDischargingFactor.get(main.hospitalDischargingFactor.size()-1).DischargingDate = LocalDate.now();
            main.hospitalDischargingFactor.get(main.hospitalDischargingFactor.size()-1).finalPrice = (total-((total*dis)/100));
            while (count<main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.getpDoctor().docPDocs.size()){
                if(main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.getpDoctor().docPDocs.get(count).equals(main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.getpDocNumb())){
                    main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed.getpDoctor().docPDocs.set(count,null);
                    break;
                }
                count++;
            }
            main.parts.get(inputp).rooms[inputr-1].roomBeds.get(inputb-1).patientDocBed = null;

        }
        if(C == 2){
        }
        }





    }
}
