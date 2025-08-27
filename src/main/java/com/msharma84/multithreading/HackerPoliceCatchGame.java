package multithreading;

import java.util.List;
import java.util.Random;

public class HackerPoliceCatchGame {

    private static int MAX_ATTEMPT = 9999;

    public static void main(String[] args) {

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_ATTEMPT));
        DescendingHacker descendingHacker = new DescendingHacker(vault);
        AscendingHacker ascendingHacker = new AscendingHacker(vault);
        Police police = new Police();

        List<Thread> threadList = List.of(descendingHacker,ascendingHacker,police);
        for(Thread thread : threadList){
            thread.start();
        }
    }

    private static abstract class Hacker extends Thread{

        protected Vault vault;
        public Hacker(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }
    }

    private static class DescendingHacker extends Hacker{

        public DescendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " started");
            for(int i = MAX_ATTEMPT ; i > 0; i--){
                if(vault.isCorrectPassword(i))
                {
                    System.out.println(this.getName()+" guessed the password "+i);
                    System.exit(0);
                }
            }
        }
    }

    private static class AscendingHacker extends Hacker{

        public AscendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " started");
            for(int i =0 ; i < MAX_ATTEMPT; i++){
                if(vault.isCorrectPassword(i))
                {
                    System.out.println(this.getName()+" guessed the password "+i);
                    System.exit(0);
                }
            }
        }
    }

    private static class Vault {
        int password;
        public Vault(int password){
            this.password = password;
        }
        public boolean isCorrectPassword(int guess){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return (guess == this.password);
        }
        int getPassword(){
            return this.password;
        }
    }

    private static class Police extends Thread{

        @Override
        public void run() {
            for(int i =10 ; i >0; i--){
                try {
                    Thread.sleep(1000);
                    System.out.println("Time left-"+i);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occurred...");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Game over Mr. Hacker");
            System.exit(0);
        }
    }
}
