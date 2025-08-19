package pl.pjaworski.jdgtaxes.testutil;

import java.time.LocalDate;
import java.time.YearMonth;

public interface TestDataExamples {
    String NIP = "123-456-32-18";
    LocalDate SEP_01_2025 = LocalDate.parse("2025-09-01");
    YearMonth SEP_2025 = YearMonth.parse("2025-09");
}
