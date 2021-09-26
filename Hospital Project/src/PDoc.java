import java.time.LocalDate;
import java.time.LocalDateTime;

public class PDoc {




    public LocalDateTime getrDateTime() {
        return rDateTime;
    }

    public void setrDateTime(LocalDateTime rDateTime) {
        this.rDateTime = rDateTime;
    }

    public LocalDateTime gethDateTime() {
        return hDateTime;
    }

    public void sethDateTime(LocalDateTime hDateTime) {
        this.hDateTime = hDateTime;
    }

    private String pName;
    private String pCode = "";
    private Gender pGender ;
    private Insurance pInsurance ;
    private int pInsuranceNumb;
    private int pAge;
    private Doctor pDoctor = new Doctor();
    private int pDocNumb;
    private LocalDateTime rDateTime;
    private LocalDateTime hDateTime;
    private LocalDate hDate;
    private String pDocAddress ;
    public String getpDocAddress() {
        return pDocAddress;
    }

    public void setpDocAddress(String pDocAddress) {
        this.pDocAddress = pDocAddress;
    }

    public LocalDate gethDate() {
        return hDate;
    }

    public void sethDate(LocalDate hDate) {
        this.hDate = hDate;
    }

    private Sickness pSickness;
    //Factor pFactor = new Factor();
    private TypeReferral pTypeReferaal ;

    public int getDocPDocAddress() {
        return docPDocAddress;
    }

    public void setDocPDocAddress(int docPDocAddress) {
        this.docPDocAddress = docPDocAddress;
    }

    private int docPDocAddress ;

    public TypeReferral getpTypeReferaal() {
        return pTypeReferaal;
    }

    public void setpTypeReferaal(TypeReferral pTypeReferaal) {
        this.pTypeReferaal = pTypeReferaal;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public Gender getpGender() {
        return pGender;
    }

    public void setpGender(Gender pGender) {
        this.pGender = pGender;
    }

    public Insurance getpInsurance() {
        return pInsurance;
    }

    public void setpInsurance(Insurance pInsurance) {
        this.pInsurance = pInsurance;
    }

    public int getpInsuranceNumb() {
        return pInsuranceNumb;
    }

    public void setpInsuranceNumb(int pInsuranceNumb) {
        this.pInsuranceNumb = pInsuranceNumb;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public Doctor getpDoctor() {
        return pDoctor;
    }

    public void setpDoctor(Doctor pDoctor) {
        this.pDoctor = pDoctor;
    }

    public int getpDocNumb() {
        return pDocNumb;
    }

    public void setpDocNumb(int pDocNumb) {
        this.pDocNumb = pDocNumb;
    }

    public Sickness getpSickness() {
        return pSickness;
    }

    public void setpSickness(Sickness pSickness) {
        this.pSickness = pSickness;
    }

   // public Factor getpFactor() {
     //   return pFactor;
   // }

   // public void setpFactor(Factor pFactor) {
   //     this.pFactor = pFactor;
   // }
}
