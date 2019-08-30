package financial_management.controller.product;

import financial_management.bl.product.GoldService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xyh
 * @date 2019/8/30
 */
@CrossOrigin
@RestController
@RequestMapping("/gold")
public class GoldController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private GoldService goldService;

    @PostMapping(value = "/user/buy")
    public BasicResponse buyGold(@RequestParam Double money, HttpServletRequest request){
        return goldService.buyGold(money, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/user/sell")
    public BasicResponse sellGold(@RequestParam Double money, HttpServletRequest request){
        return goldService.sellGold(money, jwtUtil.getIdFromRequest(request));
    }

    @GetMapping(value = "/history/get")
    public BasicResponse getHistoryConfig(HttpServletRequest request){
        return goldService.getHistoryConfig(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping(value = "/now/get")
    public BasicResponse getNowConfig(HttpServletRequest request){
        return goldService.getNowConfig(jwtUtil.getIdFromRequest(request));
    }
}
