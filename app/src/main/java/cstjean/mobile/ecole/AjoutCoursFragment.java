package cstjean.mobile.ecole;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;


public class AjoutCoursFragment extends Fragment {

    private TextInputEditText inputDepartement;

    private TextInputEditText inputNumero;

    private Button ajouterBouton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ajout_cours, container, false);
        inputDepartement = view.findViewById(R.id.input_departement);
        inputNumero = view.findViewById(R.id.input_numero);
        ajouterBouton = view.findViewById(R.id.btn_ajouter);

        ajouterBouton.setOnClickListener(v -> {
            String departement = inputDepartement.getText().toString();
            String numero = inputNumero.getText().toString();
            CoursSession coursSessionAdd = new CoursSession(departement, numero);
            SingletonEcole.getInstance().ajouterCoursSession(coursSessionAdd);
            getActivity().finish();
        });

        return view;
    }
}