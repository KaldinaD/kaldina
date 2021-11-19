package org.example.lab3;

import java.util.Scanner;

/*
Model-View-Controller (MVC, «Модель-Представление-Контроллер», «Модель-Вид-Контроллер») — схема разделения данных приложения, и управляющей логики на три
отдельных компонента: модель, представление и контроллер — таким образом, что модификация каждого компонента может осуществляться независимо.
    Модель (Model) предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.
    Представление (View) отвечает за отображение данных модели пользователю, реагируя на изменения модели.
    Контроллер (Controller) интерпретирует действия пользователя, оповещая модель о необходимости изменений.
 */
public class View {

    private Controller controller;

    public static void main(String[] args) {
        while (true) {
            StringBuilder request = new StringBuilder();

            int deistvie = getDo();

            switch (deistvie) {
                case 1: {
                    request.append("create");
                    request.append("=");
                    request.append(create());
                    break;
                }
                case 2:{
                    request.append("delete");
                    request.append("=");
                    request.append(delete());
                    break;
                }
                default: request.append("info=all");
            }
            System.out.println(Controller.getRequest(request.toString()));
        }
    }

    public static int getDo() {
        System.out.println("1 - Создать модель;\n2 - Удалить модель;\n3 - Посмотреть все модели;");
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return getDo();
        }
    }

    public static String create() {
        System.out.println("Введите имя модели.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int delete() {
        System.out.println("Введите id модели для удаления.");
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return delete();
        }
    }

}
