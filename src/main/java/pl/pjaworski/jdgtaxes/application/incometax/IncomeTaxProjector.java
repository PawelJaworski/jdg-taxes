package pl.pjaworski.jdgtaxes.application.incometax;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationChosenEvent;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationType;
import pl.pjaworski.jdgtaxes.domain.InvoiceIssuedEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.List;

@Component
@RequiredArgsConstructor
class IncomeTaxProjector {
    public static final String LUMP_SUM_12_PERCENTAGE = "0.12";
    private final TaxPayerEvents taxPayerEvents;

    IncomeTaxReadModel calculateIncomeTax(IncomeTaxQuery query) {
        String nip = query.nip();

        List<FormOfTaxationChosenEvent> formEvents = taxPayerEvents.findByNipAndType(nip, FormOfTaxationChosenEvent.class);
        FormOfTaxationType form = formEvents.isEmpty() ? null : formEvents.get(formEvents.size() - 1).formOfTaxation();

        if (form != FormOfTaxationType.LUMP_SUM_12) {
            return new IncomeTaxReadModel(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));
        }

        List<InvoiceIssuedEvent> invoices = taxPayerEvents.findByNipAndType(nip, InvoiceIssuedEvent.class);
        YearMonth month = query.month();

        BigDecimal base = invoices.stream()
                .filter(e -> YearMonth.from(e.invoiceDate()).equals(month))
                .map(InvoiceIssuedEvent::amountNet)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = calculateLumpSum12(base);

        return new IncomeTaxReadModel(tax);
    }

    private static BigDecimal calculateLumpSum12(BigDecimal base) {
        return base.multiply(new BigDecimal(LUMP_SUM_12_PERCENTAGE))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
