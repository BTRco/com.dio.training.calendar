import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Класс CalendarServiceImpl реализует интерфейс CalendarService
 * Дает доступ к функция работы с календарем
 */

public class CalendarServiceImpl implements CalendarService {

    private final DataStorage dataStorageImpl;

    public CalendarServiceImpl(DataStorage dataStorageImpl) {
        this.dataStorageImpl = dataStorageImpl;
    }


    /**
     * Реализация метода поиска в хранилище событий событие по параметру "title"
     * @param title - параметр по которому будет совершен поиск
     * @return найденное событие
     */

    @Override
    public Event findEventByTitle(String title) {
        return dataStorageImpl.getEventByTitle(title);
    }

    /**
     * Реализация метода поиска в хранилище событий событие по параметру "id", который является также ключом в паре ключ-значение
     *                 хранилища событий, реализованного при помощи HashMap
     * @param id - параметр по которому будет совершен поиск
     * @return найденное событие
     */

    @Override
    public Event findEventById(UUID id) {
            return dataStorageImpl.getEventById(id);
    }

    /**
     * Реализация метода добавления события в календарь
     * @param newEventToAdd событие для добавления
     */

    @Override
    public void addNewEventToCalendar(Event newEventToAdd) {
        dataStorageImpl.publish(newEventToAdd);
    }

    /**
     * Реализация метода удаления события из календаря
     * @param title - параметр(title), по которому будет совершен поиск удаляемого события в хранилище событий
     */

    @Override
    public Event removeEventFromCalendar(String title) {
            return dataStorageImpl.remove(title);
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

        addNewEventToCalendar(newCreatedEvent);

        return newCreatedEvent;
    }

    public Event createNewEvent(){
        Event newCreatedEvent = new Event.Builder()
                .build();

        addNewEventToCalendar(newCreatedEvent);

        return newCreatedEvent;
    }

}