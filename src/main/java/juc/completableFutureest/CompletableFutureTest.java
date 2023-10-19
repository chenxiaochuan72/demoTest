package juc.completableFutureest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author cxc
 * @Date 2023/6/3 9:18 PM
 * @Version 1.0
 * @Description:
 */

public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId =666L;
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        return userInfoService.getUserInfo(userId);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        Thread.sleep(300); //模拟主线程其它操作耗时

        CompletableFuture<String> medalCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return medalService.getMedalInfo(userId);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        String userInfo = userCompletableFuture.get(2, TimeUnit.SECONDS);
        System.out.println(userInfo);
        String medal = medalCompletableFuture.get();
        System.out.println(medal);
    }
}
