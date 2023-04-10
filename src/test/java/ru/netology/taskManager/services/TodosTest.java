package ru.netology.taskManager.services;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskTitle() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {simpleTask};
        Task[] actual = (todos.search("Позвонить родителям"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskSubtaskOne() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {epic};
        Task[] actual = (todos.search("Молоко"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskSubtaskTwo() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {epic};
        Task[] actual = (todos.search("Яйца"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskSubtaskThree() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {epic};
        Task[] actual = (todos.search("Хлеб"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskTopic() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {meeting};
        Task[] actual = (todos.search("Выкатка 3й версии приложения"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSuitableTaskProject() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {meeting};
        Task[] actual = (todos.search("Приложение НетоБанка"));

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindUnSuitableTask() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = new Task[0];

        Task[] expected = {};
        Task[] actual = (todos.search("Во вторник после обеда"));

        Assertions.assertArrayEquals(expected, actual);
    }
}

