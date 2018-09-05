package sti.gimay.machine_home_work_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    // Initialization
    GridView gvPlanets;

    public static String[] planetNameList = {
            "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune",
            "Pluto",
    };
    public static int[] planetImages = {
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.earth,
            R.drawable.mars,
            R.drawable.jupiter,
            R.drawable.saturn,
            R.drawable.uranus,
            R.drawable.neptune,
            R.drawable.pluto,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find element by ID
        gvPlanets = (GridView) findViewById(R.id.gvPlanets);
        gvPlanets.setAdapter(new CustomAdapter(this, planetNameList, planetImages));
    }
}
