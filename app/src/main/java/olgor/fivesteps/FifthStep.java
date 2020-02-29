package olgor.fivesteps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/* Create a ListView with custom adapter and use list_item.xml as its custom item
*  Use fruityList for its fruitName
*  Control its delButton 's onClick to delete the clicked item
*  */


public class FifthStep extends AppCompatActivity {

    ListView list;
    ArrayList<String> fruityList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_step);

//        list = (ListView) findViewById(R.id.list);

        fruityList.add("Apple");
        fruityList.add("Banana");
        fruityList.add("Cantaloupe");
        fruityList.add("Date");
        fruityList.add("Elderberry");

        RecyclerView recyclerView = findViewById(R.id.list);
        FifthStepAdapter adapter = new FifthStepAdapter();
        adapter.setList(fruityList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }




}
