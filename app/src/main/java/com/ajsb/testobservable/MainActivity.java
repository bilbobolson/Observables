package com.ajsb.testobservable;

/**
 * Programación Multimedia y de Dispositivos Móviles
 * Antonio J.Sánchez
 * curso 2020|21
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity
                          //implements Observer
{
    private Usuario obs ;
    private TextView vista ;
    private ImageView foto ;
    private Button btnNombre, btnFoto ;


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        vista     = findViewById(R.id.nombre) ;
        foto      = findViewById(R.id.foto) ;
        btnNombre = findViewById(R.id.btnNombre) ;
        btnFoto   = findViewById(R.id.btnFoto) ;

        // Instanciamos el objeto observable
        obs = new Usuario("Jose Luís", "García", "https://picsum.photos/id/237/200/300") ;

        // Hacemos que la clase MainActivity sea la que observa
        obs.addObserver((o, arg) ->
        {
            vista.setText(o.toString()) ;
           // Picasso.get().load(((Usuario) o).getFoto()).into(foto) ;
            Usuario usr = (Usuario) o ;
            Picasso.get().load(usr.getFoto())
                   .resize(200, 200)
                   .centerCrop()
                   .into(foto) ;
        }) ;

        obs.notifyObservers() ;

        //
        btnNombre.setOnClickListener(v ->
        {
            obs.setNombre("Margarita") ;
            obs.setApellidos("Jiménez");
        });

        //
        btnFoto.setOnClickListener(v ->
        {
            obs.setFoto("https://picsum.photos/seed/picsum/200/300");
        });

    }

    /**
     * @param o
     * @param arg
     */
    /*@Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof testObservable)
            Log.i("OBSERVERS", "Es una instancia") ;

        vista.setText("Cambio a valor: " + arg) ;
    }*/
}