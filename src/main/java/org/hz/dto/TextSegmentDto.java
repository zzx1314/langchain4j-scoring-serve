package org.hz.dto;

import java.util.Map;

public class TextSegmentDto {
    public String text;
    public Map<String, Object> metadata;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    
}
