import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CalendarServiceTest {

    @Test
    public void testAddEvent() throws Exception{
        String description = "";
        LocalDateTime startDateTime = LocalDateTime.of(2014, 07, 21, 18, 00);
        ArrayList<Person> attenders = new ArrayList<>();
        String title = "  ss";

        Event newCreatedEvent = new Event.Builder()
                .description(description)
                .startDateTime(startDateTime)
                .attenders(attenders)
                .title(title)
                .build();

        CalendarService dataStore = Mockito.mock(CalendarService.class);

        CalendarService service = new CalendarService();

        service.addNewEventToCalendar(new Event.Builder()
                .description("")
                .startDateTime(LocalDateTime.of(2014, 07, 21, 18, 00))
                .attenders(new ArrayList<>())
                .title("  ss")
                .build());

        Mockito.verify(dataStore).addNewEventToCalendar(newCreatedEvent);
    }
}