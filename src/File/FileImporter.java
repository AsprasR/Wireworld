package File;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class FileImporter {

    public HashMap gridImport(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream( new BufferedInputStream( new FileInputStream(file)))) { 
            HashMap<String, Object> retrieved = (HashMap<String, Object>) inputStream.readObject();
            return retrieved;
        }
    }
}
