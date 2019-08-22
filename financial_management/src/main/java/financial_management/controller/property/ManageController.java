package financial_management.controller.property;

import financial_management.bl.property.ManageService;
import financial_management.parameter.property.RecAllocParam;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lt
 * @date 2019/08/23 00:19
 */
@RestController
@RequestMapping("/property")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @GetMapping("/manage/getRecAllocList")
    public BasicResponse getRecAllocList(Long adminId) {
        return manageService.getRecAllocList(adminId);
    }


    @GetMapping("/manage/getRecAlloc")
    public BasicResponse getRecAlloc(long userId) {
        return manageService.getRecAlloc(userId);
    }

    @PostMapping("/manage/editRecAlloc")
    public BasicResponse editRecAlloc(@RequestBody RecAllocParam recAllocParam) {
        return manageService.editRecAlloc(recAllocParam);
    }

}
