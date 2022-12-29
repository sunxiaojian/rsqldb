/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.rsqldb.parser.model.baseType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiLiteral extends Literal<List<Literal<?>>> {
    private List<Literal<?>> literals;

    @JsonCreator
    public MultiLiteral(@JsonProperty("content") String content, @JsonProperty("literals") List<Literal<?>> literals) {
        super(content);
        this.literals = literals;
    }

    public List<Literal<?>> getLiterals() {
        return literals;
    }

    public void setLiterals(List<Literal<?>> literals) {
        this.literals = literals;
    }

    @Override
    public List<Literal<?>> getResult() {
        return literals;
    }
}
