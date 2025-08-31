package pl.pjaworski.jdgtaxes.application.incometax;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationChosenEvent;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationType;
import pl.pjaworski.jdgtaxes.domain.InvoiceIssuedEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

import java.math.BigDecimal;

import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.PROGRESSIVE_TAX_SCALE;

@Component
@RequiredArgsConstructor
class IncomeTaxProjector {
    private final TaxPayerEvents taxPayerEvents;

    IncomeTaxReadModel calculateIncomeTax(IncomeTaxQuery query) {
        return new IncomeTaxReadModel(BigDecimal.ZERO);
    }
}
