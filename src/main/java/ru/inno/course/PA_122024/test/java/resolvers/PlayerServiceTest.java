package resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import helpers.MyTestWatcher;
import helpers.Players;
import java.util.Collection;

import model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import resolvers.CatalogServiceResolver;
import resolvers.PlayerServiceResolver;
import service.CatalogService;
import service.PlayerService;

@ExtendWith(MyTestWatcher.class)
@ExtendWith({PlayerServiceResolver.class, CatalogServiceResolver.class})
public class PlayerServiceTest {

    @Test
    @DisplayName("Открытие пустого файла")
    public void canOpenEmptyFile(@Players(0) PlayerService service, CatalogService catalogService) {
        System.out.println("тест");
        Collection<Player> players = service.getPlayers();
        assertEquals(0, players.size());
    }

    @Test
    @DisplayName("Открытие файла с 100 пользователей")
    public void canOpenFilledFile(@Players(100)PlayerService service) {
        Collection<Player> players = service.getPlayers();

        assertEquals(99, players.size(), "Проверка количества пользователей");
        assertTrue(players.size() == 33);
    }
}
