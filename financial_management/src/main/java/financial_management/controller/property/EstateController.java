package financial_management.controller.property;

import financial_management.bl.property.EstateService;
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


}
