package in.codingninjas.searchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<CustomObject> objects;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objects = new ArrayList<>();

        //populating objects arrayList
        populateArrayList();


        ListView listView = (ListView) findViewById(R.id.listView);
        customAdapter = new CustomAdapter(this, objects);
        listView.setAdapter(customAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        //setting listener to read the typed text from searchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.filter(newText);
                return false;
            }
        });
    }

    void populateArrayList(){
        for (int i = 0; i < 30; i++) {

            // garbage valued arrayList
            ArrayList<String> temp = new ArrayList<>(Arrays.asList(
                    "rodvdokoey"
                    ,"ykvuxbbrio","ckcibuijbl","xyeoiwidlk"
                    ,"bhlqgdllbu","epduwyvobt","gybmueouaa"
                    ,"zkegftjmlc","falkmmvtoj","hpicgberjf"
                    ,"zfhptspaal" ,
                    "cdrmkafxum" ,
                    "tyipayifaw" ,
                    "sqmaamfkwk" ,
                    "kiaklouuuc" ,
                    "snyhvtaskc" ,
                    "uboagvtjpi" ,
                    "ryjizfbdnz" ,
                    "kqulpqvbxn" ,
                    "cypxflcvyc" ,
                    "dikcxjppfn" ,
                    "mvhwxxtjpc" ,
                    "rhugtdbunl" ,
                    "pwrxuvrmoh" ,
                    "qznlrdjyas" ,
                    "nddjmoflps" ,
                    "nosqqdzamg" ,
                    "qvkcasndbj" ,
                    "qzgqjawqwf" ,
                    "wprvvsxwaq"));

            CustomObject obj = new CustomObject(temp.get(i), "body " + i);
            objects.add(obj);

        }
    }
}
