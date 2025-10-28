package pl.pjaworski.jdgtaxes.application.incometax

import pl.pjaworski.jdgtaxes.testutil.AbstractIntegrationTest

import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.LUMP_SUM_12

class IncomeTaxIntegrationTest extends AbstractIntegrationTest {
    def "should calculate income tax given form of taxation is LUMP SUM 12%"() {
        given:
        choose_form_of_taxation {
            it.formOfTaxation(LUMP_SUM_12)
        }

        issue_invoice {
            it.invoiceDate(SEP_01_2025)
            it.amountNet(28000.00)
        }

        when:
        def tax = calculate_income_tax(SEP_2025).tax()

        then:
        tax == 3360.00
    }
}
