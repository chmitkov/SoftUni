package io;

import entities.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderImpl implements Reader {

    private BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

    @Override
    public String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
