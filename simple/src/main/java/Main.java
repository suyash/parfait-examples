public class Main {
    public static void main (String... args) throws Exception {
        Thread t = new Thread(new Simple());
        t.start();
    }
}
