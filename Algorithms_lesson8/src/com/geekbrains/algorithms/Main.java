package com.geekbrains.algorithms;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //====================Задание 8.1============================
        //Приведите пример использование хеш-таблиц
        //--Авторизация в каких-либо системах.--

        //====================Задание 8.2============================
        //Приведите примеры ключей и коллизий
        // Ключ - входной массив. Например, слово "Привет".
        // Коллизия - пара ключей имеет одинаковй хеш.

        //====================Задание 8.3============================
        //Приведите примеры популярных и эффективных хеш-функций
        // Суммирование
        // Возведение в степень

        //====================Задание 8.4============================
        //На основе данных массива из задания 2.3 реализуйте
        //хеш-таблицу с помощью открытой адресации,
        //а конкретнее метода линейного пробирования

        Item openAdDataItem;
        int aKey;
        int size = 66;

        long nano_startTime = System.nanoTime();
        HashTable hTable = new HashTable(size);
        Random rand = new Random();
        for (int j = 0; j < 15; j++)
        {
            aKey = rand.nextInt(999);
            openAdDataItem = new Item(aKey);
            hTable.insert(openAdDataItem);
        }
        long nano_endTime = System.nanoTime();
        System.out.println("Time taken open addressing: "
                + (nano_endTime - nano_startTime));

        hTable.insert(new Item(999));
        hTable.insert(new Item(203));
        hTable.display();

        System.out.println(hTable.find(999).getKey());
        hTable.delete(203);

        //====================Задание 8.5============================
        //Перестройте программный код задания 8.4 из алгоритма
        //линейного пробирования в алгоритм двойного хеширования.
        Item doubleHashDataItem;
        int bKey;
        int sizeNew = 66;

        nano_startTime = System.nanoTime();
        HashTableDouble hashTable = new HashTableDouble(sizeNew); // Создаём нашу хеш-таблицу
        rand = new Random();
        for (int j = 0; j < 15; j++) // Заполняем нашу хеш-таблицу
        {
            bKey = rand.nextInt(999);
            doubleHashDataItem = new Item(bKey);
            hashTable.insert(doubleHashDataItem);
        }
        nano_endTime = System.nanoTime();
        System.out.println("Time taken double hashing: "
                + (nano_endTime - nano_startTime));

        hashTable.insert(new Item(999));
        hashTable.insert(new Item(203));
        hashTable.display();

        System.out.println(hashTable.find(999).getKey());
        hashTable.delete(203);
    }

}
