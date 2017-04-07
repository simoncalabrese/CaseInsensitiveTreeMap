package comparators;

import types.CaseInsensitiveString;

import java.util.Comparator;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class CaseInsensitiveComparator<K extends CaseInsensitiveString> implements Comparator<K> {
    @Override
    public int compare(K o1, K o2) {
        return o1.compareTo(o2);
    }
}
