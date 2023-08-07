package ru.comindware.API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolutionModel {
    private String alias;
    private Map<String, String> objectData;

    public SolutionModel(String alias, Map<String, String> objectData) {
        this.alias = alias;
        this.objectData = objectData;
    }
}