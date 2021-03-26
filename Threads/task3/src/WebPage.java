/* TODO
Imports will be filling up as you need them. */

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class WebPage {
    public List<String> dom; // this actually has the html document model.

    public WebPage(){
        dom = new LinkedList<>();
    }

    public void addTitle(String title){
        dom.add("<h1>" + title + "</h1>");
    }

    public void addParagraph(String para) {
        dom.add("<p>" + para + "</p>");
    }
    public String toString(){
        String html = "<html>\n<head>\n</head>\n<body>";

        for (String el : dom) {
            html += el;
        }

        return html+"</body>\n</html>";
    }

    public void save(String filename){

        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(toString());
            fw.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
