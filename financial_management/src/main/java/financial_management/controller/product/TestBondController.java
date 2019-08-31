package financial_management.controller.product;

import financial_management.service.product.BondSeriveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/30 16:20
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class TestBondController {

    @Autowired
    BondSeriveImpl bondSerive;

    @PostMapping("/firstPurchase")
    public ResponseEntity<?> buy(){
        bondSerive.firstPurchase(1L,0.0D,20F);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/dailyPurchase")
    public ResponseEntity<?> platformPurchase(){
        bondSerive.dailyPurchase();
        return ResponseEntity.ok().body("成功");
    }
}
