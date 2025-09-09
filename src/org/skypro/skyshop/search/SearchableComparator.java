package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int intCompResult = Integer.compare(o1.getName().length(), o2.getName().length());

        if (intCompResult == 0) {
            return o1.getName().compareTo(o2.getName());
        }

        return intCompResult;
    }
}
