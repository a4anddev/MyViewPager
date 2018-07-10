package c.verbswithexample.myviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomPagerAdapter extends PagerAdapter{

    private Context context;
    private List<DataModel> itemList;
    private LayoutInflater inflater;


    public CustomPagerAdapter(Context context, List<DataModel> itemList) {
        this.context = context;
        this.itemList = itemList;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 6;
    }


    // check whether view is assoicated with object
    // or object is assoicated with page view i.e view or not
        @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


    // you have to create third manual method

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // get the view of the single view pager item
       View view = inflater.inflate(R.layout.view_pager_item, container, false);

       //locate image and text
        ImageView imageView = view.findViewById(R.id.imageId);
        TextView textView = view.findViewById(R.id.txt);

        // get the data model for current postion
        DataModel dataModel = itemList.get(position);

        // set the image and text
        imageView.setImageResource(dataModel.imageId);
        textView.setText(dataModel.title);

        // add view_pager_item.xml to view pager
        container.addView(view);

        return view;
    }

    // Remove view of viewpager.xml from viewpager container
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((FrameLayout) object);

    }
}
