package ru.comindware.API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectIdServiceModel {
    private String objectId;
    private Map<String, String> objectData;

    public ObjectIdServiceModel(String objectId, Map<String, String> objectData) {
        this.objectId = objectId;
        this.objectData = objectData;
    }
}
