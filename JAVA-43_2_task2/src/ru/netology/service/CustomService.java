package ru.netology.service;

public class CustomService {
    public static final int WEIGHT_CUSTOM = 100;
    public static int calculateCustoms(int p, int w) {
        return p / 100 + w * WEIGHT_CUSTOM;
    }
}
