package org.example.lab3;

/*
Model-View-Controller (MVC, «Модель-Представление-Контроллер», «Модель-Вид-Контроллер») — схема разделения данных приложения, и управляющей логики на три
отдельных компонента: модель, представление и контроллер — таким образом, что модификация каждого компонента может осуществляться независимо.
    Модель (Model) предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.
    Представление (View) отвечает за отображение данных модели пользователю, реагируя на изменения модели.
    Контроллер (Controller) интерпретирует действия пользователя, оповещая модель о необходимости изменений.
 */

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static int id0 = 0;
    private static Map<Integer, Model> map = new HashMap<>();

    public static String getRequest(String request) {
        try {
            String[] splits = request.split("=");
            String command = splits[0];
            switch (command) {
                case "create":
                    return create(splits[1]);
                case "delete":
                    return delete(Integer.parseInt(splits[1]));
                case "info":
                    return infoAll();
            }
            return "Команда не известна";
        } catch (Exception e) {
            return "Ошибка";
        }
    }

    private static String create(String name) {
        Model model = new Model(id0++, name);
        map.put(model.getId(), model);
        return model.toString();
    }

    private static String delete(int id) {
        Model m = map.get(id);
        if (m == null) {
            return "Такой модели не существует";
        }
        map.remove(id);
        return "Модель уничтожена";
    }

    private static String infoAll() {
        StringBuilder str = new StringBuilder();
        for (Model m : map.values()) {
            str.append(m.toString());
            str.append("\n");
        }
        return str.toString();
    }
}
