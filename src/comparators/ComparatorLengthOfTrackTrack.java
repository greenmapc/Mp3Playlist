package comparators;

import com.mpatric.mp3agic.Mp3File;
import playlist.Mp3Track;

/**
 * User: Anna Kuzmenko
 */
public class ComparatorLengthOfTrackTrack extends TrackAbstractComparator {
    @Override
    public int compare(Mp3Track o1, Mp3Track o2) {
        return  (int) (o1.getLengthInSeconds() - o2.getLengthInSeconds());
    }
}
