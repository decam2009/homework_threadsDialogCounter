
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyCallable extends Thread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer messagesCount = 0;
        while (messagesCount < 5) {
            Thread.sleep(2000);
            System.out.println("Сообщение от потока: " + Thread.currentThread().getName());
            messagesCount++;
        }
        Thread.sleep(2000);
        System.out.printf("Количество сообщений от потока %s - %d \n", Thread.currentThread().getName(), messagesCount);
        return messagesCount;
    }
}
