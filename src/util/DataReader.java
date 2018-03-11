package util;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import playlist.Mp3Track;

import java.io.IOException;
import java.util.List;

/**
 * User: Anna Kuzmenko
 */
public interface DataReader {
    public List<Mp3Track> readFile() throws IOException, InvalidDataException, UnsupportedTagException;
}
