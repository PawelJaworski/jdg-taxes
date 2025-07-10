package pl.pjaworski.jdgtaxes.application.incometax;

import java.util.function.Predicate;

import static pl.pjaworski.jdgtaxes.testutil.TestDataExamples.NIP;

public interface IncomeTaxQueryAbility {
    IncomeTaxQuery INSTANCE = new IncomeTaxQuery();

    default boolean assert_income_tax(Predicate<IncomeTaxReadModel> predicate) {
        return assert_income_tax(NIP, predicate);
    }

    default boolean assert_income_tax(String nip, Predicate<IncomeTaxReadModel> expected) {
        var actual =  getIncomeTaxQuery().calculateIncomeTaxQuery(nip);

        return expected.test(actual);
    }

    default IncomeTaxQuery getIncomeTaxQuery() {
        return INSTANCE;
    }
}