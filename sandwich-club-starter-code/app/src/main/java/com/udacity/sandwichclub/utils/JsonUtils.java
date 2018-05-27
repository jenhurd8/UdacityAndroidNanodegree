package com.udacity.sandwichclub.utils;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {



    public static Sandwich parseSandwichJson(String json) {

         Sandwich sandwichObject  = new Sandwich();

        try {
            JSONObject sandwichJson = new JSONObject(json);

            sandwichObject.setMainName(sandwichJson.getJSONObject("name").getString("mainName"));

            ArrayList<String> alsoKnownAsArray = new ArrayList<>();
            JSONArray alsoKnownAsJsonArray = sandwichJson.getJSONObject("name").getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsArray.size(); i++){
                alsoKnownAsArray.add(alsoKnownAsJsonArray.getString(i));
            }
            sandwichObject.setAlsoKnownAs(alsoKnownAsArray);

            sandwichObject.setPlaceOfOrigin(sandwichJson.getJSONObject("name").getString("placeOfOrigin"));

            sandwichObject.setDescription(sandwichJson.getJSONObject("name").getString("description"));

            sandwichObject.setImage(sandwichJson.getJSONObject("name").getString("image"));

            ArrayList<String> ingredientsArray = new ArrayList<String>();
            JSONArray ingredientsJsonArray = sandwichJson.getJSONObject("name").getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.size(); i++){
                ingredientsArray.add(ingredientsJsonArray.getString(i));
            }
            sandwichObject.setIngredients(ingredientsArray);

        } catch (JSONException e){
            e.printStackTrace();
        }

        return sandwichObject;
    }
}
