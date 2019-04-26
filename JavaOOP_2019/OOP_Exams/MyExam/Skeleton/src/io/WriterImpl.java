package io;

import entities.interfaces.Writer;

public class WriterImpl implements Writer {
    @Override
    public void printLine(String text) {
        System.out.println(text);
    }
}
