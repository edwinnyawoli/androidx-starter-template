/*
 * Copyright 2018 Edwin Nyawoli
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.edwinnyawoli.templateapplication.common.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 */
public class StringUtils {
    /**
     * @param value
     * @return An empty string if value is null and the value itself if not null.
     */
    public static String emptyIfNull(String value) {
        if (value == null)
            return "";
        else
            return value;
    }

    public static String join(Collection<String> list, String separator) {
        Objects.requireNonNull(separator);
        if (list == null || list.isEmpty()) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            int size = list.size();
            Iterator<String> iterator = list.iterator();
            for (int i = 0; i < size; i++) {
                builder.append(iterator.next());
                if (size > 1 && i < size - 1) {
                    builder.append(separator)
                            .append(" ");

                }
            }
            return builder.toString();
        }
    }

    public static String capitalize(String original) {
        if (original == null)
            return null;
        else if (original.length() == 1) {
            return original.toUpperCase();
        } else {
            return original.substring(0, 1).toUpperCase()
                    + original.substring(1).toLowerCase();
        }
    }
}
