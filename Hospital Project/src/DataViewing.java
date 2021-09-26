public class DataViewing {
    public static void main(Hospital main) {
        System.out.println("1.Part's Patients");
        System.out.println("2.View the Patient's Doctor Using Patient's Code Or Document Number.");
        System.out.println("3.Doctor's History of Patient Treatments in a Period of Time.");
        System.out.println("4.View Hospital Receipts in a Period of Time.");
        System.out.println("5.View History of Patients in the Room. ");
        System.out.println("6.The History of Hospitalized Patients in a Period of Time.");
        System.out.println("7.View the Shifts of Personnel Using their UserID.");
        System.out.println("8.View All the Shifts of a Part.");
        System.out.println("9.View the Nurses of a Patient.");
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        if(var==1){DataViewingMethods.PatientViewing(main);}
        if(var==2){DataViewingMethods.FindPatientDoctor(main);}
        if(var==3){DataViewingMethods.DoctorHistoryPDocsViewing(main);}
        if(var==4){DataViewingMethods.HospitalReceiptions(main);}
        if(var==5){DataViewingMethods.RoomPDocsHistoryViewing(main);}
        if(var==6){DataViewingMethods.HistoryPatientHospitalized(main);}
        if(var==7){DataViewingMethods.PersonnelViewing(main);}
        if(var==8){DataViewingMethods.ShiftsViewing(main);}
        if(var==9){DataViewingMethods.PatientNurseViewing(main);}
    }
}
