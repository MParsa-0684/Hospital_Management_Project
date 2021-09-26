public class DoctorR {
    public static void main(Hospital main) {
        System.out.println("Which Part does doctor belong to ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for (int q = 0; q < main.parts.size(); q++) {
            if (varr == q + 1) {
            DoctorR.setDoc(main,q);
            }
        }
    }
    public static void setDoc(Hospital main,int q){
        System.out.println("=> Enter the New Doctor's Information : ");
        main.parts.get(q).doctors.add(main.parts.get(q).doctors.size(), new Doctor());
        main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1).docName = DoctorR.setDocName();
        main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1).docPersonnelID = DoctorR.setDocPersonnelID();
        String[] var = DoctorR.setDocShifts();
        main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1).docCalender = new Calender(var[0],var[1],var[2]);
        int input = setDocPDocs();//3
        for(int e =0; e<input; e++){
            main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1).docPDocs.add(e,new PDoc());
        }
        setDocNurses(main,main.parts.get(q).doctors.get(main.parts.get(q).doctors.size() - 1));
        System.out.println();

    }
    public static String setDocName(){
        System.out.println("Full Name :");
         return PatientChanging.getScanner().nextLine();

    }
    public static String setDocPersonnelID(){
        System.out.println("Doctor's Personnel ID :");
         return PatientHospitalization.getScanner().nextLine();

    }
    public static String[] setDocShifts(){
        String[] var = new String[3];
        System.out.println("Doctor's Shifts :");
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
         var[0] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 2:");
        var[1] = PatientHospitalization.getScanner().nextLine();
        System.out.print("Shift 3:");
        var[2] = PatientHospitalization.getScanner().nextLine();
         return var;

    }
    public static int setDocPDocs (){
        System.out.println("How many Patients can this Doctor medicate ?");
        return Integer.parseInt(PatientHospitalization.getScanner().nextLine());
    }
    public static void setDocNurses(Hospital main,Doctor Doc) {
        int count=0;
        System.out.println("From Which Part do you want to select Nurse ?");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        int inputp = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        inputp = inputp-1;
        System.out.println("Part "+main.parts.get(inputp).name+"'s Nurses :");
        for(int n =0; n<main.parts.get(inputp).nurses.size(); n++){
            if(main.parts.get(inputp).nurses.get(n).nurseType == NurseType.DoctorsHelper){
                if(main.parts.get(inputp).nurses.get(n).nDocters[0] == null || main.parts.get(inputp).nurses.get(n).nDocters[1] == null){
                    System.out.println("    "+(n+1)+".Nurse "+main.parts.get(inputp).nurses.get(n).nurseName+" , "+main.parts.get(inputp).nurses.get(n).nursePersonnelID);
                    System.out.print("         The Doctor this Nurse Helps : ");
                    if(main.parts.get(inputp).nurses.get(n).nDocters[0] == null){
                        System.out.print("First Docotr : Null & "); }
                    else {
                        System.out.print("Fist Docotr : "+main.parts.get(inputp).nurses.get(n).nDocters[0].docName+" & "); }
                    if(main.parts.get(inputp).nurses.get(n).nDocters[1] == null){
                        System.out.println("Second Docotr : Null"); }
                    else {
                        System.out.println("Second Docotr : "+main.parts.get(inputp).nurses.get(n).nDocters[1].docName); }
                }
            }
        }

            System.out.println("Write Two Different Nurses like this : 1,3. This means that you chose Nurse Number 1 & Number 3.");
            System.out.println("If There is just a Nurse to choice  , Write Your next Nurse like this :1,0. This means that you chose Nurse Number 1 & No Nurse for Second Nurse.");
            System.out.println("Maybe There isn't any Nurse , You have to Write like this : 0,0.");
            //System.out.println("If there isn't any Nurse For you, or , At least one Nurse exists ,Write '000'.");
            String inputn = PatientHospitalization.getScanner().nextLine()+",";
            // 1        0
            //if(inputn.equals("000")){
            //  main.parts.get(inputp).emergencyDoctors.add(main.parts.get(inputp).emergencyDoctors.size(),Doc);
            //}
            String[] inputchoice = inputn.split(",");
            int[] inputChoice = new int[2];
            inputChoice[0] = Integer.parseInt(inputchoice[0]);
            inputChoice[1] = Integer.parseInt(inputchoice[1]);

            Nurse[] nurses = new Nurse[2];
        Doc.docNurses = nurses;
        System.out.println("This Doctor's Nurses :");
        if(inputChoice[0]!=0){
                    inputChoice[0] = inputChoice[0]-1;
                    nurses[0] = main.parts.get(inputp).nurses.get(inputChoice[0]);
                    for(int n=0; n<main.parts.get(inputp).nurses.get(inputChoice[0]).nDocters.length; n++){
                        if(main.parts.get(inputp).nurses.get(inputChoice[0]).nDocters[n] == null){
                            main.parts.get(inputp).nurses.get(inputChoice[0]).nDocters[n] = Doc;

                            break;
                        }
                    }
            System.out.println("    "+Doc.docNurses[0].nurseName+" , "+Doc.docNurses[0].nursePersonnelID);
                }
                else {
                    System.out.println("Your Fist Nurse is not Available . Your Fist Nurse will be Selected as soon as Another nurse is added.");
                count=1;
                }
                if(inputChoice[1]!=0){
                    inputChoice[1] = inputChoice[1]-1;
                    nurses[1] = main.parts.get(inputp).nurses.get(inputChoice[1]);
                    for(int n=0; n<main.parts.get(inputp).nurses.get(inputChoice[1]).nDocters.length; n++){
                        if(main.parts.get(inputp).nurses.get(inputChoice[1]).nDocters[n] == null){
                            main.parts.get(inputp).nurses.get(inputChoice[1]).nDocters[n] = Doc;
                            break;
                        }
                    }
                    System.out.println("    "+Doc.docNurses[1].nurseName+" , "+Doc.docNurses[1].nursePersonnelID);
                }
                else {
                    System.out.println("Your Second Nurse is not Available . Your Second Nurse will be Selected as soon as Another nurse is added.");
               count=1;
                }
                if(count ==1){
                    main.parts.get(inputp).emergencyDoctors.add(main.parts.get(inputp).emergencyDoctors.size(),Doc);
                }
                System.out.println();






            }
}
