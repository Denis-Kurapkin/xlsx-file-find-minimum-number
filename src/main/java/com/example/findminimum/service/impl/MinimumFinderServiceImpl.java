package com.example.findminimum.service.impl;

import com.example.findminimum.service.MinimumFinderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MinimumFinderServiceImpl implements MinimumFinderService {

    @Override
    public int findMinimumNumber(List<Integer> numbers, int n) {
        if (n <= 0 || n > numbers.size()) {
            throw new IllegalArgumentException("N должно быть в диапазоне от 1 до " + numbers.size());
        }

        List<Integer> listOfNumbers = new ArrayList<>(numbers);
        return quickSelect(listOfNumbers, 0, listOfNumbers.size() - 1, n - 1);
    }

    /**
     * Поиск k-меньшего элемента в диапазоне индексов
     *
     * @param list список чисел
     * @param left левая граница
     * @param right правая граница
     * @param k индекс искомого элемента
     * @return k-й наименьший элемент
     */

    private int quickSelect(List<Integer> list, int left, int right, int k) {
        if (left == right) {
            return list.get(left);
        }

        int pivotIndex = partition(list, left, right);

        if (k == pivotIndex) {
            return list.get(k);
        } else if (k < pivotIndex) {
            return quickSelect(list, left, pivotIndex - 1, k);
        } else {
            return quickSelect(list, pivotIndex + 1, right, k);
        }
    }

    /**
     * Разделение списка по опорному элементу pivot
     *
     * @param list список
     * @param left левая граница
     * @param right правая граница, изначально используется как pivot
     * @return итоговый индекс опорного элемента
     */

    private int partition(List<Integer> list, int left, int right) {
        int pivotValue = list.get(right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i) < pivotValue) {
                swap(list, i, storeIndex);
                storeIndex++;
            }
        }

        swap(list, storeIndex, right);
        return storeIndex;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
