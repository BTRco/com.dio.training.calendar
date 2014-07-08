import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Класс CalendarService реализует интерфейс iCalendarService
 * Дает доступ к функция работы с календарем
 */

public class CalendarService implements iCalendarService {

    Map list = new HashMap<>();

    /**
     * Реализация метода поиска в хранилище событий событие по параметру "title"
     * @param title - параметр по которому будет совершен поиск
     * @return найденное событие
     */

    @Override
    public Event findEventByTitle(String title) {
        for (Object key : list.keySet()) {
            if (((Event) list.get(key)).getTitle().equals(title)){
                return (Event) list.get(key);
            }
        }

        return null;
    }

    /**
     * Реализация метода поиска в хранилище событий событие по параметру "id", который является также ключом в паре ключ-значение
     *                 хранилища событий, реализованного при помощи HashMap
     * @param id - параметр по которому будет совершен поиск
     * @return найденное событие
     */

    @Override
    public Event findEventById(UUID id) {
        for (Object key : list.keySet()) {
            if (key.equals(id)){
                return (Event) list.get(id);
            }
        }

            return null;
    }

    /**
     * Реализация метода добавления события в календарь
     * @param newEventToAdd событие для добавления
     */

    @Override
    public void addNewEventToCalendar(Event newEventToAdd) {
        list.put(newEventToAdd.getId(), newEventToAdd);
    }

    /**
     * Реализация метода удаления события из календаря
     * @param eventToRemoveFromCalendar - параметр(айди), по которому будет совершен поиск удаляемого события в хранилище событий
     */

    @Override
    public void removeEventFromCalendar(UUID eventToRemoveFromCalendar) {
            if (list.get(eventToRemoveFromCalendar) == null) throw new  NullPointerException("There is no Event with this Id");
            list.remove(eventToRemoveFromCalendar);
    }

    /**
     * Реализация метода создания нового события.
     * @param description - полное описание события
     * @param startDateTime - дата события
     * @param attenders - участники события
     * @param id - уникальный идентификатор события - ключ для HashMap
     * @param title - короткое описание(название) события
     * @return созданное событие
     */

    public Event createNewEvent(String description, LocalDateTime startDateTime, List<Person> attenders, UUID id, String title){
        Event newCreatedEvent = new Event.Builder()
                .description(description)
                .startDateTime(startDateTime)
                .attenders(attenders)
                .id(id)
                .title(title)
                .build();

        return newCreatedEvent;
    }

}