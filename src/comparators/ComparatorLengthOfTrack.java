package comparators;

import com.mpatric.mp3agic.Mp3File;

/**
 * User: Anna Kuzmenko
 */
public class ComparatorLengthOfTrack extends AbstractComparator {
    @Override
    public int compare(Mp3File o1, Mp3File o2) {
        return  (int) (o1.getLengthInSeconds() - o2.getLengthInSeconds());
    }
}
