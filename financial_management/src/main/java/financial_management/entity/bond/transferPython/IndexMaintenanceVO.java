package financial_management.entity.bond.transferPython;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 21:11
 * @Version 1.0
 **/
public class IndexMaintenanceVO {
    String product_name;
    Float fund_cash;
    Float fund_bonds;
    Float size_national;
    Float size_corporate;
    List<BondsInfo> bonds_info_national;
    List<BondsInfo> bonds_info_corporate;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public Float getSize_national() {
        return size_national;
    }

    public void setSize_national(Float size_national) {
        this.size_national = size_national;
    }

    public Float getSize_corporate() {
        return size_corporate;
    }

    public void setSize_corporate(Float size_corporate) {
        this.size_corporate = size_corporate;
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
}
