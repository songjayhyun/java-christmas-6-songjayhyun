package christmas.view;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
