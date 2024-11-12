package com.gabrielfigueiredol.LiterAluraChallenge.service;

public interface IConvertData {
    <T> T  getData(String json, Class<T> tClass);
}
