package main.cfg;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CFGLoader {
public CFGLoader() throws IOException {
    File file = new File("test.cfg");
    if (file.exists()) {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            HashMap<String, String> inputs = new HashMap<String, String>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int index = line.indexOf(":");
                if (index > 0 && line.length() - index > 0) {
                    inputs.put(line.substring(0, index), line.substring(index + 1));
                }
                for (String i : inputs.keySet()) {
                    System.out.println(i + " " + inputs.get(i));
                }
            }
            scanner.close();
        } else {
            IOException e = new IOException();
            System.err.println(e.getMessage());
            throw e;
        }
    } else {
        file.createNewFile();
    }
}
}
