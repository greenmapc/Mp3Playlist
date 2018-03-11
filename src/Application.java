import com.mpatric.mp3agic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.NullPlaylistException;
import exceptions.NoFileException;
import exceptions.PresenceFileException;
import exceptions.UnknownCommandException;
import playlist.*;
import util.*;

/**
 * User: Anna Kuzmenko
 */

public class Application {
    public static void main(String[] args) throws InvalidDataException, IOException, UnsupportedTagException {
        List<Mp3Track> allSongs = new ArrayList<>(new Mp3Reader().readFile());
        IUserInteractor terminal = new UserInteractor();

        terminal.print("Songs in directory: ");
        allSongs.stream().forEach((x) -> System.out.println(" - " + x.getArtist() + " " + x.getTitle()));//STREAM

        String prompt = "Enter new command or enter \"Help\"";
        PlaylistOfMp3 playlist = null;
        String command;
        terminal.print(prompt);

        while (!(command = terminal.readCommand()).equals("end")) {
            try {
                switch (command) {
                    case "Create new playlist":
                        terminal.print("Enter name of new playlist");
                        playlist = createNewPlaylist(terminal.readCommand());
                        break;

                    case "Add song": terminal.print("Enter artist and title of song");
                        addSong(playlist, terminal.readCommand(), allSongs);
                        break;

                    case "Remove song":
                        terminal.print("Enter artist and title of song");
                        removeSong(playlist, terminal.readCommand(), allSongs);
                        break;

                    case "Sort playlist":
                        terminal.print("Select one of three type of sort: Title, Artist or Length");
                        String sortType = terminal.readCommand();
                        terminal.print("Up or Down?");
                        String sortType2 = terminal.readCommand();
                        sort(playlist, sortType, sortType2);
                        break;

                    case "Save playlist":
                        PlayListSaver<Mp3Track> saver = new Mp3PlayListSaver();
                        if(playlist == null) throw new NullPlaylistException("Command \"Save playlist\" not executed");
                        saver.save(playlist.getTitle(), playlist);
                        break;

                    case "Rename playlist":
                        terminal.print("Enter new playlist's name");
                        if(playlist == null) throw new NullPlaylistException("Command \"Rename playlist\" not executed");
                        playlist.setTitle(terminal.readCommand());
                        break;

                    case "Add several songs":
                        terminal.print("Enter number of songs");
                        int col = Integer.parseInt(terminal.readCommand());
                        int okAdd = 0;
                        for (int i = 0; i < col; i++) {
                            terminal.print("Enter artist and title of song");
                            try {
                                if (addSong(playlist, terminal.readCommand(), allSongs)) {
                                    okAdd++;
                                }
                            } catch (NoFileException e) {
                                terminal.print("! >> Such song is not exist: " + e.getMessage());
                            }

                        }
                        terminal.print("Finally added " + okAdd + " of " + col + " songs in playlist");
                        break;

                    case "Help":
                        terminal.getHelp();
                        break;

                    case "End":
                        System.exit(0);
                        break;
                    default:
                        terminal.print("Unknown command");
                        break;
                }
            } catch (NullPlaylistException e) {
                terminal.print("! >> Playlist is not created: " + e.getMessage());
            } catch (NoFileException e) {
                terminal.print("! >> Such song is not exist: " + e.getMessage());
            } catch (UnknownCommandException e) {
                terminal.print("! >> " + e.getMessage());
            } finally {
                terminal.print(prompt);
            }
        }
    }

    public static PlaylistOfMp3 createNewPlaylist(String name) {
        return new PlaylistOfMp3(name);
    }

    public static boolean addSong(PlaylistOfMp3 playlist, String song, List<Mp3Track> allSongs) throws NullPlaylistException, NoFileException {
        if(playlist == null) throw new NullPlaylistException("Command \"Add song\" not executed");
       // System.out.println(allSongs.stream().anyMatch((x) -> (x.getArtist() + " " + x.getTitle()).equals(song)));
        for(Mp3Track x : allSongs) {
            String curSong = x.getArtist() + " " + x.getTitle();
            if (curSong.equals(song)) {
                try {
                    playlist.add(x);
                    System.out.println(">> Song added");
                    return true;
                } catch (PresenceFileException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        throw new NoFileException("Command \"Add song\" not executed");
    }

    public static boolean removeSong(PlaylistOfMp3 playlist, String song, List<Mp3Track> allSongs) throws NullPlaylistException, NoFileException {
        if(playlist == null) throw new NullPlaylistException("Command \"Remove song\" not executed");
        for(Mp3Track x : allSongs) {
            String curSong = x.getArtist() + " " + x.getTitle();
            if (curSong.equals(song)) {
                try {
                    playlist.remove(x);
                    System.out.println(">> Song removed");
                    return true;
                } catch (PresenceFileException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        throw new NoFileException("Command \"Remove song\" not executed");
    }

    public static void sort(PlaylistOfMp3 playlist, String type, String type2) throws NullPlaylistException, UnknownCommandException {
        if(playlist == null) throw new NullPlaylistException("Command \"Sort playlist\" not executed");
        switch (type) {
            case "Title":
                switch (type2) {
                    case "Down":
                        playlist.sortByTitle();
                        break;
                    case "Up":
                        playlist.sortByTitleReverse();
                        break;
                    default:
                        throw new UnknownCommandException(type2 + " is not correct command: " + "Sort not executed");
                }
                break;
            case "Artist":
                switch (type2) {
                    case "Down":
                        playlist.sortByArtist();
                        break;
                    case "Up":
                        playlist.sortByArtistReverse();
                        break;
                    default:
                        throw new UnknownCommandException(type2 + " is not correct command: " + "Sort not executed");
                }
                break;
            case "Length":
                switch (type2) {
                    case "Down":
                        playlist.sortByLengthOfTrack();
                        break;
                    case "Up":
                        playlist.sortByLengthOfTrackReverse();
                        break;
                    default:
                        throw new UnknownCommandException(type2 + " is not correct command: " + "Sort not executed");
                }
                break;
            default:
                throw new UnknownCommandException(type + " is not correct command: " + "Sort not executed");
        }
        System.out.println(">> Sorted");
    }

}
