package financial_management.controller.property;

import financial_management.bl.property.ManageService;
import financial_management.entity.property.RecAllocPO;
import financial_management.parameter.property.RecAllocParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.RecAllocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        List<RecAllocPO> recAllocPOList = new ArrayList<>();
        List<RecAllocVO> recAllocVOList = new ArrayList<>();
        RecAllocPO recAllocPO1 = new RecAllocPO();
        recAllocPO1.setUserId(1L);
        recAllocPO1.setName("xyh");
        recAllocPO1.setIdentityNum("320684199809070018");
        recAllocPO1.setNick("xyhhh");
        recAllocPO1.setEmail("153604998@qq.com");
        recAllocPO1.setFundsRate(0.24);
        recAllocPO1.setSavingRate(0.32);
        recAllocPO1.setInsuranceRate(0.18);
        recAllocPO1.setInvestRate(0.26);
        RecAllocPO recAllocPO2 = new RecAllocPO();
        recAllocPO2.setUserId(2L);
        recAllocPO2.setName("xxyh");
        recAllocPO2.setIdentityNum("320684199809070019");
        recAllocPO2.setNick("xxyhhh");
        recAllocPO2.setEmail("153604998@qq.com");
        recAllocPO2.setFundsRate(0.14);
        recAllocPO2.setSavingRate(0.32);
        recAllocPO2.setInsuranceRate(0.18);
        recAllocPO2.setInvestRate(0.36);
        recAllocPOList.add(recAllocPO1);
        recAllocPOList.add(recAllocPO2);
        recAllocPOList.stream().forEach(recAllocPO -> {
            RecAllocVO recAllocVO = new RecAllocVO(recAllocPO.getUserId(), recAllocPO.getName(), recAllocPO.getIdentityNum(), recAllocPO.getNick(), recAllocPO.getEmail(), 800, recAllocPO.getFundsRate(), recAllocPO.getSavingRate(), recAllocPO.getInsuranceRate(), recAllocPO.getInvestRate());
            recAllocVOList.add(recAllocVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, recAllocVOList);
    }


    @GetMapping("/manage/getRecAlloc")
    public BasicResponse getRecAlloc(HttpServletRequest request) {
        RecAllocPO recAllocPO = new RecAllocPO();
        recAllocPO.setUserId(1L);
        recAllocPO.setName("xyh");
        recAllocPO.setIdentityNum("320684199809070018");
        recAllocPO.setNick("xyhhh");
        recAllocPO.setEmail("153604998@qq.com");
        recAllocPO.setFundsRate(0.24);
        recAllocPO.setSavingRate(0.32);
        recAllocPO.setInsuranceRate(0.18);
        recAllocPO.setInvestRate(0.26);
        RecAllocVO recAllocVO = new RecAllocVO(recAllocPO.getUserId(), recAllocPO.getName(), recAllocPO.getIdentityNum(), recAllocPO.getNick(), recAllocPO.getEmail(), 2380, recAllocPO.getFundsRate(), recAllocPO.getSavingRate(), recAllocPO.getInsuranceRate(), recAllocPO.getInvestRate());
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, recAllocVO);
    }

    @PostMapping("/manage/editRecAlloc")
    public BasicResponse editRecAlloc(@RequestBody RecAllocParam recAllocParam) {
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

}
