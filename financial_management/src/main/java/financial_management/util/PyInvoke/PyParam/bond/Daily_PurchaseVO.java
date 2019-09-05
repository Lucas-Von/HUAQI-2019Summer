package financial_management.util.PyInvoke.PyParam.bond;

import financial_management.util.PyInvoke.PyParam.PyParam;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 20:26
 * @Version 1.0
 **/
public class Daily_PurchaseVO extends PyParam {
    Float fund_cash;
    Float fund_bonds;
    Float platform_accelerate_national;
    Float platform_accelerate_corporate;
    List<BondsInfo> bonds_info_national;
    List<BondsInfo> bonds_info_corporate;

    public Float getFund_cash() {
        return fund_cash;
    }

    public void setFund_cash(Float fund_cash) {
        this.fund_cash = fund_cash;
    }

    public Float getFund_bonds() {
        return fund_bonds;
    }

    public void setFund_bonds(Float fund_bonds) {
        this.fund_bonds = fund_bonds;
    }

    public Float getPlatform_accelerate_national() {
        return platform_accelerate_national;
    }

    public void setPlatform_accelerate_national(Float platform_accelerate_national) {
        this.platform_accelerate_national = platform_accelerate_national;
    }

    public Float getPlatform_accelerate_corporate() {
        return platform_accelerate_corporate;
    }

    public void setPlatform_accelerate_corporate(Float platform_accelerate_corporate) {
        this.platform_accelerate_corporate = platform_accelerate_corporate;
    }

    public List<BondsInfo> getBonds_info_national() {
        return bonds_info_national;
    }

    public void setBonds_info_national(List<BondsInfo> bonds_info_national) {
        this.bonds_info_national = bonds_info_national;
    }

    public List<BondsInfo> getBonds_info_corporate() {
        return bonds_info_corporate;
    }

    public void setBonds_info_corporate(List<BondsInfo> bonds_info_corporate) {
        this.bonds_info_corporate = bonds_info_corporate;
    }

    public Daily_PurchaseVO() {
    }

    public Daily_PurchaseVO(Float fund_cash, Float fund_bonds, Float platform_accelerate_national, Float platform_accelerate_corporate, List<BondsInfo> bonds_info_national, List<BondsInfo> bonds_info_corporate) {
        this.fund_cash = fund_cash;
        this.fund_bonds = fund_bonds;
        this.platform_accelerate_national = platform_accelerate_national;
        this.platform_accelerate_corporate = platform_accelerate_corporate;
        this.bonds_info_national = bonds_info_national;
        this.bonds_info_corporate = bonds_info_corporate;
    }
}
