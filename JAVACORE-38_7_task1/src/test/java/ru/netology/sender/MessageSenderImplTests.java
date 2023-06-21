package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTests {

    @Test
    public void testSendRu() {
        // given:
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.16.5.3"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender sender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<>();
        map.put("x-real-ip", "172.16.5.3");

        // when:
        String resultSend = sender.send(map);

        // then:
        Assertions.assertEquals("Добро пожаловать", resultSend);

    }

    @Test
    public void testSendOther() {
        // given:
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.16.5.3"))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender sender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<>();
        map.put("x-real-ip", "96.16.5.3");

        // when:
        String resultSend = sender.send(map);

        // then:
        Assertions.assertEquals("Welcome", resultSend);

    }
}