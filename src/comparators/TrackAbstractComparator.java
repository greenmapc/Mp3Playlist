package comparators;

import com.mpatric.mp3agic.Mp3File;
import playlist.Mp3Track;
import util.Mp3PlayListSaver;

import java.util.Comparator;
/**
 * User: Anna Kuzmenko
 */
abstract class TrackAbstractComparator implements Comparator<Mp3Track> {
    public abstract int compare(Mp3Track o1, Mp3Track o2);

}
