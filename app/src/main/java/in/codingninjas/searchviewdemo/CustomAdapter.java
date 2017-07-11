package in.codingninjas.searchviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YourFather on 11-07-2017.
 */

public class CustomAdapter extends ArrayAdapter<CustomObject> {

    ArrayList<CustomObject> objects;

    // secondary arrayList to store original arraylist.
    ArrayList<CustomObject> arrayList;

    public CustomAdapter(@NonNull Context context, @NonNull ArrayList<CustomObject> objects) {
        super(context, 0);
        this.objects = objects;

        arrayList = new ArrayList<>();
        arrayList.addAll(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Not using convertView

        CustomObject obj = objects.get(position);

        View view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, null);
        TextView t1 = (TextView) view.findViewById(android.R.id.text1);
        TextView t2 = (TextView) view.findViewById(android.R.id.text2);

        t1.setText(obj.name);
        t2.setText(obj.body);

        return view;
    }

    @Override
    public int getCount() {
        return objects.size();
    }


    // filters the results for us..

    public void filter(String text){
        text = text.toLowerCase();
        objects.clear();

        if (text.length()==0){

            // adding the original contents back to the objects arrayList
            objects.addAll(arrayList);
        }else {

            // filtering and adding relevant objects to objects arrayList
            for (int i=0 ; i<arrayList.size() ; i++){
                CustomObject tempObject = arrayList.get(i);
                if (tempObject.name.toLowerCase()
                        .contains(text)){
                    objects.add(tempObject);
                }
            }

            notifyDataSetChanged();
        }
    }
}
