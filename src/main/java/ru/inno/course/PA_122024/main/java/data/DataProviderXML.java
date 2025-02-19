package ru.inno.course.PA_122024.main.java.data;

//import model.Player;
import ru.inno.course.PA_122024.main.java.model.Player;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

// научить работать с xml

public class DataProviderXML implements DataProvider{

        private final static Path FILEPATH = Path.of("./data.xml");
        @Override
        public void save(Collection players) throws IOException {

        }

        @Override
        public void save(Collection collection) throws IOException {

        }

        @Override
        public Collection<Player> load() throws IOException {
            return new ArrayList<>();
        }
}
