package comparators;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import playlist.Mp3Track;

/**
 * User: Anna Kuzmenko
 */
public class ComparatorTitleTrack extends TrackAbstractComparator {
    @Override
    public int compare(Mp3Track o1, Mp3Track o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
