package financial_management.entity.insurance;

import java.util.List;

public class RecommandWrapperResponse {
    List<RecommandInsuranceResponse> responseList;

    public List<RecommandInsuranceResponse> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<RecommandInsuranceResponse> responseList) {
        this.responseList = responseList;
    }
}
