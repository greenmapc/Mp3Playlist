package playlist;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;

/**
 * User: Anna Kuzmenko
 */
public class Mp3Track extends Mp3File {

    private ID3v1 tag;

    public Mp3Track(String path) throws InvalidDataException, IOException, UnsupportedTagException {
        super(path);
        tag = new TypeOfTag().getTag(this);
    }

    public String getArtist() {
        return tag.getArtist();
    }

    public String getTitle() {
        return tag.getTitle();
    }

    private class TypeOfTag {
        private ID3v1 getTag(Mp3File mp3) {
            return getID3v1(mp3);
        }
        private ID3v1 getID3v1(Mp3File mp3) {
            if(mp3.getId3v1Tag() != null) {
                return mp3.getId3v1Tag();
            }
            return getID3v2(mp3);
        }
        private ID3v1 getID3v2 (Mp3File mp3) {
            if (mp3.getId3v2Tag() != null) {
                return mp3.getId3v2Tag();
            }
            return null;
        }
    }
}
