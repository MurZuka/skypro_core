package org.skypro.skyshop.search;

import org.skypro.skyshop.article.Article;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return "имя " + getName() + " — тип " + getContentType();
    }
}
