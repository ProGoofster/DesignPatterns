package TextFormatter;

import java.util.ArrayList;
import java.util.Random;

public class MarkDownFormat extends BaseTextFormat implements IFormat {
    public MarkDownFormat(ArrayList<String> data){
        fileType = ".md";
        formattedText = format(data);
    }
    public ArrayList<String> format(ArrayList<String> data){
        String[] options = {"**", "***", "<sub>", "~~", "_"};
        Random rng = new Random();
        ArrayList<String> dataOut = new ArrayList<>();
        for(int i = 1; i < data.size(); i++){
            String option = options[rng.nextInt(options.length)];
            dataOut.add(option + data.get(i) + option + "\\");
        }
        return dataOut;
    }
}
