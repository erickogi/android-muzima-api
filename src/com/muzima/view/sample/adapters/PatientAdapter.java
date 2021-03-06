package com.muzima.view.sample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.muzima.api.model.Patient;
import com.muzima.view.sample.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PatientAdapter extends ArrayAdapter<Patient> {


    public PatientAdapter(final Context context, final int textViewResourceId, final List<Patient> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.patient_list_item, null);
        }

        Patient patient = getItem(position);
        if (patient != null) {
            TextView textView = (TextView) view.findViewById(R.id.identifier_text);
            textView.setText(patient.getIdentifier());

            textView = (TextView) view.findViewById(R.id.name_text);
            textView.setText(patient.getGivenName() + " " + patient.getMiddleName() + " " + patient.getFamilyName());

            DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
            textView = (TextView) view.findViewById(R.id.birthdate_text);
            textView.setText(format.format(patient.getBirthdate()));

            ImageView imageView = (ImageView) view.findViewById(R.id.gender_image);
            if (imageView != null) {
                String gender = patient.getGender();
                if (gender.equals("M")) {
                    imageView.setImageResource(R.drawable.male);
                } else if (gender.equals("F")) {
                    imageView.setImageResource(R.drawable.female);
                }
            }
        }
        return view;
    }
}
