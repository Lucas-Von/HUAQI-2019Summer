package financial_management.entity.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/29 22:03
 * @Version 1.0
 **/
public class BondPlatformPO {

    Float residualAssets;
    Float bondAssets;
    Float handlingFee;

    public Float getResidualAssets() {
        return residualAssets;
    }

    public void setResidualAssets(Float residualAssets) {
        this.residualAssets = residualAssets;
    }

    public Float getBondAssets() {
        return bondAssets;
    }

    public void setBondAssets(Float bondAssets) {
        this.bondAssets = bondAssets;
    }

    public Float getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(Float handlingFee) {
        this.handlingFee = handlingFee;
    }
}
