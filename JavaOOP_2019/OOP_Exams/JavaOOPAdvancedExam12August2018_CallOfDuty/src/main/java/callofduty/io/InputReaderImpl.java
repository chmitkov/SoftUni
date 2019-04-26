package callofduty.io;

import callofduty.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {

    private BufferedReader br;

    public InputReaderImpl() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return this.br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
