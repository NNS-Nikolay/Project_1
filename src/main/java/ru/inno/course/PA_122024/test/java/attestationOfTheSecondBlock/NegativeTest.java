package attestationOfTheSecondBlock;

import org.junit.jupiter.api.*;
import service.PlayerServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NegativeTest {

    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setUp() throws IOException {
        playerService = new PlayerServiceImpl();
    }

    @Test
    @Tag("Negative")
    @DisplayName("удалить игрока, которого нет - удалить игрока 10, хотя последний - 8")
    void shouldThrowExceptionWhenDeletingNonExistentPlayer() {
        assertThrows(NoSuchElementException.class, () -> playerService.deletePlayer(10));
    }

    @Test
    @Tag("Negative")
    @DisplayName("создать дубликат (имя уже занято)")
    void shouldThrowExceptionWhenLoadingDuplicatePlayersFromFile() throws IOException {
        String nickname = "TestPlayer3";
        playerService.createPlayer(nickname);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            playerService.createPlayer(nickname);
        });

        String expectedMessage = "Nickname is already in use: " + nickname;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @Tag("Negative")
    @DisplayName("получить игрока по id, которого нет")
    void shouldThrowExceptionWhenGettingNonExistentPlayer() {
        assertThrows(NoSuchElementException.class, () -> playerService.getPlayerById(10));
    }

    @Test
    @Tag("Negative")
    @DisplayName("сохранить игрока с пустым ником")
    @Disabled("Тест временно выключен из-за бага (jira.com/task-5152)")
    void shouldThrowExceptionWhenSavingPlayerWithEmptyNickname() {
        assertThrows(IllegalArgumentException.class, () -> playerService.createPlayer(""));
    }

    @Test
    @Tag("Negative")
    @DisplayName("начислить отрицательное число очков")
    @Disabled("Тест временно выключен из-за бага (jira.com/task-5050)")
    void shouldThrowExceptionWhenAddingNegativePoints() {
        int id = playerService.createPlayer("John");
        assertThrows(IllegalArgumentException.class, () -> playerService.addPoints(id, -10));
    }

    @Test
    @Tag("Negative")
    @DisplayName("Накинуть очков игроку, которого нет")
    void shouldThrowExceptionWhenAddingPointsToNonExistentPlayer() {
        assertThrows(NoSuchElementException.class, () -> playerService.addPoints(10, 10));
    }

    @Test
    @Tag("Negative")
    @DisplayName("Проверить создание игрока с 16 символами")
    @Disabled("Тест временно выключен из-за бага (jira.com/task-5566)")
    void shouldThrowExceptionWhenCreatingPlayerWithTooLongNickname() {
        String longNickname = "abcdefghijklmnop";
        assertThrows(IllegalArgumentException.class, () -> playerService.createPlayer(longNickname));
    }


    @AfterEach
// Аннотация для одинакового ПОСТУСЛОВИЯ (ПОСЛЕ ТЕСТОВ). Главная особенность, что данная аннотация выполняется,
    // даже если тест падает. Т.е. если в нашем случае тест упадёт, то метод сработает и файл будет удалён
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("./data.json")); // Постусловие
    }
}
