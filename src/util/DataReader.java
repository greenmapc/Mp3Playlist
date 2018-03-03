package util;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.util.List;

/**
 * User: Anna Kuzmenko
 */
public interface DataReader {
    public List<Mp3File> readFile() throws IOException, InvalidDataException, UnsupportedTagException;
}
