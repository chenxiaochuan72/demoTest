package 设计模式.结构型模式.外观模式.door.config;

import org.apache.commons.lang3.StringUtils;

public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }
    public String[] split(String separatorChar) {
        return StringUtils.split(this.userStr, separatorChar);
    }
}
