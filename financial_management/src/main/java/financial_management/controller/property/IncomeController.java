package financial_management.controller.property;

import financial_management.bl.property.IncomeService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lt
 * @date 2019/09/03 19:25
 */
@CrossOrigin
@RestController
@RequestMapping("/property")
public class IncomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IncomeService incomeService;

    @GetMapping(value = "/income/getTotalIncome")
    public BasicResponse getTotalIncome(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return incomeService.getTotalIncome(userId);
    }

    @GetMapping(value = "/income/getNewlyIncome")
    public BasicResponse getNewlyIncome(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return incomeService.getNewlyIncome(userId);
    }

    @GetMapping(value = "/income/getIncomeRateList")
    public BasicResponse getIncomeRateList(@RequestParam int days) {
        return incomeService.getIncomeRateList(days);
    }

    @GetMapping(value = "/income/getAveNewlyRate")
    public BasicResponse getAveNewlyRate() {
        return incomeService.getAveNewlyRate();
    }

    @GetMapping(value = "/income/getAveTotalRate")
    public BasicResponse getAveTotalRate() {
        return incomeService.getAveTotalRate();
    }

}