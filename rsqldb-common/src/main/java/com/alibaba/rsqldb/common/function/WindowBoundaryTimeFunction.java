/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.rsqldb.common.function;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WindowBoundaryTimeFunction implements SQLFunction {
    private String fieldName;
    private String asName;

    @JsonCreator
    public WindowBoundaryTimeFunction(@JsonProperty("fieldName")String fieldName, @JsonProperty("asName")String asName) {
        this.fieldName = fieldName;
        this.asName = asName;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public void apply(JsonNode jsonNode, ConcurrentHashMap<String, Object> container) {

    }

    @Override
    public void secondCalcu(ConcurrentHashMap<String, Object> container, Properties context) {
        if (container == null) {
            throw new IllegalArgumentException("would not be null.");
        }

        Object target = context.get(fieldName);

        container.put(asName, target);
    }
}
