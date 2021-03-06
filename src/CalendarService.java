import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Интерфейс Calendar Service
 * Для его реализации необходимо реализовать следующие методы:
 * createNewEvent - создание нового события
 * findEventByTitle - поиск в хранилище событий событие по параметру "title"
 * findEventById - поиск в хранилище событий событие по параметру "id", который является также ключом в паре ключ-значение
 *                 хранилища событий, реализованного при помощи HashMap
 * addNewEventToCalendar - добавление события в календарь
 * removeEventFromCalendar - удаление события из календаря
 */
public interface CalendarService {

    Event createNewEvent(String description, LocalDateTime startDateTime, List<Person> attenders, UUID id, String title, boolean isAllDayEvent);
    Event createNewEvent();
    Event findEventByTitle(String title);
    Event findEventById(UUID id);
    void addNewEventToCalendar(Event newEventToAdd);
    Event removeEventFromCalendar(String title);
    Event findEventByTimeForAttender(LocalDateTime time, Person attender);

}
