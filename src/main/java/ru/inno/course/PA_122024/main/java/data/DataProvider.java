package ru.inno.course.PA_122024.main.java.data;


import java.io.IOException;
import java.util.Collection;



public interface DataProvider<Player> {
    void save(Collection<Player> players) throws IOException;

    void save(Collection<Player> players) throws IOException;

    void save(Collection<Player> players) throws IOException;

    Collection<Player> load() throws IOException;

}
