package pl.pjaworski.jdgtaxes.application.incometax;

import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility;

import java.math.BigDecimal;
import java.time.YearMonth;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface IncomeTaxProjectorAbility {
    IncomeTaxProjector INSTANCE = new IncomeTaxProjector(TaxPayerEventsAbility.INSTANCE);

    default IncomeTaxReadModel calculate_income_tax(YearMonth yearMonth) {
        var query = new IncomeTaxQuery(NIP, yearMonth);

        return  getIncomeTaxProjector().calculateIncomeTax(query);
    }

    default IncomeTaxProjector getIncomeTaxProjector() {
        return INSTANCE;
    }
}