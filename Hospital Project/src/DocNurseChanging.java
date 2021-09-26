public class DocNurseChanging {
    public static void main(Hospital main) {
        System.out.println("Which Part does Doctor/Nurse belong to");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for (int q = 0; q < main.parts.size(); q++) {
            if (varr == q + 1) {
                System.out.println("1."+main.parts.get(q).name+"'s Doctors :");
                for(int e = 0; e<main.parts.get(q).doctors.size() ; e++){
                    System.out.println("    "+(e+1)+"."+main.parts.get(q).doctors.get(e).docName+" , "+main.parts.get(q).doctors.get(e).docPersonnelID);
                }
                System.out.println("2."+main.parts.get(q).name+"'s Nurses :");
                for(int e = 0; e<main.parts.get(q).nurses.size() ; e++){
                    System.out.println("    "+(e+1)+"."+main.parts.get(q).nurses.get(e).nurseName+" , "+main.parts.get(q).nurses.get(e).nursePersonnelID);
                }
                System.out.println("To Enter this part,Please write like this : For example :1,3 ==> Doctor Number 3 in Doctors List.");
                String var = PatientHospitalization.getScanner().nextLine();
                String[] choice = var.split(",");
                int[] choices = new int[2];
                choices[0] = Integer.parseInt(choice[0]);
                choices[1] = Integer.parseInt(choice[1]);
                if(choices[0] == 1){
                    for(int t = 0; t<main.parts.get(q).doctors.size(); t++){
                        if(choices[1]==t+1){
                            changeDoc(main,q,t);
                        }
                    }
                    System.out.println();
                }
                if(choices[0] == 2){
                    for(int t = 0; t<main.parts.get(q).nurses.size(); t++){
                        if(choices[1]==t+1){
                        changeNurse(main,q,t);
                        }
                    }

                }

            }

        }
            }
            public static void changeDoc(Hospital main,int q,int t){
                System.out.println(main.parts.get(q).doctors.get(t).docName+"'s Information :");
                System.out.println("* To choice an item , Please write it's number .");
                System.out.println("1.Doctor's Name : "+main.parts.get(q).doctors.get(t).docName);
                System.out.println("2.Doctor's Personnel ID : "+main.parts.get(q).doctors.get(t).docPersonnelID);
                System.out.println("* Doctor's Patients :");
                for(int e = 0; e<main.parts.get(q).doctors.get(t).docPDocs.size(); e++){
                    if(main.parts.get(q).doctors.get(t).docPDocs.get(e).getpDocNumb() != 0){
                        System.out.println("    "+(e+1)+". "+main.parts.get(q).doctors.get(t).docPDocs.get(e).getpName()+" , "+main.parts.get(q).doctors.get(t).docPDocs.get(e).getpCode());
                    }
                    else {
                        System.out.println("    "+(e+1)+". "+"Emtpy");
                    }
                }
                System.out.println("3.Doctor shifts : ");
                for(int e=0; e<3; e++){
                    System.out.println("    "+(e+1)+"."+main.parts.get(q).doctors.get(t).docCalender.week[e][0]+" , "+main.parts.get(q).doctors.get(t).docCalender.week[e][1]);
                }
                System.out.println("4.Doctor Nurses :");
                for(int n =0;n<main.parts.get(q).doctors.get(t).docNurses.length; n++){
                    System.out.println("    Nurse "+main.parts.get(q).doctors.get(t).docNurses[n].nurseName+" , "+main.parts.get(q).doctors.get(t).docNurses[n].nursePersonnelID);
                }
                int docdata = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                if(docdata == 1){
                    main.parts.get(q).doctors.get(t).docName = DoctorR.setDocName();
                }
                if(docdata == 2){
                    main.parts.get(q).doctors.get(t).docPersonnelID = DoctorR.setDocPersonnelID();
                }

                if(docdata == 3){
                    String[] SHIFT = DoctorR.setDocShifts();
                    main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1).docCalender = new Calender(SHIFT[0],SHIFT[1],SHIFT[2]);
                }
                if(docdata ==4){
                    for(int n=0; n<main.parts.get(q).doctors.get(t).docNurses[0].nDocters.length; n++){
                        if(main.parts.get(q).doctors.get(t).docNurses[0].nDocters[n]==main.parts.get(q).doctors.get(t)){
                            main.parts.get(q).doctors.get(t).docNurses[0].nDocters[n]=null;
                            break;
                        }
                    }
                    for(int n=0; n<main.parts.get(q).doctors.get(t).docNurses[1].nDocters.length; n++){
                        if(main.parts.get(q).doctors.get(t).docNurses[1].nDocters[n]==main.parts.get(q).doctors.get(t)){
                            main.parts.get(q).doctors.get(t).docNurses[1].nDocters[n]=null;
                            break;
                        }
                    }
                    main.parts.get(q).doctors.get(t).docNurses[0]=null;
                    main.parts.get(q).doctors.get(t).docNurses[1]=null;

                    DoctorR.setDocNurses(main,main.parts.get(q).doctors.get(t));

                }
            }
            public static void changeNurse(Hospital main,int q,int t){
                System.out.println(main.parts.get(q).nurses.get(t).nurseName+"'s Information :");
                System.out.println("* To choice an item , Please write it's number .");
                System.out.println("1.Nurse's Name : "+main.parts.get(q).nurses.get(t).nurseName);
                System.out.println("2.Nurse's Personnel ID : "+main.parts.get(q).nurses.get(t).nursePersonnelID);
                if(main.parts.get(q).nurses.get(t).nurseType==NurseType.DoctorsHelper){
                    System.out.println("*Nurse Type : Doctor Helper :");
                    for(int e = 0; e<2; e++){
                        if(main.parts.get(q).nurses.get(t).nDocters[e]!= null){
                            System.out.println("    "+(e+1)+".Doctor "+main.parts.get(q).nurses.get(t).nDocters[e].docName+" , "+main.parts.get(q).nurses.get(t).nDocters[e].docPersonnelID +" :");
                            for(int ee = 0; ee<3; ee++){
                                System.out.println("        "+(ee+1)+"."+main.parts.get(q).nurses.get(t).nDocters[e].docCalender.week[ee][0]+" , "+main.parts.get(q).nurses.get(t).nDocters[e].docCalender.week[ee][1]);
                            }
                        }
                        else {
                            System.out.println("    "+(e+1)+".Null");
                        }
                    }
                    System.out.println("    You Can Change Nurse's Shifts by Changing Nurse's Doctors Shifts.");
                }
                if(main.parts.get(q).nurses.get(t).nurseType==NurseType.PartForce){
                    System.out.println("3.Nurse Type : Part Force :");
                    for(int e = 0; e<6; e++){
                        System.out.println("    "+(e+1)+"."+main.parts.get(q).nurses.get(t).nurseCalender.week[e][0]+" , "+main.parts.get(q).nurses.get(t).nurseCalender.week[e][1]);
                    }
                }
                int nursedata = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                if(nursedata == 1){
                    main.parts.get(q).nurses.get(t).nurseName = NurseR.setNurseName();
                }
                if(nursedata == 2){
                    main.parts.get(q).nurses.get(t).nursePersonnelID = NurseR.setPersonnelID();
                }
                if(nursedata == 3 && main.parts.get(q).nurses.get(t).nurseType==NurseType.PartForce ){
                    String[] shifts = NurseR.setNursePartForce(main,q);
                    main.parts.get(q).nurses.get(t).nurseCalender = new Calender(shifts[0],shifts[1],shifts[2],shifts[3],shifts[4],shifts[5]);

                }

            }
}
