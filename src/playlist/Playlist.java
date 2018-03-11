package playlist;

import exceptions.PresenceFileException;

import java.util.ArrayList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist<?> playlist1 = (Playlist<?>) o;

        if (playlist != null ? !playlist.equals(playlist1.playlist) : playlist1.playlist != null) return false;
        return title != null ? title.equals(playlist1.title) : playlist1.title == null;
    }

    @Override
    public int hashCode() {
        int result = playlist != null ? playlist.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
