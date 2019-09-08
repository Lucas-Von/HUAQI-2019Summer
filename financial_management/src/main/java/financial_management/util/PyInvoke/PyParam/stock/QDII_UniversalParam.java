package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

import java.util.List;

public class QDII_UniversalParam extends PyParam {
    private float target;
    private float sum;
    private int num;
    private List<List<Object>> hold;

    public float getTarget() {
        return target;
    }

    public void setTarget(float target) {
        this.target = target;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<List<Object>> getHold() {
        return hold;
    }

    public void setHold(List<List<Object>> hold) {
        this.hold = hold;
    }

    public QDII_UniversalParam(float target, float sum, int num, List<List<Object>> hold) {
        this.target = target;
        this.sum = sum;
        this.num = num;
        this.hold = hold;
    }
}
