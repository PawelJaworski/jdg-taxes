package pl.pjaworski.jdgtaxes.application.chooseformoftaxation;

import lombok.Builder;
import lombok.NonNull;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationType;

@Builder
public record ChooseFormOfTaxationCmd(@NonNull String nip, @NonNull FormOfTaxationType formOfTaxation) {
}
