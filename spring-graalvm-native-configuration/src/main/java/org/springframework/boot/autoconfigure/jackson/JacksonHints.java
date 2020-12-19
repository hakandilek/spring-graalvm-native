/*
 * Copyright 2020 the original author or authors.
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
package org.springframework.boot.autoconfigure.jackson;

import org.springframework.nativex.extension.NativeImageConfiguration;
import org.springframework.nativex.extension.NativeImageHint;
import org.springframework.nativex.extension.TypeInfo;
import org.springframework.nativex.type.AccessBits;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ext.Java7HandlersImpl;
import com.fasterxml.jackson.databind.ext.Java7SupportImpl;

@NativeImageHint(trigger = JacksonAutoConfiguration.class, typeInfos = {
		@TypeInfo(types = {JsonIgnore.class, JsonInclude.class,JsonInclude.Include.class},access=AccessBits.CLASS|AccessBits.DECLARED_METHODS),
		@TypeInfo(types = JsonGenerator.class, access = AccessBits.LOAD_AND_CONSTRUCT),
		@TypeInfo(types = Java7HandlersImpl.class, access = AccessBits.LOAD_AND_CONSTRUCT),
		@TypeInfo(types = Java7SupportImpl.class, access = AccessBits.LOAD_AND_CONSTRUCT),
})
public class JacksonHints implements NativeImageConfiguration {
}
