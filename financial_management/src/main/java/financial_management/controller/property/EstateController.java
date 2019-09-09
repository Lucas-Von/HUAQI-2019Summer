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

    @GetMapping(value = "/estate/getOverview")
    public BasicResponse getOverviewByUser(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getOverviewByUser(userId);
    }

    @GetMapping(value = "/estate/getProperty")
    public BasicResponse getPropertyByUser(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getPropertyByUser(userId);
    }

    @GetMapping(value = "/estate/getFundsInfoList")
    public BasicResponse getFundsInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "funds");
    }

    @GetMapping(value = "/estate/getSavingInfoList")
    public BasicResponse getSavingInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "saving");
    }

    @GetMapping(value = "/estate/getInsuranceInfoList")
    public BasicResponse getInsuranceInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "insurance");
    }

    @GetMapping(value = "/estate/getInvestmentInfoList")
    public BasicResponse getInvestmentInfoList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getAssetInfoList(userId, "investment");
    }

    @GetMapping(value = "/estate/getMonthlyProList")
    public BasicResponse getMonthlyProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMonthlyProList(userId);
    }

    @GetMapping(value = "/estate/getMonthlyInvList")
    public BasicResponse getMonthlyInvList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMonthlyInvList(userId);
    }

    @GetMapping(value = "/estate/getDailyProList")
    public BasicResponse getDailyProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getDailyProList(userId);
    }

    @GetMapping(value = "/estate/getDailyInvList")
    public BasicResponse getDailyInvList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getDailyInvList(userId);
    }

    @GetMapping(value = "/estate/getCompleteProList")
    public BasicResponse getCompleteProList(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getCompleteProList(userId);
    }

    @GetMapping(value = "/estate/hasImproveInfo")
    public BasicResponse hasImproveInfo(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.hasImproveInfo(userId);
    }

    @GetMapping(value = "/estate/getMyRecAlloc")
    public BasicResponse getMyRecAlloc(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getMyRecAlloc(userId);
    }

    @PostMapping(value = "/estate/setFundsOutPlatform")
    public BasicResponse setFundsOutPlatform(HttpServletRequest request, @RequestParam double fundsOutPlatform) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.setFundsOutPlatform(userId, fundsOutPlatform);
    }

    @PostMapping(value = "/estate/delFundsOutPlatform")
    public BasicResponse delFundsOutPlatform(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.delFundsOutPlatform(userId);
    }

    @GetMapping(value = "/estate/getFundsOutPlatform")
    public BasicResponse getFundsOutPlatform(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getFundsOutPlatform(userId);
    }

    @PostMapping(value = "/estate/setInvestOutPlatform")
    public BasicResponse setInvestOutPlatform(HttpServletRequest request, @RequestParam double investOutPlatform) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.setInvestOutPlatform(userId, investOutPlatform);
    }

    @PostMapping(value = "/estate/delInvestOutPlatform")
    public BasicResponse delInvestOutPlatform(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.delInvestOutPlatform(userId);
    }

    @GetMapping(value = "/estate/getInvestOutPlatform")
    public BasicResponse getInvestOutPlatform(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return estateService.getInvestOutPlatform(userId);
    }

}
