package pl.pjaworski.jdgtaxes.application.incometax

import pl.pjaworski.jdgtaxes.domain.FormOfTaxationType
import pl.pjaworski.jdgtaxes.testutil.AbstractUnitTest
import spock.lang.See

import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.LUMP_SUM_12
import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.LUMP_SUM_12
import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.PROGRESSIVE_TAX_SCALE
import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.PROGRESSIVE_TAX_SCALE
import static pl.pjaworski.jdgtaxes.domain.FormOfTaxationType.PROGRESSIVE_TAX_SCALE

/**
 * Lump sum - ryczalt
 * Progressive tax - skala podatkowa
 * Tax-free allowance - kwota wolna od podatku
 */
class IncomeTaxSpecification extends AbstractUnitTest {

    @See("[jira]/JUG-421")
    def "Tax-free allowance is applied given form of taxation is PROGRESSIVE TAX"() {
        given:
        choose_form_of_taxation {
            it.formOfTaxation(PROGRESSIVE_TAX_SCALE)
        }

        issue_invoice {
            it.invoiceDate(AUG_01_2025)
            it.amountNet(15000.00)
        }

        issue_invoice {
            it.invoiceDate(SEP_01_2025)
            it.amountNet(15000.00)
        }

        when:
        def tax = calculate_income_tax(SEP_2025).tax()

        then:
        tax == 0.00
    }

    @See("[gitlab]/lump-sum.json")
    def "api contract"() {
        given:
        choose_form_of_taxation {
            it.formOfTaxation(LUMP_SUM_12)
        }

        issue_invoice {
            it.invoiceDate(SEP_01_2025)
            it.amountNet(28000.00)
        }

        when:
        def tax = calculate_income_tax(SEP_2025)

        then:
        generateJson(tax, "lump-sum.json")
    }
}
