package pl.pjaworski.jdgtaxes.testutil

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles('test')
@SpringBootTest
class AbstractIntegrationTest extends Specification {
}
