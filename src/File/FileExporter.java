package File;

import GUI.Map;
import Simulation.NextGeneration;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileExporter {

    public void gridExport(NextGeneration next, Map map, File file) throws IOException {
        HashMap<String, Object> saved = new HashMap<>();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            saved.put("Box", next.getBox());
            saved.put("Map", map);
            outputStream.writeObject(saved);
        }

    }
}
