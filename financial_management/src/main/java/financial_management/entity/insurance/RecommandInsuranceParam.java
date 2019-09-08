package financial_management.entity.insurance;

public class RecommandInsuranceParam {
    //在前面加abcdef的原因是为了保证按字典序传输的时候py能按需接收到参数
    Float aWifeBirthday;
    Float bHusbandBirthdat;
    Float cChildNumber;
    Float dElderNumber;
    Float eHusIncome;
    Float fWiftIncome;
    Float gCarprice;
    Float hConsumption;

    public Float getaWifeBirthday() {
        return aWifeBirthday;
    }

    public void setaWifeBirthday(Float aWifeBirthday) {
        this.aWifeBirthday = aWifeBirthday;
    }

    public Float getbHusbandBirthdat() {
        return bHusbandBirthdat;
    }

    public void setbHusbandBirthdat(Float bHusbandBirthdat) {
        this.bHusbandBirthdat = bHusbandBirthdat;
    }

    public Float getcChildNumber() {
        return cChildNumber;
    }

    public void setcChildNumber(Float cChildNumber) {
        this.cChildNumber = cChildNumber;
    }

    public Float getdElderNumber() {
        return dElderNumber;
    }

    public void setdElderNumber(Float dElderNumber) {
        this.dElderNumber = dElderNumber;
    }

    public Float geteHusIncome() {
        return eHusIncome;
    }

    public void seteHusIncome(Float eHusIncome) {
        this.eHusIncome = eHusIncome;
    }

    public Float getfWiftIncome() {
        return fWiftIncome;
    }

    public void setfWiftIncome(Float fWiftIncome) {
        this.fWiftIncome = fWiftIncome;
    }

    public Float getgCarprice() {
        return gCarprice;
    }

    public void setgCarprice(Float gCarprice) {
        this.gCarprice = gCarprice;
    }

    public Float gethConsumption() {
        return hConsumption;
    }

    public void sethConsumption(Float hConsumption) {
        this.hConsumption = hConsumption;
    }

    public RecommandInsuranceParam(Float aWifeBirthday, Float bHusbandBirthdat, Float cChildNumber, Float dElderNumber, Float eHusIncome, Float fWiftIncome, Float gCarprice, Float hConsumption) {
        this.aWifeBirthday = aWifeBirthday;
        this.bHusbandBirthdat = bHusbandBirthdat;
        this.cChildNumber = cChildNumber;
        this.dElderNumber = dElderNumber;
        this.eHusIncome = eHusIncome;
        this.fWiftIncome = fWiftIncome;
        this.gCarprice = gCarprice;
        this.hConsumption = hConsumption;
    }

    public RecommandInsuranceParam() {
    }
}
