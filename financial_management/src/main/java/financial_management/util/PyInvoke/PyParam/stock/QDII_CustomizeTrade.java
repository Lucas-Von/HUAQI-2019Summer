package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class QDII_CustomizeTrade extends PyParam {
    private String code;

    private int number;

    private float share;

    private float money;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public QDII_CustomizeTrade(String code, int number, float share, float money) {
        this.code = code;
        this.number = number;
        this.share = share;
        this.money = money;
    }

    public QDII_CustomizeTrade() {
    }
}
