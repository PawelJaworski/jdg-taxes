package pl.pjaworski.jdgtaxes.testutil

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.pjaworski.jdgtaxes.application.chooseformoftaxation.ChooseFormOfTaxationHandler
import pl.pjaworski.jdgtaxes.application.chooseformoftaxation.ChooseFormOfTaxationHandlerAbility
import pl.pjaworski.jdgtaxes.application.incometax.IncomeTaxProjector
import pl.pjaworski.jdgtaxes.application.incometax.IncomeTaxProjectorAbility
import pl.pjaworski.jdgtaxes.application.issueinvoice.IssueInvoiceHandler
import pl.pjaworski.jdgtaxes.application.issueinvoice.IssueInvoiceHandlerAbility
import pl.pjaworski.jdgtaxes.domain.TaxPayerEvents
import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility
import spock.lang.Specification

@ActiveProfiles('test')
@SpringBootTest
class AbstractIntegrationTest extends Specification implements ChooseFormOfTaxationHandlerAbility, IssueInvoiceHandlerAbility,
        IncomeTaxProjectorAbility, TaxPayerEventsAbility, TestDataExamples {

    @Autowired
    ChooseFormOfTaxationHandler chooseFormOfTaxationHandler

    @Autowired
    IssueInvoiceHandler issueInvoiceHandler

    @Autowired
    IncomeTaxProjector incomeTaxProjector

    @Autowired
    TaxPayerEvents taxPayerEvents

    def setup() {
        cleanupTaxPayerEvents()
    }
}
