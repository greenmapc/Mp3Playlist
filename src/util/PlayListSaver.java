package util;
import playlist.Playlist;
import java.io.IOException;

public interface PlayListSaver <T>{
    public void save(String title, Playlist<T> playlist) throws IOException;
}
