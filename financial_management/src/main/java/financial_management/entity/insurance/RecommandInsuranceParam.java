package financial_management.entity.insurance;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class RecommandInsuranceParam extends PyParam {
    //在前面加abcdef的原因是为了保证按字典序传输的时候py能按需接收到参数
    Integer aWifeBirthday;
    Integer bHusbandBirthdat;
    Float cChildNumber;
    Float dElderNumber;
    Float eHusIncome;
    Float fWiftIncome;
    Float gCarprice;
    Float hConsumption;

    public Integer getaWifeBirthday() {
        return aWifeBirthday;
    }

    public void setaWifeBirthday(Integer aWifeBirthday) {
        this.aWifeBirthday = aWifeBirthday;
    }

    public Integer getbHusbandBirthdat() {
        return bHusbandBirthdat;
    }

    public void setbHusbandBirthdat(Integer bHusbandBirthdat) {
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

    public RecommandInsuranceParam(Integer aWifeBirthday, Integer bHusbandBirthdat, Float cChildNumber, Float dElderNumber, Float eHusIncome, Float fWiftIncome, Float gCarprice, Float hConsumption) {
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
