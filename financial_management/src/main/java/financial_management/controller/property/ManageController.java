package financial_management.controller.property;

import financial_management.bl.property.ManageService;
import financial_management.parameter.property.RecAllocParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lt
 * @date 2019/08/23 00:19
 */
@CrossOrigin
@RestController
@RequestMapping("/property")
public class ManageController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ManageService manageService;

    @GetMapping("/manage/getRecAllocList")
    public BasicResponse getRecAllocList(HttpServletRequest request) {
        Long adminId = jwtUtil.getIdFromRequest(request);
        return manageService.getRecAllocList(adminId);
    }


    @GetMapping("/manage/getRecAlloc")
    public BasicResponse getRecAlloc(@RequestParam Long userId) {
        return manageService.getRecAlloc(userId);
    }

    @PostMapping("/manage/editRecAlloc")
    public BasicResponse editRecAlloc(@RequestBody RecAllocParam recAllocParam) {
        return manageService.editRecAlloc(recAllocParam);
    }

}
