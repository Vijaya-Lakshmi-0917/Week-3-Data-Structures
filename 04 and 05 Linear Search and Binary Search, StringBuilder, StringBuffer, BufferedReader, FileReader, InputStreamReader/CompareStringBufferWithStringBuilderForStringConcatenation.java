public class CompareStringBufferWithStringBuilderForStringConcatenation {
    public static void main(String[] args) {
        int numStrings = 1000000;
        String str = "hello";
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            stringBuffer.append(str);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            stringBuilder.append(str);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");
    }
}