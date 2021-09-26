public class PatientChanging extends PatientHospitalization {
    public static void main(Hospital main) {
        while (true) {
            System.out.println("Inpatient Part,Room,Bed to Change :");
            System.out.println("* To choice an item , Please write it's number .");
            System.out.println("Parts :");
            for (int i = 0; i < main.parts.size(); i++) {
                System.out.println((i + 1) + "." + main.parts.get(i).name);
            }
            int varr = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
            for (int q = 0; q < main.parts.size(); q++) {
                if (varr == q + 1) {
                    System.out.println(main.parts.get(q).name + " Part's Rooms :");
                    for (int i = 0; i < main.parts.get(q).rooms.length; i++) {
                        System.out.println((i + 1) + ".Room " + (q + 1) + "0" + i);
                    }
                    int var = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                    for (int i = 1; i <= main.parts.get(q).rooms.length; i++) {
                        if (var == (i)) {
                            System.out.println("Room " + (q + 1) + "0" + (i - 1) + "'s Beds :");
                            setBedContinue(main,q,i);
                            break;

                        }
                        }

                    }
                }
                break;
            }
        System.out.println();
        }
        public static void setBedContinue (Hospital main,int q,int i){
            for (int ii = 0; ii < main.parts.get(q).rooms[i - 1].roomBeds.size(); ii++) {
                System.out.print((ii + 1) + ".Bed " + (q + 3) + "4" + ii);
                if (main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed == null) {
                    System.out.println("  ==> *Empty*");
                } else {
                    System.out.println("  ==> " + main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed.getpName() + " , " + main.parts.get(q).rooms[i - 1].roomBeds.get(ii).patientDocBed.getpCode());
                }
            }
            System.out.println("To choice again the Patient's Bed, Enter '000'");
            int varc = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
            if (varc == 000) {

            }
            else {
                for (int iii = 1; iii <= main.parts.get(q).rooms[i-1].roomBeds.size(); iii++) {
                    if (varc == iii ) {
                        if(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed != null){
                        System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpName() + "'s Information :");
                        System.out.println("    * To choice an item , Please write it's number .");
                        System.out.print("    1.Name : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpName() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpName());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    2.Code : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpCode() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpCode());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    3.Referral Time : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getrDateTime() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getrDateTime().toString());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.println("    * Document's Number : " + main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDocNumb());
                        System.out.println("    * Hospitalization Time (UnChangeable) : " + main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.gethDateTime().toString());
                        System.out.print("    4.Sickness : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpSickness() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpSickness().toString());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    5.Insurance : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpInsurance() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpInsurance().toString());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    6.Gender : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpGender() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpGender().toString());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    7.Age : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpAge() != 0) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpAge());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    8.Doctor : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDoctor() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDoctor().docName + " , " + main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDoctor().docPersonnelID);
                        } else {
                            System.out.println("Null");
                        }
                        System.out.print("    9.Type Referral : ");
                        if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpTypeReferaal() != null) {
                            System.out.println(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpTypeReferaal().toString());
                        } else {
                            System.out.println("Null");
                        }
                        System.out.println("    10.Bed (Address) : " + main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDocAddress());
                        varc = Integer.parseInt(PatientHospitalization.getScanner().nextLine());
                        if (varc == 1) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpName(PatientHospitalization.setpName());
                        }
                        if (varc == 2) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpCode(PatientHospitalization.setpCode());
                        }
                        if (varc == 3) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setrDateTime(PatientHospitalization.setrDateTime());
                        }
                        if (varc == 4) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpSickness(PatientHospitalization.setpSickness());
                        }
                        if (varc == 5) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpInsurance(PatientHospitalization.setpInsurance());
                        }
                        if (varc == 6) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpGender(PatientHospitalization.setpGender());
                        }
                        if (varc == 7) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpAge(PatientHospitalization.setPAge());
                        }
                        if (varc == 8) {
                            if (main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDoctor() != null) {
                                main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getpDoctor().docPDocs.set(main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.getDocPDocAddress(), new PDoc());

                            }
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpDoctor(PatientHospitalization.setPDoctor(main, main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed));
                        }
                        if (varc == 9) {
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed.setpTypeReferaal(PatientHospitalization.setpTypeReferaal());
                        }
                        if (varc == 10) {
                            PatientHospitalization.setPBed(main, main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed);
                            main.parts.get(q).rooms[i - 1].roomBeds.get(iii - 1).patientDocBed = null;
                        }
                    }
                        else {
                            System.out.println("No Patient !!");
                            break;
                        }
                    }

                    }
                }
            }
        }



