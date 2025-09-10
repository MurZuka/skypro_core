package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> elements;

    public SearchEngine(List<Searchable> elements, int listSize) {
        this.elements = new HashSet<>();

        if (elements.size() == listSize) {
            this.elements.addAll(elements);
        } else {
            List<Searchable> targetElements = new ArrayList<>(listSize);

            for (int i = 0; i < elements.size(); i++) {
                if (i == listSize) break;

                targetElements.add(elements.get(i));
            }

            this.elements.addAll(targetElements);
        }
    }

    public Set<Searchable> search(String toSearch) {
        Set<Searchable> result = new TreeSet<>(new SearchableComparator());

        for (Searchable s : elements) {
            if (s.getSearchTerm().toUpperCase().contains(toSearch.toUpperCase())) {
                result.add(s);
            }
        }

        return result;
    }

    public Searchable getBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int currentMaxCount = 0;
        String toSearch = search.toUpperCase();

        for (Searchable s : elements) {
            String str = s.getStringRepresentation().toUpperCase();

            int matchCount = getMatchCount(toSearch, str);

            if (matchCount > currentMaxCount) {
                currentMaxCount = matchCount;
                result = s;
            }
        }

        if (result == null) {
            throw new BestResultNotFound(search);
        } else {
            return result;
        }
    }

    private int getMatchCount(String toSearch, String str) {
        int matchCount = 0;
        int index = 0;
        int substrIndex = str.indexOf(toSearch, index);

        while (substrIndex != -1) {
            matchCount++;
            index = substrIndex + toSearch.length();
            substrIndex = str.indexOf(toSearch, index);
        }
        return matchCount;
    }

    public void add(Searchable newElement) {
        elements.add(newElement);
    }
}
