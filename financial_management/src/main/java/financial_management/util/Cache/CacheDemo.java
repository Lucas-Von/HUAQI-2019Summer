package financial_management.util.Cache;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class CacheDemo {


    @RequestMapping(value = "/test")
    @UseCache(key = CacheType.PROPERTIES, expiredTime = 2)
    public String func(){
        return "result";
    }
}
