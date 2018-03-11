package playlist;

import comparators.ComparatorArtistTrack;
import comparators.ComparatorLengthOfTrackTrack;
import comparators.ComparatorTitleTrack;
import exceptions.PresenceFileException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Anna Kuzmenko
 */

public class PlaylistOfMp3 extends Playlist <Mp3Track> {

    public PlaylistOfMp3(String title) {
        super(title);
    }

    @Override
    public void add(Mp3Track track) throws PresenceFileException {
        if(!playlist.contains(track)) {
            playlist.add(track);
        }
        else throw new PresenceFileException("! >> Such file already exist in playlist: command \"Add song\" not executed"); // бросить исключение
    }

    @Override
    public void addAll(List<Mp3Track> list) {
        playlist.addAll(list);
        playlist = playlist.stream() //STREAM
                            .distinct()
                            .collect(Collectors.toList());
    }

    @Override
    public void remove(Mp3Track track) throws PresenceFileException {
        if(!playlist.contains(track)) throw new PresenceFileException("! >> Such file doesn't not exist in playlist: command \"Remove song\" not executed");
        else {
            playlist = playlist.stream()
                                .filter((p) -> p.getArtist().equals(track.getArtist()) && p.getTitle().equals(track.getArtist()))
                                .collect(Collectors.toList()); //STREAM!
        }
    }

    public void sortByTitle () {
        playlist.sort(new ComparatorTitleTrack());
    }
    public void sortByTitleReverse () {
        sortByTitle();
        reverse();
    }

    private void reverse() {
        Collections.reverse(playlist);
    }

    public void sortByArtist() {
        playlist.sort(new ComparatorArtistTrack());
    }
    public void sortByArtistReverse() {
        sortByArtist();
        reverse();
    }

    public void sortByLengthOfTrack() {
        playlist.sort(new ComparatorLengthOfTrackTrack());
    }
    public void sortByLengthOfTrackReverse() {
        sortByLengthOfTrack();
        reverse();
    }

    public List<Mp3Track> getPlaylist() {
        return playlist;
    }


}
