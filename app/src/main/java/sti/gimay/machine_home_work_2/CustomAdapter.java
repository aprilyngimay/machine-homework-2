package sti.gimay.machine_home_work_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, String[] osNameList, int[] osImages) {
        // TODO Auto-generated constructor stub
        result = osNameList;
        context = mainActivity;
        imageId = osImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView planet_text;
        ImageView planet_img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom_grid_layout, null);
        holder.planet_text =(TextView) rowView.findViewById(R.id.planet_text);
        holder.planet_img =(ImageView) rowView.findViewById(R.id.planet_img);

        holder.planet_text.setText(result[position]);
        holder.planet_img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();

                AlertDialog.Builder dialog_planet = new AlertDialog.Builder(context);
                LayoutInflater factory = LayoutInflater.from(context);
                final View view = factory.inflate(R.layout.custom_dialog_for_planet, null);

                // find elements using id
                ImageView img_planet = (ImageView) view.findViewById(R.id.ivPlanet);
                TextView tv_planet_name = (TextView) view.findViewById(R.id.tv_planet_name);
                TextView tv_planet_diameter = (TextView) view.findViewById(R.id.tv_planet_diameter);
                TextView tv_planet_status = (TextView) view.findViewById(R.id.tv_planet_status);

                // set value of elements
                img_planet.setImageResource(imageId[position]);
                tv_planet_name.setText(result[position]);

                // set value of diameter and status
                String planet_name = String.valueOf(result[position]);
                if(planet_name.equals("Mercury")) {
                    tv_planet_diameter.setText("4,879 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Venus")) {
                    tv_planet_diameter.setText("12,104 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Earth")) {
                    tv_planet_diameter.setText("12,742 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Mars")) {
                    tv_planet_diameter.setText("6,779 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Jupiter")) {
                    tv_planet_diameter.setText("139,822 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Saturn")) {
                    tv_planet_diameter.setText("116,464 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Uranus")) {
                    tv_planet_diameter.setText("50,724 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Neptune")) {
                    tv_planet_diameter.setText("49,244 km");
                    tv_planet_status.setText("STILL PART OF THE SOLAR SYSTEM");
                }
                else if(planet_name.equals("Pluto")) {
                    tv_planet_diameter.setText("2,377 km");
                    tv_planet_status.setText("NOT PART OF THE SOLAR SYSTEM");
                }

                dialog_planet.setView(view);
                dialog_planet.setNeutralButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog_planet.show();
            }
        });

        return rowView;
    }
}
