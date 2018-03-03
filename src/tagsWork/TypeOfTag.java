package tagsWork;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;

/**
 * User: Anna Kuzmenko
 */
public class TypeOfTag {
    public ID3v1 getTag(Mp3File mp3) {
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
