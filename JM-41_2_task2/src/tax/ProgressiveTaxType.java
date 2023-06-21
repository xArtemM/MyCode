package tax;

import java.math.BigDecimal;

public class ProgressiveTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        int switchCount = 0;
        BigDecimal limit = new BigDecimal(10000);
        BigDecimal div1 = new BigDecimal(100);
        BigDecimal div2 = new BigDecimal(10);
        BigDecimal mul = new BigDecimal(15);
        if (amount.compareTo(limit) >= 0) {
            BigDecimal tmp = amount.divide(div1);
            return tmp.multiply(mul);
        } else {
            return amount.divide(div2);
        }
    }
}