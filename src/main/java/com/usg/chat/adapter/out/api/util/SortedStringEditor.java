package com.usg.chat.adapter.out.api.util;

public class SortedStringEditor {

    public static String createSortedString(Long firstId, Long secondId){
        return Math.min(firstId, secondId) + "_" + Math.max(firstId, secondId);
    }
}
