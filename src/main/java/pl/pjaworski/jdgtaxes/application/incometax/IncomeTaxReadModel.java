package pl.pjaworski.jdgtaxes.application.incometax;

import java.time.YearMonth;

public record IncomeTaxReadModel(String nip, YearMonth month) {
}
