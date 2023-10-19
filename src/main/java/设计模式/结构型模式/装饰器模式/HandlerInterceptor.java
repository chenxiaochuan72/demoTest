package 设计模式.结构型模式.装饰器模式;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
