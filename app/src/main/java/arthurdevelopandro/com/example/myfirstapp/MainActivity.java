package arthurdevelopandro.com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //déclaration des attributs
    TextView tv_console;
    Button bt_ajouter, bt_ajouter_plusieurs, bt_supprimer_dernier;
    EditText et_nom, et_prenom;
    SeekBar sb;

    @Override
    /**
     * void : Méthode qui ne retourne rien
     * onCreate : Nom de la méthode
     * Bundle : Typage
     * savedInstanceState : Nom de la variable en paramètre
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //indique le fichier XML à charger
        setContentView(R.layout.activity_main);

        //Récupère les éléments définis dans le XML transmis a setContentView
        et_nom = (EditText) findViewById(R.id.et_nom);
        et_prenom = (EditText) findViewById(R.id.et_prenom);
        tv_console = (TextView) findViewById(R.id.tv_console);
        bt_ajouter = (Button) findViewById(R.id.bt_ajouter);
        bt_ajouter_plusieurs = (Button) findViewById(R.id.bt_ajouter_plusieurs);
        bt_supprimer_dernier = (Button) findViewById(R.id.bt_supprimer_dernier);
        sb = (SeekBar) findViewById(R.id.sb);

        //Redirige le click sur la méthode OnClick()
        bt_ajouter.setOnClickListener(this);
        bt_ajouter_plusieurs.setOnClickListener(this);
        bt_supprimer_dernier.setOnClickListener(this);

        tv_console.setText("");
    }

    @Override
    /**
     * void
     * onClick
     * View
     * view
     *
     * Méthode qui sera appelé lors d'un clik sur le bouton
     */
    public void onClick(View view) {
        //tv_console.append("Click ! \n");

        if (view == bt_ajouter) {
            //tv_console.setText("bt_ajouter !");
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            //String res = contact(nom, prenom);
            ajouter(nom, prenom, 1);

            //tv_console.setText(res);

        }
        if (view == bt_ajouter_plusieurs) {
            //tv_console.setText("bt_ajouter_plusieurs !!");

            int nb = sb.getProgress();
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, nb);


        }
        if (view == bt_supprimer_dernier) {
            tv_console.setText("bt_suppimer");
        }
    }

    /*   public String contact(String nom, String prenom) {
           String res = "Nom : " + nom + ", Prenom : " + prenom;

           if (nom.length() == 0) {
               return "Le nom est vide";
           }

           return res;
       }
   */
    public void ajouter(String nom, String prenom, int nb) {

        if (nom.length() == 0) {
            Toast.makeText(this, "Le nom est vide ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, "Le prenom est vide ", Toast.LENGTH_SHORT).show();
            return;
        }

        int i = 0;

        while (i < nb) {
            tv_console.append(i + " : " + nom + " " + prenom + "\n");
            i++;
        }


    }
}