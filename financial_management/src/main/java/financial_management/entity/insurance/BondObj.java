package financial_management.entity.insurance;

public class BondObj {
    private String product;
    private String code;
    private float rate;

    public BondObj(String product, String code, float rate) {
        this.product = product;
        this.code = code;
        this.rate = rate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
