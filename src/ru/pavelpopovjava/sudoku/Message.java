package ru.pavelpopovjava.sudoku;

import java.lang.reflect.Field;

class Message {
    protected String en; //Message in English
    protected String ru; //Message in Russian

    public String getMessage() {
        String locale = LocalManager.getInstance().getCurrentLocale();

        /*Названия полей в сообщениях (en, ru) соответствуют строковым представлениям локалей.
        При добавлении нового языка достаточно будет лишь добавить свойство в класс-потомок класса Message
        Используем рефлексию*/

        try{
            Field field = this.getClass().getSuperclass().getDeclaredField(locale);
            return (String) field.get(this);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
