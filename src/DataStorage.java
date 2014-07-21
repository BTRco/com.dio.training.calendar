import java.time.LocalDateTime;
import java.util.UUID;

public interface DataStorage {

    void publish(Event event);

    Event remove(String title);

    Event getEventById(UUID id);

    public Event getEventByTitle(String title);

    public Event getEventByTime(LocalDateTime localDateTime);

}
