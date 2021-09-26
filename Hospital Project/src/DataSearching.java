public class DataSearching {
    public static void main(Hospital main) {
        System.out.println("1.Searching the Rooms that they are out of Reach in a Period of Time.");
        System.out.println("2.Searching Doctors/Nurses Who have a certain Shift.");
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        if(var==1){DataSearchingMethods.searchRoomPeriod(main);}
        if(var==2){DataSearchingMethods.searchDoctorNurseCertainShift(main);}
    }
}
