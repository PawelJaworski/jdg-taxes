package pl.pjaworski.jdgtaxes.domain;

import lombok.NonNull;

public record FormOfTaxationChosenEvent(@NonNull String nip, @NonNull FormOfTaxationType formOfTaxation) implements TaxPayerEvent {
}
