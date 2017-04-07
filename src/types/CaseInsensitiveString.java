package types;

import java.util.Locale;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class CaseInsensitiveString<E> implements CharSequence, Comparable<E> {

    private String value;
    private E originalValue;
    private CharSequence valueSequence;

    public CaseInsensitiveString(final E value) {
        if (String.class.isAssignableFrom(value.getClass())) {
            this.value = (String) value;
        }
        this.value = value.toString();
        this.originalValue = value;
    }

    public String getValue() {
        return value;
    }

    public E getOriginalValue() {
        return originalValue;
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return this.value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.value.subSequence(start, end);
    }


    public int compareTo(CaseInsensitiveString o) {
        return (this.value).toUpperCase(Locale.ITALY).compareTo(o.getValue().toUpperCase(Locale.ITALY));
    }

    @Override
    public int compareTo(E o) {
        final CaseInsensitiveString<E> toCompare = new CaseInsensitiveString<>(o);
        return compareTo(toCompare);
    }
}
