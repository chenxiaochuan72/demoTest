package 设计模式.行为型模式.责任链模式;

import lombok.Data;

/**
 * @Author cxc
 * @Date 2023/3/30 8:47 PM
 * @Version 1.0
 */
@Data
public class AuthInfo {
    private String code;
    private String info = "";
    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }
}
