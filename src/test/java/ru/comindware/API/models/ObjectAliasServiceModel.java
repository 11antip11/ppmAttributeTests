package ru.comindware.API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectAliasServiceModel {
    private String objectAppAlias;
    private Map<String, String> objectData;

    public ObjectAliasServiceModel(String objectAppAlias, Map<String, String> objectData) {
        this.objectAppAlias = objectAppAlias;
        this.objectData = objectData;
    }
}
