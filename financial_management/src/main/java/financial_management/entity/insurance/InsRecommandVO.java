package financial_management.entity.insurance;

import java.util.List;

public class InsRecommandVO {
    List<InsuranceRecommandPO> husband ;
    List<InsuranceRecommandPO> wife;
    List<InsuranceRecommandPO> childOne;
    List<InsuranceRecommandPO> childTwo;
    List<InsuranceRecommandPO> childThree;
    List<InsuranceRecommandPO> childFour;
    List<InsuranceRecommandPO> elderOne;
    List<InsuranceRecommandPO> elderTwo;
    List<InsuranceRecommandPO> elderThree;
    List<InsuranceRecommandPO> elderFour;
    List<InsuranceRecommandPO> wholeFamily;

    public List<InsuranceRecommandPO> getHusband() {
        return husband;
    }

    public void setHusband(List<InsuranceRecommandPO> husband) {
        this.husband = husband;
    }

    public List<InsuranceRecommandPO> getWife() {
        return wife;
    }

    public void setWife(List<InsuranceRecommandPO> wife) {
        this.wife = wife;
    }

    public List<InsuranceRecommandPO> getChildOne() {
        return childOne;
    }

    public void setChildOne(List<InsuranceRecommandPO> childOne) {
        this.childOne = childOne;
    }

    public List<InsuranceRecommandPO> getChildTwo() {
        return childTwo;
    }

    public void setChildTwo(List<InsuranceRecommandPO> childTwo) {
        this.childTwo = childTwo;
    }

    public List<InsuranceRecommandPO> getChildThree() {
        return childThree;
    }

    public void setChildThree(List<InsuranceRecommandPO> childThree) {
        this.childThree = childThree;
    }

    public List<InsuranceRecommandPO> getChildFour() {
        return childFour;
    }

    public void setChildFour(List<InsuranceRecommandPO> childFour) {
        this.childFour = childFour;
    }

    public List<InsuranceRecommandPO> getElderOne() {
        return elderOne;
    }

    public void setElderOne(List<InsuranceRecommandPO> elderOne) {
        this.elderOne = elderOne;
    }

    public List<InsuranceRecommandPO> getElderTwo() {
        return elderTwo;
    }

    public void setElderTwo(List<InsuranceRecommandPO> elderTwo) {
        this.elderTwo = elderTwo;
    }

    public List<InsuranceRecommandPO> getElderThree() {
        return elderThree;
    }

    public void setElderThree(List<InsuranceRecommandPO> elderThree) {
        this.elderThree = elderThree;
    }

    public List<InsuranceRecommandPO> getElderFour() {
        return elderFour;
    }

    public void setElderFour(List<InsuranceRecommandPO> elderFour) {
        this.elderFour = elderFour;
    }

    public List<InsuranceRecommandPO> getWholeFamily() {
        return wholeFamily;
    }

    public void setWholeFamily(List<InsuranceRecommandPO> wholeFamily) {
        this.wholeFamily = wholeFamily;
    }

    public InsRecommandVO() {
    }

    public InsRecommandVO(List<InsuranceRecommandPO> husband, List<InsuranceRecommandPO> wife, List<InsuranceRecommandPO> childOne, List<InsuranceRecommandPO> childTwo, List<InsuranceRecommandPO> childThree, List<InsuranceRecommandPO> childFour, List<InsuranceRecommandPO> elderOne, List<InsuranceRecommandPO> elderTwo, List<InsuranceRecommandPO> elderThree, List<InsuranceRecommandPO> elderFour, List<InsuranceRecommandPO> wholeFamily) {
        this.husband = husband;
        this.wife = wife;
        this.childOne = childOne;
        this.childTwo = childTwo;
        this.childThree = childThree;
        this.childFour = childFour;
        this.elderOne = elderOne;
        this.elderTwo = elderTwo;
        this.elderThree = elderThree;
        this.elderFour = elderFour;
        this.wholeFamily = wholeFamily;
    }
}
