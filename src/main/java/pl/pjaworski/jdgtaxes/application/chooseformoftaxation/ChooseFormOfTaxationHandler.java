package pl.pjaworski.jdgtaxes.application.chooseformoftaxation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationChosenEvent;
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents;

@Component
@RequiredArgsConstructor
class ChooseFormOfTaxationHandler {
    private final TaxPayerEvents taxPayerEvents;

    void chooseFormOfTaxation(ChooseFormOfTaxationCmd cmd) {

    }
}
