import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Тесты для методов класса @DataStorageImpl
 */

public class DataStorageImplTest {

    /**
     * Насколько я понял - mock тесты для этого класса не нужны.
     *
     */


        /**
         * Тест для метода publish - добавление нового события в хранилище данных.
         *
         * @throws Exception
         */
        @Test
        public void testPublish() throws Exception {

            DataStorageImpl dataStorage = new DataStorageImpl();

            Event event = new Event.Builder()
                    .description("First event bla bla bla")
                    .startDateTime(LocalDateTime.of(2014, 07, 10, 21, 05))
                    .attenders(new ArrayList<>())
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                    .title("First event")
                    .build();

            DataStorageImpl expectedDataStorage = new DataStorageImpl(event);

            dataStorage.publish(event);

            Assert.assertEquals(expectedDataStorage, dataStorage);
        }


        /**
         * Тест для метода remove - удаление события из хранилища данных(поиск по параметру title).
         *
         * @throws Exception
         */
        @Test
        public void testRemove() throws Exception {

            Event event = new Event.Builder()
                    .description("First event bla bla bla")
                    .startDateTime(LocalDateTime.of(2014, 07, 10, 21, 05))
                    .attenders(new ArrayList<>())
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                    .title("First event")
                    .build();

            DataStorageImpl dataStorage = new DataStorageImpl(event);

            DataStorageImpl expectedDataStorage = new DataStorageImpl();

            dataStorage.remove("First event");

            Assert.assertEquals(expectedDataStorage, dataStorage);
        }


        /**
         * Тест для метода getEventById - поиск события в хранилище данных по параметру id.
         *
         * @throws Exception
         */
        @Test
        public void testGetEventById() throws Exception {

            Event expectedEvent = new Event.Builder()
                    .description("First event bla bla bla")
                    .startDateTime(LocalDateTime.of(2014, 07, 10, 21, 05))
                    .attenders(new ArrayList<>())
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                    .title("First event")
                    .build();

            DataStorage dataStorage = new DataStorageImpl(expectedEvent);

            Event findedEvent = dataStorage.getEventById(UUID.fromString("00000000-0000-0000-0000-000000000001"));

            Assert.assertEquals(expectedEvent, findedEvent);
        }

        /**
         * Тест для метода getEventByTitle - поиск события в хранилище данных по параметру title.
         *
         * @throws Exception
         */
        @Test
        public void testGetEventByTitle() throws Exception {

            Event expectedEvent = new Event.Builder()
                    .description("First event bla bla bla")
                    .startDateTime(LocalDateTime.of(2014, 07, 10, 21, 05))
                    .attenders(new ArrayList<>())
                    .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
                    .title("First event")
                    .build();

            DataStorage dataStorage = new DataStorageImpl(expectedEvent);

            Event findedEvent = dataStorage.getEventByTitle("First event");

            Assert.assertEquals(expectedEvent, findedEvent);
        }

    }

