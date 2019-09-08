package financial_management.entity.insurance;

public class InsuranceRecommandPO extends RecommandInsuranceResponse {
    Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
