import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataStorageImpl implements DataStorage {
    private final Map<UUID, Event> list = new HashMap<>();
    private final Map<String, UUID> titleUuidList = new HashMap<>();
    private final Map<LocalDateTime, UUID> timeUUIDList = new HashMap<>();

    public DataStorageImpl(){

    }

    public DataStorageImpl(Event event){
        list.put(event.getId(), event);
        titleUuidList.put(event.getTitle(), event.getId());
        timeUUIDList.put(event.getStartDateTime(), event.getId());
    }

    @Override
    public void publish(Event event) {
        list.put(event.getId(), event);
        titleUuidList.put(event.getTitle(), event.getId());
        timeUUIDList.put(event.getStartDateTime(), event.getId());
    }

    @Override
    public Event remove(String title) {
        Event event = list.get(titleUuidList.get(title));
        list.remove(titleUuidList.get(title));
        titleUuidList.remove(title);
        return event;
    }

    @Override
    public Event getEventById(UUID id) {
        return (Event) list.get(id);
    }

    @Override
    public Event getEventByTitle(String title){
        return list.get(titleUuidList.get(title));
    }

    @Override
    public Event getEventByTime(LocalDateTime localDateTime){
        return list.get(timeUUIDList.get(localDateTime));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataStorageImpl)) return false;

        DataStorageImpl that = (DataStorageImpl) o;

        if (list != null ? !list.equals(that.list) : that.list != null) return false;
        if (titleUuidList != null ? !titleUuidList.equals(that.titleUuidList) : that.titleUuidList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = list != null ? list.hashCode() : 0;
        result = 31 * result + (titleUuidList != null ? titleUuidList.hashCode() : 0);
        return result;
    }
}
