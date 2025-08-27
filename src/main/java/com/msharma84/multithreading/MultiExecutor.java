package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiExecutor {

    private final List<Runnable> taskList;

    public MultiExecutor(List<Runnable> taskList){
        this.taskList = Collections.unmodifiableList(taskList);
    }

    protected void executeAll(){
        List<Thread> threadList = new ArrayList<>(taskList.size());

        int count = 0;
        for(Runnable task : taskList){
            threadList.add(new Thread(task,"Task-"+count));
            count++;
        }

        for(Thread thread : threadList){
            thread.start();
        }
    }

    public static void main(String[] args) {

        Runnable task1 = ()->{
            System.out.println(Thread.currentThread().getName()+" executing");
        };
        Runnable task2 = ()->{
            System.out.println(Thread.currentThread().getName()+" executing");
        };

        List<Runnable> list = List.of(task1,task2);

        MultiExecutor multiExecutor = new MultiExecutor(list);
        multiExecutor.executeAll();
    }
}
