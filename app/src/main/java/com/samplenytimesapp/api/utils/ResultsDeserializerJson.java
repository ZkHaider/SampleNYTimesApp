package com.samplenytimesapp.api.utils;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.samplenytimesapp.api.models.Multimedia;
import com.samplenytimesapp.api.models.Result;

import java.lang.reflect.Type;

/**
 * Created by ZkHaider on 7/3/15.
 */
public class ResultsDeserializerJson implements JsonDeserializer<Result> {

    @Override
    public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement titleElement = json.getAsJsonObject().get("title");
        JsonElement multimediaElement = json.getAsJsonObject().get("multimedia");
        if (multimediaElement.isJsonArray()) {
            return new Result(
                    titleElement.toString(),
                    (Multimedia[]) context.deserialize(multimediaElement.getAsJsonArray(), Multimedia[].class));
        } else if (multimediaElement.getAsString().equals("")) {
            Multimedia multimedia = new Multimedia();
            multimedia.setFormat("");
            multimedia.setUrl("");
            return new Result(titleElement.toString(), multimedia);
        } else {
            Log.d("ResultsDeserializerJson", multimediaElement.toString());
            throw new JsonParseException("Unsupported type of multimedia element");
        }
    }
}