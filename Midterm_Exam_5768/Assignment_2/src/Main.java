class PrimeCheckerTask implements Runnable {
    private final int number;

    public PrimeCheckerTask(int number) {
        this.number = number;
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    @Override

    public void run() {
        if (isPrime(number)) {
            System.out.println(Thread.currentThread().getName() + ": " + number + " is a prime number.");
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + number + " is not a prime number.");

        }
    }
}


