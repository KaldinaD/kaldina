package org.example.lab3;

/*
Model-View-Controller (MVC, «Модель-Представление-Контроллер», «Модель-Вид-Контроллер») — схема разделения данных приложения, и управляющей логики на три
отдельных компонента: модель, представление и контроллер — таким образом, что модификация каждого компонента может осуществляться независимо.
    Модель (Model) предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.
    Представление (View) отвечает за отображение данных модели пользователю, реагируя на изменения модели.
    Контроллер (Controller) интерпретирует действия пользователя, оповещая модель о необходимости изменений.
 */
public class Model {
    private int id;
    private String name;

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
