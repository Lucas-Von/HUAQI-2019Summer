package financial_management.controller.property;

import financial_management.bl.property.EstateService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lt
 * @date 2019/08/20 16:43
 */
@CrossOrigin
@RestController
@RequestMapping("/property")
public class EstateController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EstateService estateService;

    @GetMapping("/estate/getOverview")
    public BasicResponse getOverviewByUser(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getOverviewByUser(userId);
    }

    @GetMapping("/estate/getProperty")
    public BasicResponse getPropertyByUser(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getPropertyByUser(userId);
    }

    @GetMapping("/estate/getFundsInfoList")
    public BasicResponse getFundsInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "funds");
    }

    @GetMapping("/estate/getSavingInfoList")
    public BasicResponse getSavingInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "saving");
    }

    @GetMapping("/estate/getInsuranceInfoList")
    public BasicResponse getInsuranceInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "insurance");
    }

    @GetMapping("/estate/getInvestmentInfoList")
    public BasicResponse getInvestmentInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "investment");
    }

    @GetMapping("/estate/getMonthlyProList")
    public BasicResponse getMonthlyProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMonthlyProList(userId);
    }

    @GetMapping("/estate/getMonthlyInvList")
    public BasicResponse getMonthlyInvList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMonthlyInvList(userId);
    }

    @GetMapping("/estate/getDailyProList")
    public BasicResponse getDailyProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getDailyProList(userId);
    }

    @GetMapping("/estate/getCompleteProList")
    public BasicResponse getCompleteProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getCompleteProList(userId);
    }

    @GetMapping("/estate/getDailyInvList")
    public BasicResponse getDailyInvList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getDailyInvList(userId);
    }

    @GetMapping("/estate/getMyRecAlloc")
    public BasicResponse getMyRecAlloc(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMyRecAlloc(userId);
    }

    @GetMapping("/income/getTotalIncome")
    public BasicResponse getTotalIncome(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getTotalIncome(userId);
    }

    @GetMapping("/income/getNewlyIncome")
    public BasicResponse getNewlyIncome(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getNewlyIncome(userId);
    }

    @GetMapping("/income/getAveNewlyRate")
    public BasicResponse getAveNewlyRate() {
        return estateService.getAveNewlyRate();
    }

    @GetMapping("/income/getAveTotalRate")
    public BasicResponse getAveTotalRate() {
        return estateService.getAveTotalRate();
    }

}
