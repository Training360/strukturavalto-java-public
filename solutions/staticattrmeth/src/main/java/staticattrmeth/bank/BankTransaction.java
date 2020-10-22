package staticattrmeth.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTransaction {

    private static final long MIN_TRX_VALUE = 1;
    private static final long MAX_TRX_VALUE = 10_000_000;
    private static long countTrx = 0;
    private static BigDecimal sumOfTrxs = new BigDecimal("0");
    private static long currentMinValue = MAX_TRX_VALUE;
    private static long currentMaxValue = MIN_TRX_VALUE;

    private long trxValue;

    public BankTransaction(long trxValue) {
        if (trxValue <= MIN_TRX_VALUE && trxValue >= MAX_TRX_VALUE) {
            throw new IllegalArgumentException("This transaction cannot be excepted! " + trxValue);
        }
        countTrx++;
        sumOfTrxs = sumOfTrxs.add(new BigDecimal(Long.toString(trxValue)));
        if (trxValue < currentMinValue) currentMinValue = trxValue;
        if (trxValue > currentMaxValue) currentMaxValue = trxValue;
        this.trxValue = trxValue;
    }

    public static void initTheDay() {
        countTrx = 0;
        sumOfTrxs = new BigDecimal("0");
        currentMinValue = MAX_TRX_VALUE;
        currentMaxValue = MIN_TRX_VALUE;
    }

    public static BigDecimal averageOfTransaction() {
        return countTrx == 0 ? new BigDecimal("0") : sumOfTrxs.divide(new BigDecimal(Long.toString(countTrx)), 0, RoundingMode.HALF_UP);
    }

    public static long getCurrentMinValue() {
        return countTrx == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return countTrx == 0 ? 0 : currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public long getTrxValue() {
        return trxValue;
    }
}
