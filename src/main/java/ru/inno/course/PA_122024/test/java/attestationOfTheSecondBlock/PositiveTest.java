package attestationOfTheSecondBlock;

import model.Player;
import org.junit.jupiter.api.*;
import service.PlayerService;
import service.PlayerServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;

public class PositiveTest {

    private PlayerService playerService;

    @BeforeEach// Аннотация для одинакового предусловия
    public void setUp() throws IOException {
        playerService = new PlayerServiceImpl();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Добавить игрока - проверить наличие в списке")
    void testAddPlayer() {

        String nickname = "TestPlayer";

        int playerId = playerService.createPlayer(nickname);
        Player player = playerService.getPlayerById(playerId);

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(playerId);
        assertThat(player.getNick()).isEqualTo(nickname);
        assertThat(player.getPoints()).isEqualTo(0);
        assertThat(player.isOnline()).isTrue();
        assertThat(playerService.getPlayers()).contains(player);
    }

    @Test
    @Tag("Positive")
    @DisplayName("(добавить игрока) - удалить игрока - проверить отсутствие в списке")
    void testDeletePlayer() {

        String nickname = "TestPlayer";
        int playerId = playerService.createPlayer(nickname);

        Player deletedPlayer = playerService.deletePlayer(playerId);

        assertThat(deletedPlayer).isNotNull();
        assertThat(deletedPlayer.getId()).isEqualTo(playerId);
        assertThat(deletedPlayer.getNick()).isEqualTo(nickname);
        assertThat(playerService.getPlayers()).doesNotContain(deletedPlayer);
    }

    @Test
    @Tag("Positive")
    @DisplayName("(нет json-файла) добавить игрока")
    void testAddPlayerWithoutJsonFile() {

        String nickname = "TestPlayer";

        int playerId = playerService.createPlayer(nickname);
        Player player = playerService.getPlayerById(playerId);

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(playerId);
        assertThat(player.getNick()).isEqualTo(nickname);
        assertThat(player.getPoints()).isEqualTo(0);
        assertThat(player.isOnline()).isTrue();
        assertThat(playerService.getPlayers()).contains(player);
    }

    @Test
    @Tag("Positive")
    @DisplayName("(есть json-файл) добавить игрока")
    void testAddPlayerWithJsonFile() {

        String nickname = "TestPlayer";

        int playerId = playerService.createPlayer(nickname);
        Player player = playerService.getPlayerById(playerId);

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(playerId);
        assertThat(player.getNick()).isEqualTo(nickname);
        assertThat(player.getPoints()).isEqualTo(0);
        assertThat(player.isOnline()).isTrue();
        assertThat(playerService.getPlayers()).contains(player);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Начислить баллы существующему игроку")
    void testAddPointsToExistingPlayer() {

        String nickname = "TestPlayer";
        int playerId = playerService.createPlayer(nickname);
        int points = 50;

        int newPoints = playerService.addPoints(playerId, points);

        assertThat(newPoints).isEqualTo(points);
        Player player = playerService.getPlayerById(playerId);
        assertThat(player.getPoints()).isEqualTo(points);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Добавить очков поверх существующих")
    void testAddPointsOverExistingPoints() {
        // Arrange
        String nickname = "TestPlayer";
        int playerId = playerService.createPlayer(nickname);
        int initialPoints = 50;
        int additionalPoints = 30;

        playerService.addPoints(playerId, initialPoints);
        int newPoints = playerService.addPoints(playerId, additionalPoints);

        assertThat(newPoints).isEqualTo(initialPoints + additionalPoints);
        Player player = playerService.getPlayerById(playerId);
        assertThat(player.getPoints()).isEqualTo(initialPoints + additionalPoints);
    }

    @Test
    @Tag("Positive")
    @DisplayName("(добавить игрока) - получить игрока по id")
    void testGetPlayerById() {

        String nickname = "TestPlayer";
        int playerId = playerService.createPlayer(nickname);

        Player player = playerService.getPlayerById(playerId);

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(playerId);
        assertThat(player.getNick()).isEqualTo(nickname);
        assertThat(player.getPoints()).isEqualTo(0);
        assertThat(player.isOnline()).isTrue();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверить корректность сохранения в файл")
    void testSavePlayersToFile() {

        String nickname1 = "TestPlayer1";
        String nickname2 = "TestPlayer2";
        int playerId1 = playerService.createPlayer(nickname1);
        int playerId2 = playerService.createPlayer(nickname2);

        playerService.addPoints(playerId1, 50);
        playerService.addPoints(playerId2, 75);

        Collection<Player> savedPlayers = playerService.getPlayers();
        assertThat(savedPlayers).hasSize(2);
        assertThat(savedPlayers).extracting(Player::getId).containsExactlyInAnyOrder(playerId1, playerId2);
        assertThat(savedPlayers).extracting(Player::getNick).containsExactlyInAnyOrder(nickname1, nickname2);
        assertThat(savedPlayers).extracting(Player::getPoints).containsExactly(50, 75);
        assertThat(savedPlayers).extracting(Player::isOnline).containsExactly(true, true);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверить корректность загрузки json-файла")
    void testLoadPlayersFromJsonFile() {

        String nickname1 = "TestPlayer1";
        String nickname2 = "TestPlayer2";
        int playerId1 = playerService.createPlayer(nickname1);
        int playerId2 = playerService.createPlayer(nickname2);
        playerService.addPoints(playerId1, 50);
        playerService.addPoints(playerId2, 75);

        Collection<Player> loadedPlayers = playerService.getPlayers();

        assertThat(loadedPlayers).hasSize(2);
        assertThat(loadedPlayers).extracting(Player::getId).containsExactlyInAnyOrder(playerId1, playerId2);
        assertThat(loadedPlayers).extracting(Player::getNick).containsExactlyInAnyOrder(nickname1, nickname2);
        assertThat(loadedPlayers).extracting(Player::getPoints).containsExactly(50, 75);
        assertThat(loadedPlayers).extracting(Player::isOnline).containsExactly(true, true);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверить, что id всегда уникальный")
    void testUniquePlayerIds() {

        String nickname1 = "TestPlayer1";
        String nickname2 = "TestPlayer2";
        String nickname3 = "TestPlayer3";
        String nickname4 = "TestPlayer4";
        String nickname5 = "TestPlayer5";
        String nickname6 = "TestPlayer6";

        int playerId1 = playerService.createPlayer(nickname1);
        int playerId2 = playerService.createPlayer(nickname2);
        int playerId3 = playerService.createPlayer(nickname3);
        int playerId4 = playerService.createPlayer(nickname4);
        int playerId5 = playerService.createPlayer(nickname5);
        playerService.deletePlayer(playerId3);
        int playerId6 = playerService.createPlayer(nickname6);

        assertThat(playerId1).isEqualTo(1);
        assertThat(playerId2).isEqualTo(2);
        assertThat(playerId3).isEqualTo(3);
        assertThat(playerId4).isEqualTo(4);
        assertThat(playerId5).isEqualTo(5);
        assertThat(playerId6).isEqualTo(6);
    }

    @Test
    @Tag("Positive")
    @DisplayName("(нет json-файла) запросить список игроков")
    void testGetPlayersWithoutJsonFile() {

        Collection<Player> players = playerService.getPlayers();
        assertThat(players).isEmpty();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверить создание игрока с 15 символами")
    void testCreatePlayerWithMaxNicknameLength() {

        String nickname = "123456789012345";

        int playerId = playerService.createPlayer(nickname);
        Player player = playerService.getPlayerById(playerId);

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(playerId);
        assertThat(player.getNick()).isEqualTo(nickname);
        assertThat(player.getPoints()).isEqualTo(0);
        assertThat(player.isOnline()).isTrue();
    }

    @AfterEach // Аннотация для одинакового ПОСТУСЛОВИЯ (ПОСЛЕ ТЕСТОВ).
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("./data.json")); // Постусловие. Удаление файла
    }

}
