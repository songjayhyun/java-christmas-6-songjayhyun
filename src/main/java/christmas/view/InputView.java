package christmas.view;

import christmas.io.Reader;

public class InputView {

    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public void close() {
        reader.close();
    }
}

