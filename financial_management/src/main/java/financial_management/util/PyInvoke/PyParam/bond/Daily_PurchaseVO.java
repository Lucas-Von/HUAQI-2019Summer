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
    Float f_fund_cash;
    Float e_fund_bonds;
    Float d_platform_accelerate_national;
    Float c_platform_accelerate_corporate;
    List<BondsInfo> b_bonds_info_national;
    List<BondsInfo> a_bonds_info_corporate;

    public Float getF_fund_cash() {
        return f_fund_cash;
    }

    public void setF_fund_cash(Float f_fund_cash) {
        this.f_fund_cash = f_fund_cash;
    }

    public Float getE_fund_bonds() {
        return e_fund_bonds;
    }

    public void setE_fund_bonds(Float e_fund_bonds) {
        this.e_fund_bonds = e_fund_bonds;
    }

    public Float getD_platform_accelerate_national() {
        return d_platform_accelerate_national;
    }

    public void setD_platform_accelerate_national(Float d_platform_accelerate_national) {
        this.d_platform_accelerate_national = d_platform_accelerate_national;
    }

    public Float getC_platform_accelerate_corporate() {
        return c_platform_accelerate_corporate;
    }

    public void setC_platform_accelerate_corporate(Float c_platform_accelerate_corporate) {
        this.c_platform_accelerate_corporate = c_platform_accelerate_corporate;
    }

    public List<BondsInfo> getB_bonds_info_national() {
        return b_bonds_info_national;
    }

    public void setB_bonds_info_national(List<BondsInfo> b_bonds_info_national) {
        this.b_bonds_info_national = b_bonds_info_national;
    }

    public List<BondsInfo> getA_bonds_info_corporate() {
        return a_bonds_info_corporate;
    }

    public void setA_bonds_info_corporate(List<BondsInfo> a_bonds_info_corporate) {
        this.a_bonds_info_corporate = a_bonds_info_corporate;
    }

    public Daily_PurchaseVO() {
    }

    public Daily_PurchaseVO(Float fund_cash, Float fund_bonds, Float platform_accelerate_national, Float platform_accelerate_corporate, List<BondsInfo> bonds_info_national, List<BondsInfo> a_bonds_info_corporate) {
        this.f_fund_cash = fund_cash;
        this.e_fund_bonds = fund_bonds;
        this.d_platform_accelerate_national = platform_accelerate_national;
        this.c_platform_accelerate_corporate = platform_accelerate_corporate;
        this.b_bonds_info_national = bonds_info_national;
        this.a_bonds_info_corporate = a_bonds_info_corporate;
    }
}
