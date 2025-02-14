/*
 * Copyright (c) 2022. Guido Schmutz (schmutz68@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.cedelsb.kafka.connect.smt.converter.types.json;

import org.bson.json.Converter;
import org.bson.json.StrictJsonWriter;
import org.bson.types.Decimal128;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonDecimalConverter implements Converter<Decimal128> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDecimalConverter.class);
    @Override
    public void convert(Decimal128 value, StrictJsonWriter writer) {
        try {
            writer.writeNumber(value.toString());
        } catch (Exception e) {
            LOGGER.error(String.format("Fail to convert offset %d to JSON decimal", value), e);
        }
    }
}
