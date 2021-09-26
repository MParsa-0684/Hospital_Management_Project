    import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.Locale;

public class Calender {
    String[][] week ;
    public Calender(String shift1,String shift2,String shift3){
        week = new String[3][2];
        shift1.toLowerCase(Locale.ROOT);
        shift2.toLowerCase(Locale.ROOT);
        shift3.toLowerCase(Locale.ROOT);
        shift1 = shift1+","+shift2+","+shift3+",";
        String[] shiftT = shift1.split(",");
        int[] shifts = new int[shiftT.length];
        for (int i = 0; i<6; i++){
            if(shiftT[i].equals("")){
                shiftT[i]="0";
            }
            shifts[i] = Integer.parseInt(shiftT[i]);
        }
        week[0][0]= weekly(shifts[0]);
        week[0][1]= shiftly(shifts[1]);
        week[1][0]= weekly(shifts[2]);
        week[1][1]= shiftly(shifts[3]);
        week[2][0]= weekly(shifts[4]);
        week[2][1]= shiftly(shifts[5]);

    }

    public static String weekly(int week) {
        if (week == 1) {
            return ("Saturday");
        }
        if (week == 2) {
            return ("Sunday");
        }
        if (week == 3) {
            return ("Monday");
        }
        if (week == 4) {
            return ("Tuesday");
        }
        if (week == 5) {
            return ("Wednesday");
        }
        if (week == 6) {
            return ("Thursday");
        }
        if (week == 7) {
            return ("Friday");
        }
        return null;
    }
    public static String shiftly(int shift) {

        if (shift == 1) {
            return "First Shift";
        }
        if (shift == 2) {
            return "Second Shift";
        }
        if (shift == 3) {
            return "Third Shift";

        }
        return null;

    }
    public Calender(String shift1,String shift2,String shift3,String shift4,String shift5,String shift6){
        week = new String[6][2];
        shift1.toLowerCase(Locale.ROOT);
        shift2.toLowerCase(Locale.ROOT);
        shift3.toLowerCase(Locale.ROOT);
        shift4.toLowerCase(Locale.ROOT);
        shift5.toLowerCase(Locale.ROOT);
        shift6.toLowerCase(Locale.ROOT);
        String shift=shift1+","+shift2+","+shift3+","+shift4+","+shift5+","+shift6+",";
        String[] shiftT = shift.split(",");
        int[] shifts = new int[shiftT.length];
        for (int i = 0; i<12; i++){
            if(shiftT[i].equals("")){
                shiftT[i]="0";
            }
            shifts[i] = Integer.parseInt(shiftT[i]);
        }
        week[0][0]= weekly(shifts[0]);
        week[0][1]= shiftly(shifts[1]);
        week[1][0]= weekly(shifts[2]);
        week[1][1]= shiftly(shifts[3]);
        week[2][0]= weekly(shifts[4]);
        week[2][1]= shiftly(shifts[5]);
        week[3][0]= weekly(shifts[6]);
        week[3][1]= shiftly(shifts[7]);
        week[4][0]= weekly(shifts[8]);
        week[4][1]= shiftly(shifts[9]);
        week[5][0]= weekly(shifts[10]);
        week[5][1]= shiftly(shifts[11]);


    }
    public Calender(String[][] i,String[][] ii){
        week = new String[6][2];
        for(int e = 0; e < 3; e++){
            week[e][0] = i[e][0];
            week[e][1] = i[e][1];

        }
        int ee = 0;
        for(int e = 3; e < 6; e++){
            week[e][0] = ii[ee][0];
            week[e][1] = ii[ee][1];
            ee++;
        }
    }
    public static String[] weekDays(){
        String[] weekdays = new String[7];
        weekdays[0] = "Saturday";
        weekdays[1] = "Sunday";
        weekdays[2] = "Monday";
        weekdays[3] = "Tuesday";
        weekdays[4] = "Wednesday";
        weekdays[5] = "Thursday";
        weekdays[6] = "Friday";
        return weekdays;
    }
    public static void setNurseShifts(Hospital main,int q){
        for(int p = 0; p<main.parts.size(); p++){
            if(q == p){
                for(int t =0; t<main.parts.get(p).nurses.size();t++ ){
                    if(main.parts.get(p).nurses.get(t).nurseType == NurseType.DoctorsHelper){
                        main.parts.get(p).nurses.get(t).nurseCalender = new Calender(main.parts.get(p).nurses.get(t).nDocters[0].docCalender.week,main.parts.get(p).nurses.get(t).nDocters[1].docCalender.week);
                    }
                }
            }
        }
    }
}

