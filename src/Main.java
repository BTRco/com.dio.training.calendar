import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        List<Person> attenders = new ArrayList<>();
        List<Person> attend = new ArrayList<>();

        Person person1 = new Person.Builder()
                .personName("Bogdan")
                .personAddress("Kiv")
                .eMail("skobogdan@gmail.com")
                .personAge(23)
                .build();

        Person person2 = new Person.Builder()
                .personName("Bogdan")
                .personAddress("Kiv")
                .eMail("skobogdan@gmail.com")
                .personAge(23)
                .build();

        Person person3 = new Person.Builder()
                .personName("Bogdan")
                .personAddress("Kiv")
                .eMail("skobogdan@gmail.com")
                .personAge(23)
                .build();

        attenders.add(person1);
        attenders.add(person2);
        attenders.add(person3);

        attend.add(person2);

        CalendarService calendarService = new CalendarService();

        Event event = calendarService.createNewEvent("First event very very big description", LocalDateTime.of(2014, 07, 21, 18, 00), attenders, UUID.randomUUID(), "First event");
        Event event1 = calendarService.createNewEvent("Second event very very big description", LocalDateTime.of(2014, 07, 21, 18, 00), attenders, UUID.randomUUID(), "Second event");

        calendarService.addNewEventToCalendar(event);
        calendarService.addNewEventToCalendar(event1);
        Event ev = calendarService.findEventByTitle(event1.getTitle());
        System.out.println(ev.toString());


    }
}
