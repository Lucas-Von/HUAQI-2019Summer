package financial_management.entity.insurance;

public class RecommandInsuranceResponse {
    String role;
    String kind;
    Float insurance_amount;
    Float insurance_premiun;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Float getInsurance_amount() {
        return insurance_amount;
    }

    public void setInsurance_amount(Float insurance_amount) {
        this.insurance_amount = insurance_amount;
    }

    public Float getInsurance_premiun() {
        return insurance_premiun;
    }

    public void setInsurance_premiun(Float insurance_premiun) {
        this.insurance_premiun = insurance_premiun;
    }
}
