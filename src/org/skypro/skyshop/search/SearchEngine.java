package org.skypro.skyshop.search;

import java.util.Locale;

public class SearchEngine {
    private Searchable[] elements;
    private int resultsCount;

    public SearchEngine(Searchable[] elements, int resultsCount) {
        this.elements = elements;
        this.resultsCount = resultsCount;
    }

    public String[] search(String toSearch) {
        String[] result = new String[resultsCount];

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getSearchTerm().toUpperCase().contains(toSearch.toUpperCase())) {
                result[i] = elements[i].getStringRepresentation();
            }
        }

        return result;
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
