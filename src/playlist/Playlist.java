package playlist;

import com.mpatric.mp3agic.Mp3File;
import exceptions.PresenceFileException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Anna Kuzmenko
 */
public abstract class Playlist <T> {
    protected List<T> playlist;
    protected String title;

    public Playlist(String title) {
        this.title = title;
        playlist = new ArrayList<>();
    }

    public abstract void add(T e) throws PresenceFileException;
    public abstract void remove(T e) throws PresenceFileException;
    public abstract void addAll(List<T> list);

    public List<T> getPlaylist() {
        return playlist;
    }

    public String getTitle() {
        return title;
    }

    public void setPlaylist(List<T> playlist) {
        this.playlist = playlist;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
