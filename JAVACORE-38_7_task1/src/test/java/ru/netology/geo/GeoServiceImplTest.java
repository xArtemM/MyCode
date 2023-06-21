package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class GeoServiceImplTest {


    @ParameterizedTest
    @MethodSource("ipArguments")
    public void paramTestIp(String ipArguments, Location locationExpected) {
        // given:
        GeoService geoService = new GeoServiceImpl();

        // when:
        Location resultLocation = geoService.byIp(ipArguments);

        // then:
        Assertions.assertEquals(locationExpected.getCountry(), resultLocation.getCountry());
        Assertions.assertEquals(locationExpected.getCity(), resultLocation.getCity());
        Assertions.assertEquals(locationExpected.getStreet(), resultLocation.getStreet());
        Assertions.assertEquals(locationExpected.getBuiling(), resultLocation.getBuiling());
        //Как реализовать сравнение объектов, а не полей?
        //Через equals показывает разные ссылки на объекты,
        //через хэш-код разные хеши..

    }

    private static Stream<Arguments> ipArguments() {
        return Stream.of(Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.0.0.1", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.0.0.1", new Location("New York", Country.USA, null, 0)));
    }

}
