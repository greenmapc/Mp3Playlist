package comparators;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
/**
 * User: Anna Kuzmenko
 */
public class ComparatorArtist extends AbstractComparator{

    @Override
    public int compare(Mp3File o1, Mp3File o2) {
        ID3v1 first = type.getTag(o1);
        ID3v1 second = type.getTag(o2);

        return first.getArtist().compareTo(second.getArtist());
    }

}
