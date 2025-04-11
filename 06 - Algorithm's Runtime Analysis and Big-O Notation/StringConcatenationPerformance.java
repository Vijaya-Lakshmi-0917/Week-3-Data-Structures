public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int iterations = 10000;
        String text = "hello";

        long start, end;

        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += text;
        }
        end = System.nanoTime();
        System.out.printf("String: %.2f ms%n", (end - start) / 1_000_000.0);

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        end = System.nanoTime();
        System.out.printf("StringBuilder: %.2f ms%n", (end - start) / 1_000_000.0);

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }
        end = System.nanoTime();
        System.out.printf("StringBuffer: %.2f ms%n", (end - start) / 1_000_000.0);
    }
}