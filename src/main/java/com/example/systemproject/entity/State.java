package com.example.systemproject.entity;


/*
* Состояние проекта может принимать одно из следующих значений:  State
1. Оформление - принимается состояние в момент создания, до выполнения
действия “Отправить на согласование”;
2. Согласование - после выполнения действия “Отправить на согласование“;
3. Доработка - после выполнения действия “Вернуть на доработку“;
4. Исполнение - после выполнения действия “Согласовать”;
5. Завершен - все работы проекты выполнены.
* */
public enum State {
    CREATED, //Оформление
    APPROVAL,//Согласование
    FINALIZATION,//Доработка
    EXECUTION,//Исполнение
    COMPLETED// Завершен
}