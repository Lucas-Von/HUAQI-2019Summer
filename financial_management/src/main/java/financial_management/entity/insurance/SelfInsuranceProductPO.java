package financial_management.entity.insurance;

import java.util.Date;

public class SelfInsuranceProductPO {
    Long id;
    //用户id
    Long userId;
    //受保人
    String beneficiary;
    //保险类型
    String kind;
    //过期时间
    Date maturity;
    //保费
    Float amount;
    //保额
    Float premiun;
    //保险名称
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPremiun() {
        return premiun;
    }

    public void setPremiun(Float premiun) {
        this.premiun = premiun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelfInsuranceProductPO(Long userId, String beneficiary, String kind, Date maturity, Float amount, Float premiun, String name) {
        this.userId = userId;
        this.beneficiary = beneficiary;
        this.kind = kind;
        this.maturity = maturity;
        this.amount = amount;
        this.premiun = premiun;
        this.name = name;
    }

    public SelfInsuranceProductPO() {
    }
}
