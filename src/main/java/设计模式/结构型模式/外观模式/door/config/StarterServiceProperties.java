package 设计模式.结构型模式.外观模式.door.config;

import org.springframework.context.annotation.Configuration;

@Configuration("itstack.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
