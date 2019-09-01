package financial_management.util.PyInvoke.PyResponse.stock;

public class StockAdjustment {
    private String stock_code;
    private String stockname;
    private Integer account_deployed_change;
    private Float m_already_deployed;
    private Float price_deployed;

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public Integer getAccount_deployed_change() {
        return account_deployed_change;
    }

    public void setAccount_deployed_change(Integer account_deployed_change) {
        this.account_deployed_change = account_deployed_change;
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

    public StockAdjustment(String stock_code, String stockname, Integer account_deployed_change, Float m_already_deployed, Float price_deployed) {
        this.stock_code = stock_code;
        this.stockname = stockname;
        this.account_deployed_change = account_deployed_change;
        this.m_already_deployed = m_already_deployed;
        this.price_deployed = price_deployed;
    }

    public StockAdjustment() {
    }
}
