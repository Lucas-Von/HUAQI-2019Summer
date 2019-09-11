package financial_management.bl.product;

import financial_management.vo.BasicResponse;

public interface BondService {

    BasicResponse getFundInfo(String name);
}
