package com.hlx.util;

import java.util.UUID;

public class UUIDUtil {

    public static String get() {
        return UUID.randomUUID().toString()
                .replaceAll("-","");
    }
}
