package financial_management.controller.property;

import financial_management.bl.property.EstateService;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lt
 * @date 2019/08/20 16:43
 */
@RestController
@RequestMapping("/property")
public class EstateController {

    @Autowired
    private EstateService estateService;

    @GetMapping("estate/getProperty")
    public BasicResponse getPropertyByUser(Long userId) {
        return estateService.getPropertyByUser(userId);
    }

    @GetMapping("/estate/getTotalIncome")
    public BasicResponse getTotalIncome(Long userId) {
        return estateService.getTotalIncome(userId);
    }

    @GetMapping("estate/getNewlyIncome")
    public BasicResponse getNewlyIncome(Long userId) {
        return estateService.getNewlyIncome(userId);
    }

    @GetMapping("estate/getDepositList")
    public BasicResponse getDepositList(Long userId) {
        return estateService.getDepositList(userId);
    }

    @GetMapping("estate/getAssetInfoList")
    public BasicResponse getAssetInfoList(Long userId, String assetType) {
        return estateService.getAssetInfoList(userId, assetType);
    }

    @GetMapping("estate/getMonthlyProList")
    public BasicResponse getMonthlyProList(Long userId) {
        return estateService.getMonthlyProList(userId);
    }

    @GetMapping("estate/getMonthlyInvList")
    public BasicResponse getMonthlyInvList(Long userId) {
        return estateService.getMonthlyInvList(userId);
    }

    @GetMapping("estate/getDailyProList")
    public BasicResponse getDailyProList(Long userId) {
        return estateService.getDailyProList(userId);
    }

    @GetMapping("estate/getDailyInvList")
    public BasicResponse getDailyInvList(Long userId) {
        return estateService.getDailyInvList(userId);
    }

}
