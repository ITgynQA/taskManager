package ru.netology.taskManager.services;

public class Epic extends Task {
    private String[] subtasks;

    public Epic(int id, String[] subtask) {
        super(id);
        this.subtasks = subtask;
    }

    public String[] getSubtask() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String i : subtasks) {
            if (i.contains(query)) {
                return true;
            }
        }
        return false;
    }
}

