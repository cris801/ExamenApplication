package com.example.examenapplication.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.examenapplication.Canvas.CanvasEventoActionMove;
import com.example.examenapplication.R;

public class CanvasFragment extends Fragment {

    private View view;
    private RelativeLayout relativeLayout;
    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_canvas, container, false);

        // instanciamos la clase canvasEventoActionMove en el relativeLayout
        relativeLayout = (RelativeLayout) view.findViewById(R.id.contenedor);
        relativeLayout.addView(new CanvasEventoActionMove(getActivity()));

        return view;
    }
}