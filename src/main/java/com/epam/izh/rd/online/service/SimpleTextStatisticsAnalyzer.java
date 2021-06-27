package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;

/**
 * Совет:
 * Начните с реализации метода {@link SimpleTextStatisticsAnalyzer#getWords(String)}.
 * Затем переиспользуйте данный метод при реализации других.
 * <p>
 * При необходимости, можно создать внутри данного класса дополнительные вспомогательные приватные методы.
 */
public class SimpleTextStatisticsAnalyzer implements TextStatisticsAnalyzer {

    /**
     * Необходимо реализовать функционал подсчета суммарной длины всех слов (пробелы, знаким препинания итд не считаются).
     * Например для текста "One, I - tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countSumLengthOfWords(String text) {
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        return result.length();
    }

    /**
     * Необходимо реализовать функционал подсчета количества слов в тексте.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 7.
     *
     * @param text текст
     */
    @Override
    public int countNumberOfWords(String text) {
        int count = 0;
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        for (String string : strings) {
            if (!string.equals("")) {
                count++;
            }
        }

        return count;
    }

    /**
     * Необходимо реализовать функционал подсчета количества уникальных слов в тексте (с учетом регистра).
     * Например для текста "One, two, three, three - one, tWo, tWo!!" - данный метод должен вернуть 5.
     * param text текст
     */
    @Override
    public int countNumberOfUniqueWords(String text) {
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        List<String> a = Arrays.asList(strings);
        Set<String> set = new HashSet<>(a);
        set.remove("");
        return set.size();
    }

    /**
     * Необходимо реализовать функционал получения списка слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "three", "one", "tWo", "tWo"}
     *
     * @param text текст
     */
    @Override
    public List<String> getWords(String text) {
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : strings) {
            if (!string.equals("")) {
                arrayList.add(string);
            }
        }

        return arrayList;
    }

    /**
     * Необходимо реализовать функционал получения списка уникальных слов из текста.
     * Пробелы, запятые, точки, кавычки и другие знаки препинания являются разделителями слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должен вернуться список :
     * {"One", "two", "three", "one", "tWo"}
     *
     * @param text текст
     */
    @Override
    public Set<String> getUniqueWords(String text) {

        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        List<String> a = Arrays.asList(strings);
        Set<String> set = new HashSet<>(a);
        set.remove("");
        return set;
    }

    /**
     * Необходимо реализовать функционал подсчета количества повторений слов.
     * Например для текста "One, two, three, three - one, tWo, tWo!!" должны вернуться результаты :
     * {"One" : 1, "two" : 1, "three" : 2, "one" : 1, "tWo" : 2}
     *
     * @param text текст
     */
    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : strings) {
            if (word.equals("")) {
                continue;
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    /**
     * Необходимо реализовать функционал вывода слов из текста в отсортированном виде (по длине) в зависимости от параметра direction.
     * Например для текста "Hello, Hi, mother, father - good, cat, c!!" должны вернуться результаты :
     * ASC : {"mother", "father", "Hello", "good", "cat", "Hi", "c"}
     * DESC : {"c", "Hi", "cat", "good", "Hello", "father", "mother"}
     *
     * @param text текст
     */
    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        String result = text.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] strings = result.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String string : strings) {
            if (!string.equals("")) {
                list.add(string);
            }

        }
        switch (direction) {
            case ASC:
                list.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
                break;

            case DESC:
                list.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
                break;
        }

        return list;
    }

}
