package financial_management.entity.stock;

import financial_management.util.PyInvoke.PyResponse.stock.QDIIAdjustment;

public class QDIIAdjustmentPO extends QDIIAdjustment {
    private Long userID;

    private Long transID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getTransID() {
        return transID;
    }

    public void setTransID(Long transID) {
        this.transID = transID;
    }

    public QDIIAdjustmentPO(String qdii_code, String name, Float share_deployed, Integer number_deployed, Float m_already_deployed, Float price_deployed) {
        super(qdii_code, name, share_deployed, number_deployed, m_already_deployed, price_deployed);
    }

    public QDIIAdjustmentPO(QDIIAdjustment qdiiAdjustment){
        super();
        this.setQdii_code(qdiiAdjustment.getQdii_code());
        this.setName(qdiiAdjustment.getName());
        this.setShare_deployed(qdiiAdjustment.getShare_deployed());
        this.setNumber_deployed(qdiiAdjustment.getNumber_deployed());
        this.setM_already_deployed(qdiiAdjustment.getM_already_deployed());
        this.setPrice_deployed(qdiiAdjustment.getPrice_deployed());
    }

    @Override
    public String toString() {
        return super.toString()
                + " 用户ID:" + userID
                + " 调仓ID:" + transID;
    }
}
