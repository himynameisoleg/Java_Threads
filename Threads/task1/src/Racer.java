public class Racer implements Runnable {
    Car c;
    int distance = 1000; // this is a racer that is going to run 1000 miles.


    public Racer(Car c) {
        this.c = c;
    }
    @Override
    public void run() {
        try {
            while (this.c.odometer <= distance) {
                if (this.c.miles == 0) {
                    long rechargeTime = (long) this.c.maxMiles;
                    Thread.sleep(rechargeTime);
                    this.c.miles = this.c.maxMiles;
                }
                this.c.move(1);

            }
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Hello " + this.c.name);
    }
}
