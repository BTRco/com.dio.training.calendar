import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

/**
 * Позитивные тесты для методов класса @CalendarServiceImpl
 */

public class CalendarServiceImplTest {
    /**
     * Метод для создания объекта класса @CalendarServiceImpl для последующего тестирования
     * @return объект класса @CalendarServiceImpl
     */
    public CalendarServiceImpl createCalendarServiceObjectForTesting(){
        DataStorageImpl dataStorage = new DataStorageImpl();
        return new CalendarServiceImpl(dataStorage);

    }

    /**
     * Тест для метода createNewEvent - создание нового события без входящих параметров( default event).
     * Default значения:
     * description = "Default description";
     * startDateTime = LocalDateTime.of(1970, 01, 01, 00, 00);
     * attenders = new LinkedList<>();
     * id = UUID.fromString("00000000-0000-0000-0000-000000000000");
     * title = "Default title";
     * @throws Exception
     */
    @Test
    public void testCreateNewEvent_WithoutParameters() throws Exception{

        CalendarServiceImpl calendarService = createCalendarServiceObjectForTesting();

        Event event = calendarService.createNewEvent();
        Event exceptedEvent = calendarService.createNewEvent("Default description", LocalDateTime.of(1970, 01, 01, 00, 00), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000000"), "Default title");

        Assert.assertEquals(event, exceptedEvent);
    }

    /**
     * Тест для метода createNewEvent - создание нового события со всеми входящими параметрами.
     * @throws Exception
     */
    @Test
    public void testCreateNewEvent_WithAllParameters() throws Exception{

        CalendarServiceImpl calendarService = createCalendarServiceObjectForTesting();

        Event event = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }


    /**
     * Тест для метода findEventByTitle - поиск события по входному параметру title.
     * @throws Exception
     */
    @Test
    public void testFindEventByTitle() throws Exception{

        CalendarServiceImpl calendarService = createCalendarServiceObjectForTesting();

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.findEventByTitle("First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }


    /**
     * Тест для метода findEventById - поиск события по входному параметру id.
     * @throws Exception
     */
    @Test
    public void testFindEventById() throws Exception{

        CalendarServiceImpl calendarService = createCalendarServiceObjectForTesting();

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.findEventById(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }


    /**
     * Тест для метода removeEventFromCalendar - удаление события по входному параметру title.
     * @throws Exception
     */
    @Test
    public void testRemoveEventFromCalendar() throws Exception{

        CalendarServiceImpl calendarService = createCalendarServiceObjectForTesting();

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.removeEventFromCalendar("First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }



}