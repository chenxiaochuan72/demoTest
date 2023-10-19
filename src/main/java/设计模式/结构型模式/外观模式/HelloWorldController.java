package 设计模式.结构型模式.外观模式;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import 设计模式.结构型模式.外观模式.domain.UserInfo;
import 设计模式.结构型模式.外观模式.door.annotation.DoDoor;

@RestController
public class HelloWorldController {
    @Value("${server.port}")
    private int port;
    /**
     * key：需要从⼊参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使⽤
     * returnJson：预设拦截时返回值，是返回对象的Json
     *
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=⼩团团
     */
    @DoDoor(key = "userId",returnJson = "{\"code\":\"1111\",\"info\":\"⾮⽩名单 可访问⽤户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method =
            RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("⾍⾍:" + userId, 19, "天津市南开区旮旯胡同100 号");
    }
}
