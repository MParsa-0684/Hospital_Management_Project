import java.util.ArrayList;

public class ShiftsChanging {
    public static void main(Hospital main) {
        ArrayList<Doctor> pDocsChanged1 = new ArrayList<>();
        ArrayList<Integer> pDocsChanged2 = new ArrayList<>();
        ArrayList<Nurse> pDocsChanged3 = new ArrayList<>();

        int m = 0;
        System.out.println("Which Part ?");
        System.out.println("* To choice an item , Please write it's number .");
        System.out.println("Parts :");
        for (int i = 0; i < main.parts.size(); i++) {
            System.out.println((i + 1) + "." + main.parts.get(i).name);
        }
        String[] weekDays = Calender.weekDays();
        int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
        for (int q = 0; q < main.parts.size(); q++) {
            if (var == q + 1) {
                System.out.println("Shifts :");
                System.out.println("1.Saturday");
                System.out.println("2.Sunday");
                System.out.println("3.Monday");
                System.out.println("4.Tuesday");
                System.out.println("5.Wednesday");
                System.out.println("6.Thursday ");
                System.out.println("7.Friday");
                m = 0;
                int vart =Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                if(vart ==0){
                    break;
                }
                System.out.println("Which one ?");
                System.out.println("1.Doctors");
                System.out.println("2.Part's Nurse Forces");
                var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                if(var ==1){
                    for(int y = 0; y<7; y++){
                        if(vart == y+1){
                            for(int p = 0; p<main.parts.get(q).doctors.size(); p++){
                                for(int t = 0; t<3; t++){
                                    if(main.parts.get(q).doctors.get(p).docCalender.week[t][0].equals(weekDays[y])){
                                        System.out.println(m+1+". Doctor "+main.parts.get(q).doctors.get(p).docName+" , "+main.parts.get(q).doctors.get(p).docPersonnelID +" : "+main.parts.get(q).doctors.get(p).docCalender.week[t][1]);
                                        pDocsChanged1.add(m,new Doctor());
                                        pDocsChanged1.set(m,main.parts.get(q).doctors.get(p));
                                        pDocsChanged2.add(m,new Integer(t));
                                        pDocsChanged2.set(m,t);

                                        m++;

                                    }

                                }
                            }

                            int vars = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                            for(int w = 0 ; w<m+1; w++){
                                if(vars == w+1){

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
                                    String varr = PatientHospitalization.getScanner().nextLine();
                                    System.out.println();
                                    String[] newShifts = varr.split(",");
                                    pDocsChanged1.get(w).docCalender.week[pDocsChanged2.get(w)][0] = Calender.weekly(Integer.parseInt(newShifts[0]));
                                    pDocsChanged1.get(w).docCalender.week[pDocsChanged2.get(w)][1] = Calender.shiftly(Integer.parseInt(newShifts[1]));
                                    break;

                                }
                            }
                        }
                    }
                    Calender.setNurseShifts(main,q);
                    break;
                }
                pDocsChanged2.clear();
                m = 0;
                if(var ==2){
                    for(int y = 0; y<7; y++){
                        if(vart == y+1){
                            for(int p = 0; p<main.parts.get(q).nurses.size(); p++){
                                for(int t = 0; t<6; t++){
                                    if(main.parts.get(q).nurses.get(p).nurseCalender.week[t][0].equals(weekDays[y]) && main.parts.get(q).nurses.get(p).nurseType==NurseType.PartForce){
                                        System.out.println(m+1+". Nurse "+main.parts.get(q).nurses.get(p).nurseName+" , "+main.parts.get(q).nurses.get(p).nursePersonnelID +" : "+main.parts.get(q).nurses.get(p).nurseCalender.week[t][1]);
                                        pDocsChanged3.add(m,new Nurse());
                                        pDocsChanged3.set(m,main.parts.get(q).nurses.get(p));
                                        pDocsChanged2.add(m,new Integer(t));
                                        pDocsChanged2.set(m,t);

                                        m++;

                                    }

                                }
                            }

                            int vars = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                            for(int w = 0 ; w<m+1; w++){
                                if(vars == w+1){

                                    System.out.println("Nurse's Shifts :");
                                    System.out.println("Days :           Day's Shifts :");
                                    System.out.println("1.Saturday       1.First Shift");
                                    System.out.println("2.Sunday         2.Second Shift");
                                    System.out.println("3.Monday         3.Third Shift");
                                    System.out.println("4.Tuesday");
                                    System.out.println("5.Wednesday");
                                    System.out.println("6.Thursday");
                                    System.out.println("7.Friday");
                                    System.out.println("To Enter this part,Please write like this :Days,Day's Shift ; For example :1,3 ==> This means Third shift in Saturday.");
                                    String varr = PatientHospitalization.getScanner().nextLine();
                                    System.out.println();
                                    String[] newShifts = varr.split(",");
                                    pDocsChanged3.get(w).nurseCalender.week[pDocsChanged2.get(w)][0] = Calender.weekly(Integer.parseInt(newShifts[0]));
                                    pDocsChanged3.get(w).nurseCalender.week[pDocsChanged2.get(w)][1] = Calender.shiftly(Integer.parseInt(newShifts[1]));
                                    break;

                                }
                            }
                        }
                    }

                    break;
                }
            }

            }
            }
}
