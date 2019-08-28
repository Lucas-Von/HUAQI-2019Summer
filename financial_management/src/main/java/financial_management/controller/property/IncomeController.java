package financial_management.controller.property;

import financial_management.bl.property.IncomeService;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lt
 * @date 2019/08/25 20:12
 */
@CrossOrigin
@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/income/getRecentProfitRate")
    public BasicResponse getRecentProfitRate(int days) {
        return incomeService.getRecentProfitRate(days);
    }

}
