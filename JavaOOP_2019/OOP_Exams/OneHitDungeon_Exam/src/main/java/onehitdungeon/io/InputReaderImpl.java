package onehitdungeon.io;

import onehitdungeon.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {

    private BufferedReader bufferedReader;

    public InputReaderImpl() {
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
    }

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
