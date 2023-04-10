package ru.netology.taskManager.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {
    @Test
    public void shouldMatchesSuitableQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = String.valueOf(true);
        String actual = String.valueOf(simpleTask.matches("Позвонить родителям"));
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesUnSuitableQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = String.valueOf(false);
        String actual = String.valueOf(simpleTask.matches("Позвонить бабушке"));
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesSuitableFirstQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String expected = String.valueOf(true);
        String actual = String.valueOf(epic.matches("Молоко"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSuitableTwoQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String expected = String.valueOf(true);
        String actual = String.valueOf(epic.matches("Яйца"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSuitableThreeQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String expected = String.valueOf(true);
        String actual = String.valueOf(epic.matches("Хлеб"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesUnSuitableQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String expected = String.valueOf(false);
        String actual = String.valueOf(epic.matches("Колбаса"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSuitableQueryMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = String.valueOf(true);
        String actual = String.valueOf(meeting.matches("Выкатка 3й версии приложения"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSuitableQueryMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = String.valueOf(true);
        String actual = String.valueOf(meeting.matches("Приложение НетоБанка"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesUnSuitableQueryMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = String.valueOf(false);
        String actual = String.valueOf(meeting.matches("Во вторник после обеда"));

        Assertions.assertEquals(expected, actual);
    }
}
