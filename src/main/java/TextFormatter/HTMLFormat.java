package TextFormatter;

import java.util.ArrayList;
import java.util.Random;

public class HTMLFormat extends BaseTextFormat implements IFormat {
    public HTMLFormat(ArrayList<String> data){
        fileType = ".html";
        formattedText = format(data);
    }

    public ArrayList<String> format(ArrayList<String> dataIn){
        String[][] outerOptions = {{"<h1>","</h1>"}, {"<h2>","</h2>"}, {"<h3>","</h3>"}, {"<h4>","</h4>"}, {"<h5>","</h5>"}, {"<p>","</p>"}};
        String[][] innerOptions = {{"<b>","</b>"}, {"<i>","</i>"}, {"<b><i>","</i></b>"}};
        Random rng = new Random();
        ArrayList<String> dataOut = new ArrayList<>();
        for(int i = 1; i < dataIn.size(); i++){
            String[] outerOption = outerOptions[rng.nextInt(outerOptions.length)];
            String[] innerOption = innerOptions[rng.nextInt(innerOptions.length)];
            String[] option = {outerOption[0]+innerOption[0], innerOption[1]+outerOption[1]};

            dataOut.add(option[0] + dataIn.get(i) + option[1]);
        }
        return dataOut;
    }
}
