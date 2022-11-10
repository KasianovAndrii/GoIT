package module11;

public class MyRandom {
    private final int a, b;
    private int seed;
    public MyRandom seed(int seed) {
        this.seed = seed;
        return this;
    }
    public MyRandom(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int next(int seed) {
        return a * seed + b;
    }

}
