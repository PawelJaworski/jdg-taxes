package pl.pjaworski.jdgtaxes.testutil

import pl.pjaworski.jdgtaxes.application.chooseformoftaxation.ChooseFormOfTaxationHandlerAbility
import pl.pjaworski.jdgtaxes.application.incometax.IncomeTaxProjectorAbility
import pl.pjaworski.jdgtaxes.application.issueinvoice.IssueInvoiceHandlerAbility
import pl.pjaworski.jdgtaxes.domain.TaxPayerEventsAbility
import spock.lang.Specification

class AbstractUnitTest extends Specification implements ChooseFormOfTaxationHandlerAbility, IssueInvoiceHandlerAbility,
        IncomeTaxProjectorAbility, TaxPayerEventsAbility, TestDataExamples {

    def setup() {
        cleanupTaxPayerEvents()
    }
}
