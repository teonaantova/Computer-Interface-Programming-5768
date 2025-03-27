import java.util.ArrayList;
import java.util.List;

class ConcurrentPrimeChecker {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ConcurrentPrimeChecker <numbers>");
            return;
        }

        List<Thread> threads = new ArrayList<>();

        for (String arg : args) {

            try {
                int num = Integer.parseInt(arg);
                if (num < 1) {
                    System.out.println("Warning: " + num + " is not a positive number. Skipping.");
                    continue;
                }

                Thread thread = new Thread(new PrimeCheckerTask(num));
                threads.add(thread);
                thread.start();

            } catch (NumberFormatException e) {
                System.out.println("Warning: '" + arg + "' is not a valid integer. Skipping.");
            }
        }


        for (Thread thread : threads) {

            try {
                thread.join();

            } catch (InterruptedException e) {
                System.out.println("Error: Thread interrupted.");
            }
        }
    }
}

