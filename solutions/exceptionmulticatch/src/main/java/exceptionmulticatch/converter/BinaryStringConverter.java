package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString == null)
            throw new NullPointerException("binaryString null");
        boolean[] booleans = new boolean[binaryString.length()];
        for (int j = 0; j < binaryString.length(); j++) {
            char c = binaryString.charAt(j);
            if (c != '0' && c != '1')
                throw new IllegalArgumentException("binaryString not valid");
            booleans[j] = c == '1';
        }
        return booleans;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans == null)
            throw new NullPointerException("booleans null");
        if (booleans.length == 0)
            throw new IllegalArgumentException("booleans size 0");
        StringBuilder sb = new StringBuilder(booleans.length);
        for (int j = 0; j < booleans.length; j++) {
            if (booleans[j])
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }

}
