package org.skypro.skyshop.search;

import java.util.Locale;

public class SearchEngine {
    private Searchable[] elements;

    public SearchEngine(Searchable[] elements, int arrSize) {
        if (elements.length == arrSize) {
            this.elements = elements;
        } else {
            Searchable[] targetElements = new Searchable[arrSize];

            for (int i = 0; i < elements.length; i++) {
                if (i == arrSize) break;

                targetElements[i] = elements[i];
            }

            this.elements = targetElements;
        }
    }

    public String[] search(String toSearch) {
        int filledCount = 0;
        String[] result = new String[5];

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getSearchTerm().toUpperCase().contains(toSearch.toUpperCase())) {
                result[filledCount] = elements[i].getStringRepresentation();

                filledCount++;
                if (filledCount > result.length) break;
            }
        }

        return result;
    }

    public Searchable getBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int currentMaxCount = 0;
        String toSearch = search.toUpperCase();

        for (int i = 0; i < elements.length; i++) {
            String str = elements[i].getStringRepresentation().toUpperCase();

            int matchCount = getMatchCount(toSearch, str);

            if (matchCount > currentMaxCount) {
                currentMaxCount = matchCount;
                result = elements[i];
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
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = newElement;
                break;
            }
        }
    }
}
