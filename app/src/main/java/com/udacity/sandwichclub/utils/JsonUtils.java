package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json){

//        public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
//            this.mainName = mainName;
//            this.alsoKnownAs = alsoKnownAs;
//            this.placeOfOrigin = placeOfOrigin;
//            this.description = description;
//            this.image = image;
//            this.ingredients = ingredients;
//        }

       Sandwich sandwich = new Sandwich();

       try {


           JSONObject jsonSandwichString = new JSONObject(json);

           String imageLink = jsonSandwichString.getString("image");
           sandwich.setImage(imageLink);
           sandwich.setMainName(jsonSandwichString.getJSONObject("name").getString("mainName"));

           ArrayList<String> alsoKnownAsArray = new ArrayList<>();
           JSONArray alsoKnownAsJsonArray = jsonSandwichString.getJSONArray("alsoKnownAs");
           for(int i=0; i<alsoKnownAsJsonArray.length();i++){
               alsoKnownAsArray.add(alsoKnownAsJsonArray.getString(i));
           }

           sandwich.setAlsoKnownAs(alsoKnownAsArray);

//           placeOfOrigin = jsonSandwichString.getString("placeOfOrigin");
//           sandwich.setPlaceOfOrigin(placeOfOrigin);
//
//           setDescription = jsonSandwichString.getString("description");
//           sandwich.setDescription(setDescription);

           ArrayList<String> ingredientsArray = new ArrayList<>();
           JSONArray ingredientsJsonArray = jsonSandwichString.getJSONArray("alsoKnownAs");
           for(int i=0; i< ingredientsJsonArray.length();i++){
               ingredientsArray.add(ingredientsJsonArray.getString(i));
           }
           sandwich.setIngredients(ingredientsArray);


       } catch (JSONException e){
           e.printStackTrace();
       }
        return sandwich;
    }
}

