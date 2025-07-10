package pl.pjaworski.jdgtaxes.application.incometax;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class IncomeTaxProjector {
    IncomeTaxReadModel calculateIncomeTax(IncomeTaxQuery query) {
        return new IncomeTaxReadModel(BigDecimal.ZERO);
    }
}
