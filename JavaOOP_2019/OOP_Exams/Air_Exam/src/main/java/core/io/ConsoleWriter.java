package core.io;

import core.io.interfacese.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String contents) {
        System.out.println(contents);
    }

    @Override
    public void write(String contents) {
        System.out.print(contents);
    }
}
