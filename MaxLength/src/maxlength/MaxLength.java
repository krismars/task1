package maxlength;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxLength {

    public static void main(String[] args) {

        String inputPath = "src" + File.separator + "test" + File.separator + "input.txt";
        File input = new File(inputPath);
        if (input.length() > 100) {
            System.err.println("Too long file");
            System.exit(1);
        }
        BufferedReader reader = null;
        int count = 0;
        int max = 0;

        try {
            reader = new BufferedReader(new FileReader(input));
            int text = -1;
            while ((text = reader.read()) != -1) {
                if (text == '1') {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                }
            }
            if (count > max) {
                max = count;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        String outputPath = "src" + File.separator + "test" + File.separator + "output.txt";

        File output = new File(outputPath);

        FileWriter fw;
        try {
            fw = new FileWriter(output.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            String s = String.valueOf(max);
            bw.write(s);

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MaxLength.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
