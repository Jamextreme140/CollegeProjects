package components.verify.backend;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class VerifySystem {

    private String hint = "Animal";
    private String filename = "critical.txt";
    private Path path;
    private Scanner scanFile;

    public VerifySystem()
    {
        path = Paths.get(filename);
    }

    public String check(String text)
    {
        
        if(text.equals(hint))
            return "";
        try {
            scanFile = new Scanner(path);
            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                String fileExt = getFileExtension(line);
                if (line.equals(text + fileExt))
                    return line;
            }
        } catch (IOException e) {
            System.err.println("Error: File not found");
        }
        
        return "";
    }

    public String getHint()
    {
        return hint;
    }

    String getFileExtension(String text)
    {
        if(text.endsWith(".jpg"))
            return ".jpg";
        else if(text.endsWith(".png"))
            return ".png";
        return "";
    }

}
