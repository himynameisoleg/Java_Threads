/* TODO 
Imports. Fill them up as you need them.*/

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebPageEditor {
    public  String temp; // holds the last webpage saved.
    public  WebPage wp; // the webpage you are working on
    public  String filename; // the filename to save this webpage

    public WebPageEditor(String filename){
        wp = new WebPage();
        this.filename = filename;
    }

    public void start(){

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        service.scheduleAtFixedRate(()->{checkSave();}, 10, 10, TimeUnit.SECONDS);

        // use a scanner to read every line the user writes
        Scanner kbd  = new Scanner(System.in);
        boolean finish = false;
        while(!finish) {
            String in = kbd.nextLine();
            if (in.equals("quit")) {
                finish = true;
            } else if (in.contains("t:")) {
                wp.addTitle(in);
            } else {
               wp.addParagraph(in);
            }
        }

        service.shutdownNow();
    }

    public  boolean checkSave(){
        if (!wp.toString().equals(temp)) {
            this.temp = wp.toString();
            wp.save(filename);
            return true;
        } else {
            return false;
        }
        /* TODO
If the text of the wp (String representation) is equal to the last String reperesentation
(stored in tmp) returns false. Otherwise, it saves the webpage to the given filenam,
tmp updates to the most current string representation of this webpage, and the funtion returns true.*/
    }
}
