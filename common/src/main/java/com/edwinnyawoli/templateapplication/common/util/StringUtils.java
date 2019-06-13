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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class StringUtils {
    private static Pattern pattern = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");

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

    public static boolean hasHTMLTags(String string) {
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    /** Trims trailing whitespace. Removes any of these characters:
     * 0009, HORIZONTAL TABULATION
     * 000A, LINE FEED
     * 000B, VERTICAL TABULATION
     * 000C, FORM FEED
     * 000D, CARRIAGE RETURN
     * 001C, FILE SEPARATOR
     * 001D, GROUP SEPARATOR
     * 001E, RECORD SEPARATOR
     * 001F, UNIT SEPARATOR
     * @return "" if source is null, otherwise string with all trailing whitespace removed
     */
    public static CharSequence trimTrailingWhitespace(CharSequence source) {

        if(source == null)
            return "";

        int i = source.length();

        // loop back to the first non-whitespace character
        while(--i >= 0 && Character.isWhitespace(source.charAt(i))) {
        }

        return source.subSequence(0, i+1);
    }
}
