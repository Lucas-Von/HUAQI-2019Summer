package financial_management.util.PyInvoke.PyResponse.stock;

import financial_management.util.NumberFormatter;

public class QDIIAdjustment {
    private String qdii_code;
    private String name;
    private Float share_deployed;
    private Integer number_deployed;
    private Float m_already_deployed;
    private Float price_deployed;

    public String getQdii_code() {
        return qdii_code;
    }

    public void setQdii_code(String qdii_code) {
        this.qdii_code = qdii_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber_deployed() {
        return number_deployed;
    }

    public void setNumber_deployed(Integer number_deployed) {
        this.number_deployed = number_deployed;
    }

    public Float getM_already_deployed() {
        return m_already_deployed;
    }

    public void setM_already_deployed(Float m_already_deployed) {
        this.m_already_deployed = m_already_deployed;
    }

    public Float getPrice_deployed() {
        return price_deployed;
    }

    public void setPrice_deployed(Float price_deployed) {
        this.price_deployed = price_deployed;
    }


    public Float getShare_deployed() {
        return share_deployed;
    }

    public void setShare_deployed(Float share_deployed) {
        this.share_deployed = share_deployed;
    }

    public QDIIAdjustment(String qdii_code, String name, Float share_deployed, Integer number_deployed, Float m_already_deployed, Float price_deployed) {
        this.qdii_code = qdii_code;
        this.name = name;
        this.share_deployed = share_deployed;
        this.number_deployed = number_deployed;
        this.m_already_deployed = m_already_deployed;
        this.price_deployed = price_deployed;
    }

    public QDIIAdjustment() {
    }

    @Override
    public String toString() {
        return qdii_code
                + " " + name
                + " 调整份额:" + NumberFormatter.formatFloat2String(share_deployed)
                + " 调整份数:" + number_deployed
                + " 调整金额:" + NumberFormatter.formatFloat2String(m_already_deployed)
                + " 市价:" + NumberFormatter.formatFloat2String(price_deployed);
    }
}
