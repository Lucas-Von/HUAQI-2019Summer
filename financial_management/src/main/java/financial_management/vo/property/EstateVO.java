package financial_management.vo.property;

public class EstateVO {

    /**
     * 用户资产总额
     */
    private double totalAsset;

    /**
     * 用户平台内现金数额
     */
    private double fundsInPlatform;

    /**
     * 用户平台外现金数额
     */
    private double fundsOutPlatform;

    /**
     * 用户平台内储蓄数额
     */
    private double savingInPlatform;

    /**
     * 用户平台外储蓄数额
     */
    private double savingOutPlatform;

    /**
     * 用户平台内保险数额
     */
    private double insuranceInPlatform;

    /**
     * 用户平台外保险数额
     */
    private double insuranceOutPlatform;

    /**
     * 用户的投资数额列表
     */
    private InvestOfEstateVO investOfEstateVO;

    public EstateVO(double fundsInPlatform, double fundsOutPlatform, double savingInPlatform, double savingOutPlatform, double insuranceInPlatform, double insuranceOutPlatform, InvestOfEstateVO investOfEstateVO) {
        this.fundsInPlatform = fundsInPlatform;
        this.fundsOutPlatform = fundsOutPlatform;
        this.savingInPlatform = savingInPlatform;
        this.savingOutPlatform = savingOutPlatform;
        this.insuranceInPlatform = insuranceInPlatform;
        this.insuranceOutPlatform = insuranceOutPlatform;
        this.investOfEstateVO = investOfEstateVO;
        this.totalAsset = fundsInPlatform + fundsOutPlatform + savingInPlatform + savingOutPlatform + insuranceInPlatform + insuranceOutPlatform
                + investOfEstateVO.getStocksInPlatform() + investOfEstateVO.getStocksOutPlatform() + investOfEstateVO.getGoldInPlatform()
                + investOfEstateVO.getGoldOutPlatform() + investOfEstateVO.getBondInPlatform() + investOfEstateVO.getBondOutPlatform();
    }

    public EstateVO() {

    }

    public double getTotalAsset() {
        return totalAsset;
    }

    public double getFundsInPlatform() {
        return fundsInPlatform;
    }

    public double getFundsOutPlatform() {
        return fundsOutPlatform;
    }

    public double getSavingInPlatform() {
        return savingInPlatform;
    }

    public double getSavingOutPlatform() {
        return savingOutPlatform;
    }

    public double getInsuranceInPlatform() {
        return insuranceInPlatform;
    }

    public double getInsuranceOutPlatform() {
        return insuranceOutPlatform;
    }

    public InvestOfEstateVO getInvestOfEstateVO() {
        return investOfEstateVO;
    }

}
