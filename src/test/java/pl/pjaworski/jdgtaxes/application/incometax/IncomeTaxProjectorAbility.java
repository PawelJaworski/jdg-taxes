package pl.pjaworski.jdgtaxes.application.incometax;

import java.time.YearMonth;
import java.util.function.Predicate;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface IncomeTaxProjectorAbility {
    IncomeTaxProjector INSTANCE = new IncomeTaxProjector();

    default boolean assert_income_tax(YearMonth yearMonth, Predicate<IncomeTaxReadModel> predicate) {
        var query = new IncomeTaxQuery(NIP, yearMonth);
        return assert_income_tax(query, predicate);
    }

    default boolean assert_income_tax(IncomeTaxQuery query, Predicate<IncomeTaxReadModel> expected) {
        var actual =  getIncomeTaxQuery().calculateIncomeTax(query);

        return expected.test(actual);
    }

    default IncomeTaxProjector getIncomeTaxQuery() {
        return INSTANCE;
    }
}