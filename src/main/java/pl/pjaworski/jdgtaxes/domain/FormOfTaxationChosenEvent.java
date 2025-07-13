package pl.pjaworski.jdgtaxes.domain;

public record FormOfTaxationChosenEvent(String nip, FormOfTaxationType formOfTaxation) implements TaxPayerEvent {
}
