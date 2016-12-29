package com.felixsu.dagger2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 12/29/16.
 *
 * @author felixsoewito
 */

public class SharedData {

    private Map<String, String> mData = new HashMap<>();

    public void putName(String name) {
        mData.put("name", name);
    }

    public String getName() {
        return mData.get("name") == null ? "default" : mData.get("name");
    }
}
