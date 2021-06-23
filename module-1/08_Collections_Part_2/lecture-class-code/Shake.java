package com.techelevator;

import java.util.HashSet;
import java.util.Set;

public class Shake {
    private Set<String> ingredients;
    private String shakeName;
    private String productCode;

    public Shake(Set<String> ingredients, String shakeName) {
        this.ingredients = ingredients;
        this.shakeName = shakeName;
    }
    public Shake(String shakeName) {
        this.shakeName = shakeName;
    }
    public Shake() {
    }
    public Shake(String shakeName, String listOfIngredients) {
        this.shakeName = shakeName;
        this.ingredients = new HashSet<>();
        String[] localIngredients = listOfIngredients.split(",");
        for (String ingredient : localIngredients) {
            this.ingredients.add(ingredient);
        }
    }
    public Shake(String productCode, String shakeName, String listOfIngredients) {
        this.productCode = productCode;
        this.shakeName = shakeName;
        // to make it more "convenient" for us, we create
        // a Constructor that allows us to send a comma-separated string of ingredients
        // we will need to create the Set and the add the ingredients
        this.ingredients = new HashSet<>();
        String[] localIngredients = listOfIngredients.split(",");
        for (String ingredient : localIngredients) {
            this.ingredients.add(ingredient);
        }
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getShakeName() {
        return shakeName;
    }

    public void setShakeName(String shakeName) {
        this.shakeName = shakeName;
    }

    @Override
    public String toString() {
        return "Shake{" +
                "ingredients=" + String.join(",",ingredients) +
                ", shakeName='" + shakeName + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
