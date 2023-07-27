package ru.comindware.API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessObjectModel {
    private String processAppId;
    private String objectName;
    private Map<String, String> objectData;
    private int syncActivityQuantity;

    public ProcessObjectModel(String processAppId, String objectName, Map<String, String> objectData, int syncActivityQuantity) {
        this.processAppId = processAppId;
        this.objectName = objectName;
        this.objectData = objectData;
        this.syncActivityQuantity = syncActivityQuantity;
    }
}