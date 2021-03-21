public class Racer implements Runnable {
    Car c;
    int distance = 1000; // this is a racer that is going to run 1000 miles.

    public Racer(Car c) {
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println("Hello " + this.c.name);
    }
}
