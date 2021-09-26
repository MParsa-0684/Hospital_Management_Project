public class PartChanging {
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
                System.out.println("1.Part's Name : "+main.parts.get(q).name);
                System.out.println("*Part's Rooms number : "+main.parts.get(q).roomNumbers );
                System.out.println("2.Part's Doctors :");
                for(int e = 0; e<main.parts.get(q).doctors.size(); e++){
                    System.out.println("    Doctor "+main.parts.get(q).doctors.get(e).docName+", UserID : "+main.parts.get(q).doctors.get(e).docPersonnelID);
                }
                System.out.println();
                System.out.println("3.Part's Nurses :");
                for(int e = 0; e<main.parts.get(q).nurses.size(); e++){
                    System.out.println("    Nurse "+main.parts.get(q).nurses.get(e).nurseName+", UserID : "+main.parts.get(q).nurses.get(e).nursePersonnelID);
                    if(main.parts.get(q).nurses.get(e).nurseType == NurseType.DoctorsHelper){
                        System.out.println("        Helps Doctor "+main.parts.get(q).nurses.get(e).nDocters[0].docName+", Doctor's UserID :"+main.parts.get(q).nurses.get(e).nDocters[0].docPersonnelID);
                        System.out.println("        Helps Doctor "+main.parts.get(q).nurses.get(e).nDocters[1].docName+", Doctor's UserID :"+main.parts.get(q).nurses.get(e).nDocters[1].docPersonnelID);
                    }

                }
                System.out.println();
                System.out.println("*Part's Rooms :");
                for(int e=0; e<main.parts.get(q).rooms.length; e++){
                    System.out.println("   Room " + (q + 1) + "0" + e);
                }
                System.out.println("4.Add a new Part ");
                int vare = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                if(vare ==1){
                    System.out.print("Write a new Name for this Part : ");
                    main.parts.get(q).name = PatientHospitalization.getScanner().nextLine(); }

                if(vare ==2){
                    System.out.println("Which Doctor ?");
                    for(int e = 0; e<main.parts.get(q).doctors.size() ; e++){
                        System.out.println("    "+(e+1)+"."+main.parts.get(q).doctors.get(e).docName+" , "+main.parts.get(q).doctors.get(e).docPersonnelID);
                    }
                    int vart = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                    for(int e = 0; e<main.parts.get(q).doctors.size(); e++){
                        if(vart == (e+1)){
                            DocNurseChanging.changeDoc(main,q,e);
                        }
                    }
                }
                if(vare == 3){
                    for(int e = 0; e<main.parts.get(q).nurses.size(); e++) {
                        System.out.println("    " + (e + 1) +"."+ main.parts.get(q).nurses.get(e).nurseName + ", UserID : " + main.parts.get(q).nurses.get(e).nursePersonnelID);
                    }
                    int vart = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                    for(int e = 0; e<main.parts.get(q).nurses.size(); e++){
                        if(vart == (e+1)){
                            DocNurseChanging.changeNurse(main,q,e);
                        }
                    }

                }

                if(vare ==4){
                    System.out.print("=> Write New Part's Name : ");
                    main.parts.add(main.parts.size(),new Part(PatientHospitalization.getScanner().nextLine()));
                    System.out.print("=> Write New Part's rooms number : ");
                    main.parts.get(main.parts.size()-1).roomNumbers = Integer.parseInt(PatientHospitalization.getScanner().nextLine());//3
                    main.parts.get(main.parts.size()-1).rooms = new Room[main.parts.get(main.parts.size()-1).roomNumbers];
                    System.out.print("=> Write a Number for Beds number for all New Part's rooms : ");
                    int mainBed = Integer.parseInt(PatientHospitalization.getScanner().nextLine());//5
                    for (int i = 0; i<main.parts.get(main.parts.size()-1).rooms.length; i++) {
                        main.parts.get(main.parts.size()-1).rooms[i] = new Room();
                        main.parts.get(main.parts.size()-1).rooms[i].setBed(mainBed);
                    }
                    System.out.print("=> Write a Room cost for New Part rooms : ");
                    Double roomsCost = Double.parseDouble(PatientHospitalization.getScanner().nextLine());
                    for(int i = 0 ; i < main.parts.get(main.parts.size()-1).rooms.length ; i++){
                        main.parts.get(main.parts.size()-1).rooms[i].roomCost = roomsCost;
                        main.parts.get(main.parts.size()-1).rooms[i].setDailyCost(main.parts.get(main.parts.size()-1).rooms[i].roomCost,main.parts.get(main.parts.size()-1).rooms[i].roomBeds.size());
                    }

                }
                System.out.println();

            }
        }
    }
}
