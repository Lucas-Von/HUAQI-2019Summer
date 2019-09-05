package financial_management.util.PyInvoke.PyParam.bond;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 20:49
 * @Version 1.0
 **/
public class DailyPurchasePO {
    Float fund_cash;
    Float fund_bonds;
    Float platform_accelerate_national;
    Float platform_accelerate_corporate;
    List<BondsInfo> bonds_info_national;
    List<BondsInfo> bonds_info_corporate;
    List<TransPO> trans_record_national;
    List<TransPO> trans_record_corporate;
    List<NewBond> price_list_national;
    List<NewBond> price_list_corporate;

    public List<NewBond> getPrice_list_national() {
        return price_list_national;
    }

    public void setPrice_list_national(List<NewBond> price_list_national) {
        this.price_list_national = price_list_national;
    }

    public List<NewBond> getPrice_list_corporate() {
        return price_list_corporate;
    }

    public void setPrice_list_corporate(List<NewBond> price_list_corporate) {
        this.price_list_corporate = price_list_corporate;
    }

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

    public List<TransPO> getTrans_record_national() {
        return trans_record_national;
    }

    public void setTrans_record_national(List<TransPO> trans_record_national) {
        this.trans_record_national = trans_record_national;
    }

    public List<TransPO> getTrans_record_corporate() {
        return trans_record_corporate;
    }

    public void setTrans_record_corporate(List<TransPO> trans_record_corporate) {
        this.trans_record_corporate = trans_record_corporate;
    }
}
