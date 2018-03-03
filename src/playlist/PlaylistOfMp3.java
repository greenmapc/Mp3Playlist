package playlist;

import comparators.ComparatorArtist;
import comparators.ComparatorLengthOfTrack;
import comparators.ComparatorTitle;
import com.mpatric.mp3agic.Mp3File;
import exceptions.PresenceFileException;

import java.util.*;

/**
 * User: Anna Kuzmenko
 */

public class PlaylistOfMp3 extends Playlist <Mp3File> {

    public PlaylistOfMp3(String title) {
        super(title);
    }

    @Override
    public void add(Mp3File track) throws PresenceFileException {
        if(!playlist.contains(track)) {
            playlist.add(track);
        }
        else throw new PresenceFileException("! >> Such file already exist in playlist: command \"Add song\" not executed"); // бросить исключение
    }

    @Override
    public void addAll(List<Mp3File> list) {
        for(Mp3File x : list) {
            if(!playlist.contains(x)) {
                playlist.add(x);
            }
        }
    }

    @Override
    public void remove(Mp3File track) throws PresenceFileException {
        if(!playlist.contains(track)) throw new PresenceFileException("! >> Such file doesn't not exist in playlist: command \"Remove song\" not executed");
        else {
            playlist.remove(track);
        }
    }

    public void sortByTitle () {
        playlist.sort(new ComparatorTitle());
    }
    public void sortByTitleReverse () {
        sortByTitle();
        reverse();
    }

    private void reverse() {
        Collections.reverse(playlist);
    }

    public void sortByArtist() {
        playlist.sort(new ComparatorArtist());
    }
    public void sortByArtistReverse() {
        sortByArtist();
        reverse();
    }

    public void sortByLengthOfTrack() {
        playlist.sort(new ComparatorLengthOfTrack());
    }
    public void sortByLengthOfTrackReverse() {
        sortByLengthOfTrack();
        reverse();
    }

    public List<Mp3File> getPlaylist() {
        return playlist;
    }


}
