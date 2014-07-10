import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;



public class CalendarServiceImplTest {


    @Test
    public void testCreateNewEvent_WithoutParameters() throws Exception{

        DataStorageImpl dataStorage = new DataStorageImpl();
        CalendarServiceImpl calendarService = new CalendarServiceImpl(dataStorage);

        Event event = calendarService.createNewEvent();
        Event exceptedEvent = calendarService.createNewEvent("Default description", LocalDateTime.of(1970, 01, 01, 00, 00), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000000"), "Default title");

        Assert.assertEquals(event, exceptedEvent);
    }

    @Test
    public void testCreateNewEvent_WithAllParameters() throws Exception{

        DataStorageImpl dataStorage = new DataStorageImpl();
        CalendarServiceImpl calendarService = new CalendarServiceImpl(dataStorage);

        Event event = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }

    @Test
    public void testFindEventByTitle() throws Exception{

        DataStorageImpl dataStorage = new DataStorageImpl();
        CalendarServiceImpl calendarService = new CalendarServiceImpl(dataStorage);

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.findEventByTitle("First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }

    @Test
    public void testFindEventById() throws Exception{

        DataStorageImpl dataStorage = new DataStorageImpl();
        CalendarServiceImpl calendarService = new CalendarServiceImpl(dataStorage);

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.findEventById(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }

    @Test
    public void testRemoveEventFromCalendar() throws Exception{

        DataStorageImpl dataStorage = new DataStorageImpl();
        CalendarServiceImpl calendarService = new CalendarServiceImpl(dataStorage);

        calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");
        Event event = calendarService.removeEventFromCalendar("First event");
        Event exceptedEvent = calendarService.createNewEvent("First event big description", LocalDateTime.of(2014, 07, 10, 21, 05), new LinkedList<>(), UUID.fromString("00000000-0000-0000-0000-000000000001"), "First event");

        Assert.assertEquals(event, exceptedEvent);
    }



}