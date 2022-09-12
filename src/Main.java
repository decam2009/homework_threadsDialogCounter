
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<MyCallable> myCallableList = new ArrayList<>();
        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 4; i++) {
            myCallableList.add(new MyCallable());
        }
        System.out.println("----------INVOKE ALL----------");
        pool.invokeAll(myCallableList);

        System.out.println("----------INVOKE ANY----------");
        final Integer anyTask = pool.invokeAny(myCallableList);

        pool.shutdown();
        Thread.sleep(2000);
        System.out.printf("Количество от любого потока %d \n", anyTask);
    }
}