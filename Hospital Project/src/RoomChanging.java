import java.time.LocalDate;
import java.util.Locale;

public class RoomChanging {
    public static void main(Hospital main) {
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for (int q = 0; q < main.parts.size(); q++) {
            if (var == q + 1) {
                System.out.println(main.parts.get(q).name + " Part's Rooms :");
                setRoomChanging(main,q);
            }
        }
        System.out.println();
            }
            public static void setRoomChanging(Hospital main,int q){
                for (int i = 0; i < main.parts.get(q).rooms.length; i++) {
                    System.out.println((i + 1) + ".Room " + (q + 1) + "0" + i);
                }
                int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                for (int i = 1; i <= main.parts.get(q).rooms.length; i++) {
                    if (varr == (i)) {
                        System.out.println("Room " + (q + 1) + "0" + (i - 1) + " :");
                        System.out.println("1.Cahnging Beds Information :");
                        for (int ii = 0; ii < main.parts.get(q).rooms[i - 1].roomBeds.size(); ii++) {
                            System.out.print("Bed " + (q + 3) + "4" + ii);
                            if (main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed == null) {
                                System.out.println("  ==> *Empty*");
                            } else {
                                System.out.println("  ==> " + main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed.getpName() + " , " + main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed.getpCode());
                            }
                        }

                        System.out.println("* Beds Number : "+main.parts.get(q).rooms[i-1].roomBeds.size()+" Beds ");
                        System.out.print("2.Room Out of reach time : ");
                        if(main.parts.get(q).rooms[i-1].outOfReachPeriod == null){
                            System.out.println("No date.");
                        }
                        else{
                            System.out.println(main.parts.get(q).rooms[i-1].startDate+" to "+main.parts.get(q).rooms[i-1].finishDate);
                        }
                        System.out.println("3.Room Cost : "+main.parts.get(q).rooms[i-1].dailyCost+" T");
                        System.out.println("* To choice an item , Please write it's number .");
                        int vary = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                        if(vary ==1){
                            System.out.println();
                           PatientChanging.setBedContinue(main,q,i);
                        }
                        if(vary ==2){
                            System.out.println("Write a Start time for this Date :");
                            System.out.println("Please write like this:2020,03,04 .");
                            System.out.println("Please to inactive the StartDate, Write 'Null' .");
                            String startDate = PatientHospitalization.getScanner().nextLine();
                            startDate.toLowerCase(Locale.ROOT);
                            if(startDate.equals("null")){
                                main.parts.get(q).rooms[i-1].startDate = null;
                            }
                            else{
                                main.parts.get(q).historyRoomsOutDates.add(main.parts.get(q).historyRoomsOutDates.size(),new HistoryRoom());
                                main.parts.get(q).historyRoomsOutDates.get(main.parts.get(q).historyRoomsOutDates.size()-1).roomAddress = main.parts.get(q).name+"/Room " + (q + 1) + "0" + (i - 1);
                                String[] vars = startDate.split(",");
                                main.parts.get(q).rooms[i-1].startDate = LocalDate.of(Integer.parseInt(vars[0]),Integer.parseInt(vars[1]),Integer.parseInt(vars[2]));
                                main.parts.get(q).historyRoomsOutDates.get(main.parts.get(q).historyRoomsOutDates.size()-1).historyStartDate = main.parts.get(q).rooms[i-1].startDate;
                            }
                            System.out.println("Write a Finish time for this Date :");
                            System.out.println("Please write like this:2020,03,04 .");
                            System.out.println("Please to inactive the FinishDate, Write 'Null' .");
                            String finishDate = PatientHospitalization.getScanner().nextLine();
                            finishDate.toLowerCase(Locale.ROOT);
                            if(finishDate.equals("null")){
                                main.parts.get(q).rooms[i-1].finishDate = null;
                                break;
                            }
                            else{
                                String[] varf = finishDate.split(",");
                                main.parts.get(q).rooms[i-1].finishDate = LocalDate.of(Integer.parseInt(varf[0]),Integer.parseInt(varf[1]),Integer.parseInt(varf[2]));
                                main.parts.get(q).rooms[i-1].setOutOfReachPeriod();
                                System.out.println("Room " + (q + 1) + "0" + (i - 1) + " will be out of reach from "+main.parts.get(q).rooms[i-1].startDate.toString()+" to "+main.parts.get(q).rooms[i-1].finishDate.toString()+".");
                                main.parts.get(q).historyRoomsOutDates.get(main.parts.get(q).historyRoomsOutDates.size()-1).historyFinishDate = main.parts.get(q).rooms[i-1].finishDate;
                                break;


                            }

                        }
                        if(vary ==3 ){
                            System.out.println("How much does the room cost ?");
                            System.out.println("Write like this : 300");
                            main.parts.get(q).rooms[i-1].roomCost = Double.parseDouble(PatientHospitalization.getScanner().nextLine());
                            main.parts.get(q).rooms[i-1].setDailyCost(main.parts.get(q).rooms[i-1].roomCost,main.parts.get(q).rooms[i-1].roomBeds.size());
                            System.out.println("The new Room cost is "+main.parts.get(q).rooms[i-1].dailyCost+" T .");
                            break;
                        }
                    }
                }

            }
}
