package financial_management.util.PyInvoke.PyParam.bond;

import financial_management.util.PyInvoke.PyParam.PyParam;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/2 20:50
 * @Version 1.0
 **/
public class IndexVO extends PyParam {
    String product_name;
    Float fund_cash;
    Float fund_bonds;
    List<BondsInfo> bonds_info_national;
    List<BondsInfo> bonds_info_corporate;
    Float size_national;
    Float size_corporate;
    List<NewFundInfo> new_fund_info;

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

    public List<NewFundInfo> getNew_fund_info() {
        return new_fund_info;
    }

    public void setNew_fund_info(List<NewFundInfo> new_fund_info) {
        this.new_fund_info = new_fund_info;
    }

    public IndexVO() {
    }

    public IndexVO(String product_name, Float fund_cash, Float fund_bonds, List<BondsInfo> bonds_info_national, List<BondsInfo> bonds_info_corporate, Float size_national, Float size_corporate, List<NewFundInfo> new_fund_info) {
        this.product_name = product_name;
        this.fund_cash = fund_cash;
        this.fund_bonds = fund_bonds;
        this.bonds_info_national = bonds_info_national;
        this.bonds_info_corporate = bonds_info_corporate;
        this.size_national = size_national;
        this.size_corporate = size_corporate;
        this.new_fund_info = new_fund_info;
    }
}
