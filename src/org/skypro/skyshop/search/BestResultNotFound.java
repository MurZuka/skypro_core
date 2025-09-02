package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    private String message;

    public BestResultNotFound(String prompt) {
        this.message = "Не найден результат по запросу «" + prompt + "»";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
