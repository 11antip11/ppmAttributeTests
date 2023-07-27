package ru.comindware.API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTaskModel {
    private String taskId;
    private boolean completeSubtasks;

    public UserTaskModel(String taskId, boolean completeSubtasks) {
        this.taskId = taskId;
        this.completeSubtasks = completeSubtasks;
    }

    public UserTaskModel(String taskId) {
        this.taskId = taskId;
    }
}
