package com.example.msit_placement;

    import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.HashMap;
import java.util.List;

    public class SimpleArrayAdapter extends ArrayAdapter {

        Context context;
        int textViewResourceId;
        private static final String TAG = "SimpleArrayAdapter" ;
        HashMap hashMap = new HashMap();

        public SimpleArrayAdapter(Context context, int textViewResourceId,
                                  List objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.textViewResourceId = textViewResourceId;
            for (int i = 0; i < objects.size(); ++i) {
                hashMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = (String) getItem(position);
            return (long) hashMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        public void add(String object){
            hashMap.put(object,hashMap.size());
            this.notifyDataSetChanged();
        }

}
