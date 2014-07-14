import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Позитивные тесты для методов класса @CalendarServiceImpl
 */

public class CalendarServiceImplTest{

    /**
     * начало mock тестирования
     * @throws Exception
     */


    @Test
    public void mockTestCreateNewEvent_WithoutParameters() throws Exception{

        // initialize variable inputs

        LocalDateTime inputStartData = LocalDateTime.of(1970, 01, 01, 00, 00);
        String inputTitle = "Default title";
        String inputDescription = "Default description";
        LinkedList<Person> attenders = new LinkedList<>();
        UUID inputId = UUID.fromString("00000000-0000-0000-0000-000000000000");

        Event expectedEvent = new Event.Builder()
                .build();

        // initialize mocks

        DataStorage dataStorage = mock(DataStorage.class);

        // initialize class to test

        CalendarService calendarService = new CalendarServiceImpl(dataStorage);

        // invoke method on class to test

        calendarService.createNewEvent(inputDescription, inputStartData, attenders, inputId, inputTitle);

        // assert return value

        // verify mock expectations
        verify(dataStorage).publish(expectedEvent);

    }

    @Test
    public void mockTestCreateNewEvent_WithAllParameters() throws Exception{

        // initialize variable inputs

        LocalDateTime inputStartData = LocalDateTime.of(2014, 07, 10, 21, 05);
        String inputTitle = "First event";
        String inputDescription = "First event big description";
        LinkedList<Person> attenders = new LinkedList<>();
        UUID inputId = UUID.fromString("00000000-0000-0000-0000-000000000001");

        Event expectedEvent = new Event.Builder()
                .description(inputDescription)
                .attenders(attenders)
                .id(inputId)
                .title(inputTitle)
                .startDateTime(inputStartData)
                .build();

        // initialize mocks


        DataStorage dataStorage = mock(DataStorage.class);

        // initialize class to test

        CalendarService calendarService = new CalendarServiceImpl(dataStorage);

        // invoke method on class to test

        calendarService.createNewEvent(inputDescription, inputStartData, attenders, inputId, inputTitle);

        // assert return value

        // verify mock expectations
        verify(dataStorage).publish(expectedEvent);
    }

    @Test
    public void mockTestFindEventByTitle() throws Exception{

        // initialize variable inputs

        LocalDateTime inputStartData = LocalDateTime.of(2014, 07, 10, 21, 05);
        String inputTitle = "First event";
        String inputDescription = "First event big description";
        LinkedList<Person> attenders = new LinkedList<>();
        UUID inputId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        String someTitleToFindEvent = "First event";

        Event expectedEvent = new Event.Builder()
                .description(inputDescription)
                .attenders(attenders)
                .id(inputId)
                .title(inputTitle)
                .startDateTime(inputStartData)
                .build();

        // initialize mocks


        DataStorage dataStorage = mock(DataStorage.class);
        when(dataStorage.getEventByTitle(someTitleToFindEvent)).thenReturn(expectedEvent);

        // initialize class to test

        CalendarService calendarService = new CalendarServiceImpl(dataStorage);

        // invoke method on class to test

        Event returnedValue = calendarService.findEventByTitle(someTitleToFindEvent);

        // assert return value
        assertEquals(expectedEvent, returnedValue);
        // verify mock expectations

    }

    @Test
    public void mockTestFindEventById() throws Exception{

        // initialize variable inputs

        LocalDateTime inputStartData = LocalDateTime.of(2014, 07, 10, 21, 05);
        String inputTitle = "First event";
        String inputDescription = "First event big description";
        LinkedList<Person> attenders = new LinkedList<>();
        UUID inputId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        UUID someIdToFindEvent = UUID.fromString("00000000-0000-0000-0000-000000000001");

        Event expectedEvent = new Event.Builder()
                .description(inputDescription)
                .attenders(attenders)
                .id(inputId)
                .title(inputTitle)
                .startDateTime(inputStartData)
                .build();

        // initialize mocks


        DataStorage dataStorage = mock(DataStorage.class);
        when(dataStorage.getEventById(someIdToFindEvent)).thenReturn(expectedEvent);

        // initialize class to test

        CalendarService calendarService = new CalendarServiceImpl(dataStorage);

        // invoke method on class to test

        Event returnedValue = calendarService.findEventById(someIdToFindEvent);

        // assert return value
        assertEquals(expectedEvent, returnedValue);
        // verify mock expectations

    }

    @Test
    public void mockTestRemoveEventFromCalendar() throws Exception{

        // initialize variable inputs

        LocalDateTime inputStartData = LocalDateTime.of(2014, 07, 10, 21, 05);
        String inputTitle = "First event";
        String inputDescription = "First event big description";
        LinkedList<Person> attenders = new LinkedList<>();
        UUID inputId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        String someTitleToRemoveEvent = "First event";

        Event expectedEvent = new Event.Builder()
                .description(inputDescription)
                .attenders(attenders)
                .id(inputId)
                .title(inputTitle)
                .startDateTime(inputStartData)
                .build();

        // initialize mocks


        DataStorage dataStorage = mock(DataStorage.class);
        when(dataStorage.remove(someTitleToRemoveEvent)).thenReturn(expectedEvent);

        // initialize class to test

        CalendarService calendarService = new CalendarServiceImpl(dataStorage);

        // invoke method on class to test

        Event returnedValue = calendarService.removeEventFromCalendar(someTitleToRemoveEvent);

        // assert return value
        assertEquals(expectedEvent, returnedValue);
        // verify mock expectations

    }

    /**
     * Конец mock тестирования
     * Я так понимаю, что нужны ли мок тесты, либо jUnit
     */

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


