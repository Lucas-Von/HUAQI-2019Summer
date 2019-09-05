package financial_management.util.PyInvoke.PyParam.bond;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/2 20:50
 * @Version 1.0
 **/
public class IndexPO {
    Float fund_cash;
    Float fund_bonds;
    List<TransPO> trans_record;
    List<BondsInfo> new_fund_info;


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

    public List<BondsInfo> getNew_fund_info() {
        return new_fund_info;
    }

    public void setNew_fund_info(List<BondsInfo> new_fund_info) {
        this.new_fund_info = new_fund_info;
    }

    public List<TransPO> getTrans_record() {
        return trans_record;
    }

    public void setTrans_record(List<TransPO> trans_record) {
        this.trans_record = trans_record;
    }
}
