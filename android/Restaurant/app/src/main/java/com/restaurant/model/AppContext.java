package com.restaurant.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Munisekhar on 2/23/2017.
 */
public class AppContext {
    private static AppContext context;
    private String selectedQRCode;
    private static Map<String,Restaurant> restaurants;
    private static Map<String,Map<String,List<Item>>> items;
    private AppContext() {
        restaurants = new HashMap<>();
        items = new HashMap<>();
    }

    public static AppContext getInstance() {
        if(context == null) {
            context = new AppContext();
            context.createDummyData();
        }
        return  context;
    }

    public String getSelectedQRCode() {
        return selectedQRCode;
    }

    public void setSelectedQRCode(String selectedQRCode) {
        this.selectedQRCode = selectedQRCode;
    }

    public Map<String, Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Map<String, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Map<String, Map<String, List<Item>>> getItems() {
        return items;
    }

    public void setItems(Map<String, Map<String, List<Item>>> items) {
        this.items = items;
    }

    public static void createDummyData() {
     Restaurant restaurant = new Restaurant("Muni","Muni Restaurant");
        restaurants.put("Muni",restaurant);
        restaurant = new Restaurant("Ananth","Ananth Restaurant");
        restaurants.put("Ananth",restaurant);
        restaurant = new Restaurant("Surya","Surya Restaurant");
        restaurants.put("Surya",restaurant);
        restaurant = new Restaurant("Goapl","Goapl Restaurant");
        restaurants.put("Goapl",restaurant);

        //Muni Restaurant Menu
        Map<String,List<Item>> itemTypes = new HashMap<>();

        List<Item> itemsList = new ArrayList<>();
        Item item = new Item();
        item.setId(1);
        item.setName("Chilli Chicken");
        item.setMrpPrice(100);
        item.setOfferPrice(90);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Tikka");
        item.setMrpPrice(200);
        item.setOfferPrice(180);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Soup");
        item.setMrpPrice(130);
        item.setOfferPrice(110);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Lollipop");
        item.setMrpPrice(170);
        item.setOfferPrice(120);
        itemsList.add(item);

        itemTypes.put("Starters",itemsList);

       itemsList = new ArrayList<>();
        item = new Item();
        item.setId(1);
        item.setName("Veg Birayni");
        item.setMrpPrice(180);
        item.setOfferPrice(110);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Biryani");
        item.setMrpPrice(190);
        item.setOfferPrice(130);
        itemsList.add(item);
        itemTypes.put("Main Course",itemsList);
        items.put("Muni",itemTypes);

        //Surya Restaurant Menu
        itemTypes = new HashMap<>();
        itemsList = new ArrayList<>();
        item = new Item();
        item.setId(1);
        item.setName("Chilli Chicken");
        item.setMrpPrice(90);
        item.setOfferPrice(90);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Tikka");
        item.setMrpPrice(150);
        item.setOfferPrice(130);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Soup");
        item.setMrpPrice(150);
        item.setOfferPrice(110);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Lollipop");
        item.setMrpPrice(140);
        item.setOfferPrice(120);
        itemsList.add(item);

        itemTypes.put("Starters",itemsList);

        itemsList = new ArrayList<>();
        item = new Item();
        item.setId(1);
        item.setName("Veg Birayni");
        item.setMrpPrice(177);
        item.setOfferPrice(110);
        itemsList.add(item);

        item = new Item();
        item.setId(1);
        item.setName("Chicken Biryani");
        item.setMrpPrice(160);
        item.setOfferPrice(130);
        itemsList.add(item);


        itemTypes.put("Main Course",itemsList);

        items.put("Surya",itemTypes);


    }
}
