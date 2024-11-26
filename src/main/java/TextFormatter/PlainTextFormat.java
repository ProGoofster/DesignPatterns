package TextFormatter;

import java.util.ArrayList;
import java.util.Random;

public class PlainTextFormat extends BaseTextFormat implements IFormat {
    public PlainTextFormat(ArrayList<String> data){
        fileType = ".txt";
        formattedText = data;
    }
}
