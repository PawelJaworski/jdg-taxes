package pl.pjaworski.jdgtaxes.testutil

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.pjaworski.jdgtaxes.application.chooseformoftaxation.ChooseFormOfTaxationHandlerAbility
import pl.pjaworski.jdgtaxes.application.incometax.IncomeTaxProjectorAbility
import pl.pjaworski.jdgtaxes.application.issueinvoice.IssueInvoiceHandlerAbility
import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility
import spock.lang.Specification

@ActiveProfiles('test')
@SpringBootTest
class AbstractIntegrationTest extends Specification implements ChooseFormOfTaxationHandlerAbility, IssueInvoiceHandlerAbility,
        IncomeTaxProjectorAbility, TaxPayerEventsAbility {

    def setup() {
        cleanupTaxPayerEvents()
    }
}
