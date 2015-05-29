package co.carmen.superapptwo.model;

import android.content.ClipData;

import com.activeandroid.query.Select;

/**
 * Created by marco on 28/05/15.
 */
public class InyectarBase{

    public static List<Item> getAll(Category category) {
        // This is how you execute a query
        return new Select()
                .from(ClipData.Item.class)
                .where("Category = ?", category.getId())
                .orderBy("Name ASC")
                .execute();
    }

    // Construct ArrayList for model type
    ArrayList<TodoItem> items = new ArrayList<TodoItem>();
    // Construct adapter plugging in the array source
    MyCustomArrayAdapter adapterTodoItems =
            new MyCustomArrayAdapter(this, items);
    // Query ActiveAndroid for list of data
    List<TodoItem> queryResults = new Select().from(TodoItem.class)
            .orderBy("Name ASC").limit(100).execute();
// Load the result into the adapter using `addAll`
    adapterTodoItems.addAll(queryResults);


}
