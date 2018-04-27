package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils{

    public static Sandwich parseSandwichJson(String json) {
        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> alsoKnownAs;
        ArrayList<String> ingredients;
        try {
            JSONObject fullObject = new JSONObject(json);
            JSONObject nameObject = fullObject.getJSONObject("name");
            mainName = nameObject.getString("mainName");
            JSONArray alsoKnownAsJSONArray = nameObject.getJSONArray("alsoKnownAs");
            placeOfOrigin = fullObject.getString("placeOfOrigin");
            description = fullObject.getString("description");
            image = fullObject.getString("image");
            JSONArray ingredientsJSONArray = fullObject.getJSONArray("ingredients");

            alsoKnownAs = new ArrayList<>();
            for(int i = 0; i<alsoKnownAsJSONArray.length(); i++){
                alsoKnownAs.add(alsoKnownAsJSONArray.getString(i));
            }

            ingredients = new ArrayList<>();
            for(int i = 0; i<ingredientsJSONArray.length(); i++){
                ingredients.add(ingredientsJSONArray.getString(i));
            }

            if(mainName.equals(""))mainName = "Unknown";
            if(placeOfOrigin.equals(""))placeOfOrigin = "Unknown";
            if(description.equals(""))description = "Unknown";
            if(image.equals(""));
            if(alsoKnownAs.size()==0)alsoKnownAs.add("Unknown");
            if(ingredients.size()==0)ingredients.add("Unknown");

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
