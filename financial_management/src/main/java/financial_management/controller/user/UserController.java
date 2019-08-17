package financial_management.controller.user;


import financial_management.entity.CurrentVO;
import financial_management.entity.UserPO;
import financial_management.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public CurrentVO login(UserPO po){
        CurrentVO vo = new CurrentVO();

        vo.setToken(jwtUtil.generateToken("200"));
        return vo;
    }

    @PostMapping("/name")
    public CurrentVO getName(HttpServletRequest request){
        CurrentVO vo = new CurrentVO();
        vo.setToken(String.valueOf(jwtUtil.getIdFromRequest(request)));
        return vo;
    }
}
