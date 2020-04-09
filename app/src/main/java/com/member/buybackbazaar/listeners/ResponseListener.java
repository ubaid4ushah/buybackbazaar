package com.member.buybackbazaar.listeners;

import com.google.gson.JsonObject;

public interface ResponseListener {
    void onSuccess(JsonObject object, String action);
    void onError(String message);
}
