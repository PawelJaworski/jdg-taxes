package pl.pjaworski.jdgtaxes.application.chooseformoftaxation;

import lombok.NonNull;
import pl.pjaworski.jdgtaxes.domain.FormOfTaxationType;

public record ChooseFormOfTaxationCmd(@NonNull String nip, @NonNull FormOfTaxationType formOfTaxation) {
}
