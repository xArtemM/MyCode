import tax.*;

import java.math.BigDecimal;

//Не совсем поняно из задания нужно ли реализовывать
//интерфейс для пользователя через терминал?
//И если нужно, то как он должен работать?

public class Main {
    public static void main(String[] args) {

        BigDecimal amount[] = new BigDecimal[] {
            new BigDecimal(124.52),
            new BigDecimal(103.34)
        };

        TaxType taxType[] = new TaxType[] {
            new TaxType(),
            new IncomeTaxType(),
            new VATaxType(),
            new ProgressiveTaxType()
        };

        TaxService taxService = new TaxService();

        Bill[] payments = new Bill[]{
            new Bill(amount[0],taxType[1],taxService),
            new Bill(amount[1],taxType[3], taxService)
        };

        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}