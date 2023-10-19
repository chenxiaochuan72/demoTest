package 设计模式.结构型模式.装饰器模式;

/**
 * 抽象类装饰⻆⾊
 */
public abstract class SsoDecorator implements HandlerInterceptor{
    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator() {
    }

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request,response,handler);
    }
}
