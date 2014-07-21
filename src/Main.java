import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CalendarServiceImpl service = (CalendarServiceImpl) context.getBean("calendarService");

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
                .personAddress("Kiiv")
                .eMail("skobogdan@gmail.com")
                .personAge(23)
                .build();

        Person person3 = new Person.Builder()
                .personName("Bogdan")
                .personAddress("Kiev")
                .eMail("skobogdan@gmail.com")
                .personAge(23)
                .build();

        attenders.add(person1);
        attenders.add(person2);
        attenders.add(person3);

        attend.add(person2);

        Event event = service.createNewEvent("First event very very big description", LocalDateTime.of(2014, 07, 21, 18, 00), attenders, UUID.randomUUID(), "First event", false);
        Event event1 = service.createNewEvent("Second event very very big description", LocalDateTime.of(2014, 06, 21, 18, 00), attend, UUID.randomUUID(), "Second event", true);

        service.addNewEventToCalendar(event);

        service.addNewEventToCalendar(event);
        service.addNewEventToCalendar(event1);
        //Event ev = service.findEventByTitle(event1.getTitle());
        //System.out.println(ev.toString());

        System.out.println(event1);
        System.out.println(service.findEventByTimeForAttender(LocalDateTime.of(2014, 06, 21, 18, 00), person1));
        System.out.println(service.isAttenderFreeInThisTime(LocalDateTime.of(2014, 07, 21, 18, 00), person1));



    }
}
