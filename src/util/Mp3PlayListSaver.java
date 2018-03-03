package util;

import com.mpatric.mp3agic.Mp3File;
import playlist.Playlist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * User: Anna Kuzmenko
 */
public class Mp3PlayListSaver implements PlayListSaver <Mp3File> {

    public void save(String title, Playlist<Mp3File> playlist) throws IOException {
        File folder;
        File file;
        folder = new File("data/" + title);
        int i = 1;
        Character add = null;
        while(folder.exists()) {
            add = (char)((int)'0' + i);
            folder = new File("data/" + title + add);
            i ++;
        }

        List <Mp3File> list = playlist.getPlaylist();
        folder.mkdir();

        for(Mp3File x : list) {
            file = new File(x.getFilename());
            Path destDir;
            if(add == null) {
                destDir = Paths.get("data/" + title);
            } else {
                destDir = Paths.get("data/" + title + add);
            }
            Files.copy(file.toPath(), destDir.resolve(file.getName())); //копирует
        }

    }
}
