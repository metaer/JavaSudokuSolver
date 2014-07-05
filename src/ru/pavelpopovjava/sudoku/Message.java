package ru.pavelpopovjava.sudoku;

import java.lang.reflect.Field;

class Message {
    protected String en; //Message in English
    protected String ru; //Message in Russian

    public String getMessage() {
        String locale = LocaleManager.getCurrentLocale();

        try {
            Field field = this.getClass().getSuperclass().getDeclaredField(locale);
            return (String) field.get(this);
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }

    }

}
