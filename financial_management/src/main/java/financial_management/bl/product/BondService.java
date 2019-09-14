package financial_management.bl.product;

import financial_management.vo.BasicResponse;

public interface BondService {

    BasicResponse getInfo(String name);

    BasicResponse getFundInfo(String name);

    BasicResponse exponent(String name);

    BasicResponse userInfo(Long info);

    BasicResponse adjustWarehouse(Long userId,Float amount);
}
