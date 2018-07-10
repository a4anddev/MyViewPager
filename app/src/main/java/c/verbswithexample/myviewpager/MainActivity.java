package c.verbswithexample.myviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // prepare the data model
        List<DataModel> itemList = getDataList();
        // locate the view pager in mainactivity.xml
        ViewPager viewPager = findViewById(R.id.viewPagerId);

        // create instance of pagerAdapter
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this,itemList);

        // bind the adapter to view pager
        viewPager.setAdapter(customPagerAdapter);


    }

    public List<DataModel> getDataList(){

        List<DataModel> itemList = new ArrayList<>();

        int[] imageId = new int[]{
                R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6
        };

        String[] titles = new String[] {

                "Image 1", "Image 2", "Image 3", "Image 4", "Image 5", "Image 6"
        };

        int count = imageId.length;

        for (int i = 0; i < count; i++){

            itemList.add(new DataModel(imageId[i], titles[i]));

        }

        return itemList;


    }



}
