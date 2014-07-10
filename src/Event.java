import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Event {

    private final String description;
    private final LocalDateTime startDateTime;
    private final List<Person> attenders;   //Person do
    private final UUID id;
    private final String title;

    private Event(Builder builder) {
        this.description = builder.description;
        this.startDateTime = builder.startDateTime;
        this.attenders = builder.attenders;
        this.id = builder.id;
        this.title = builder.title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                ", startDateTime=" + startDateTime +
                ", attenders=" + attenders +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (startDateTime != null ? !startDateTime.equals(event.startDateTime) : event.startDateTime != null)
            return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 28;
        int result = 1;
        result = prime * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = prime * result + (attenders != null ? attenders.hashCode() : 0);
        result = prime * result + (id != null ? id.hashCode() : 0);
        result = prime * result + (title != null ? title.hashCode() : 0);
        return result;
    }


    /**
     * Builder class for build Event object
     * Uses to incapsulate Event class, and it's values from outer world.
     * Provide creating Event object with all values, with some values, copying of Event object to new Event object
     */
    public static class Builder{
        private String description;
        private LocalDateTime startDateTime;
        private List<Person> attenders;   //Person do
        private UUID id;
        private String title;


        /**
         * Default constructor
         */
        public Builder() {
            this.description = "Default description";
            this.startDateTime = LocalDateTime.of(1970, 01, 01, 00, 00);
            this.attenders = new LinkedList<>();
            this.id = UUID.fromString("00000000-0000-0000-0000-000000000000");
            this.title = "Default title";
        }

        /**
         * Constructor for copying some Event object with all it's parameters
         * @param original - Event object to copy
         */
        public Builder(Event original) {
            this.description = original.description;
            this.startDateTime = original.startDateTime;
            this.attenders = original.attenders;
            this.id = original.id;
            this.title = original.title;
        }

        /**
         * Method to add on builder object next value:
         * @param description - String value, that will be description of event
         * @return Builder description
         */
        public Builder description(String description){
            if (description == null) throw new NullPointerException("Null-reference");
            this.description = description;
            return this;
        }

        /**
         * Method to add on builder object next value:
         * @param dateTime - LocalDateTime value,
         *                      that will be start date and time of event.
         *                      I'm use LocalDateTime to add full date(year, month, dayOfMonth)
         *                      and1 time(hours, minutes)
         * @return Builder startDateTime
         */
        public Builder startDateTime(LocalDateTime dateTime){
            if (dateTime == null) throw new NullPointerException("Null-reference");
            this.startDateTime = dateTime;
            return this;
        }

        /**
         * Method to add on builder object next value:
         * @param attenders - list of Person class values, that will be list of event attenders
         * @return Builder attenders
         */
        public Builder attenders(List<Person> attenders){
            if (attenders == null) throw new NullPointerException("Null-reference");
            this.attenders = attenders;
            return this;
        }

        /**
         * Method to add on builder object next value:
         * @param id - UUID value, that will be id of event to use in HashMap for quick search of event in calendar
         * @return Builder id
         */
        public Builder id(UUID id){
            if (id == null) throw new NullPointerException("Null-reference");
            this.id = id;
            return this;
        }

        /**
         * Method to add on builder object next value:
         * @param title - String value, that will be small title of event
         * @return Builder title
         */
        public Builder title(String title){
            if (title == null) throw new NullPointerException("Null-reference");
            this.title = title;
            return this;
        }

        /**
         * Method that call private Event constructor to create Event object, and inject builder values to
         * new Event object
         * @return new Event
         */
        public Event build(){
            return new Event(this);
        }


    }
}
