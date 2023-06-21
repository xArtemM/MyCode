package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @MethodSource("countryArguments")
    public void paramTestIp(Country countryArguments, String locale) {
        // given:
        LocalizationService localizationService = new LocalizationServiceImpl();

        // when:
        String resultLocale = localizationService.locale(countryArguments);

        // then:
        Assertions.assertEquals(resultLocale, locale);


    }

    private static Stream<Arguments> countryArguments() {
        return Stream.of(Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome"));
    }
}
