package tax;

import java.math.BigDecimal;

public class IncomeTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        BigDecimal div = new BigDecimal(100);
        BigDecimal mul = new BigDecimal(13);
        BigDecimal tmp = amount.divide(div);
        return tmp.multiply(mul);
    }
}
