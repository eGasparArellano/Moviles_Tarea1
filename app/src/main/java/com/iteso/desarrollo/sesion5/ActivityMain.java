package com.iteso.desarrollo.sesion5;

import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.iteso.desarrollo.sesion5.beans.Alumno;

public class ActivityMain extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private Spinner scholarship;
    private RadioGroup gender;
    private AutoCompleteTextView books;
    private CheckedTextView sport;

    private Alumno alumno = new Alumno();

    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String SCHORLARSHIP = "scholarship";
    public static final String GENDER = "gender";
    public static final String BOOK = "book";
    public static final String SPORT = "sport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Paso a los objetos las vistas casteadas
        name = (EditText) findViewById(R.id.activity_main_name);
        phone = (EditText) findViewById(R.id.activity_main_phone);
        scholarship = (Spinner) findViewById(R.id.activity_main_scholarship);
        gender = (RadioGroup) findViewById(R.id.activity_main_gender);
        sport = (CheckedTextView) findViewById(R.id.activity_main_sport);

        // Llenar el contenido del AutoCompleteTextView
        books = (AutoCompleteTextView) findViewById(R.id.activity_main_books);
        String[] books_list = getResources().getStringArray(R.array.books_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, books_list);
        books.setAdapter(adapter);
    }

    // Asociar el menu al activity_main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    // Detercar un tap en el icono del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.activity_main_save:
                alumno.setNombre(name.getText().toString());
                alumno.setTelefono(phone.getText().toString());
                alumno.setEscolaridad(scholarship.getSelectedItem().toString());

                if(gender.getCheckedRadioButtonId() == R.id.activity_main_gender_female)
                    alumno.setGenero("Femenino");
                else
                    alumno.setGenero("Masculino");

                alumno.setLibroFavorito(books.getText().toString());
                alumno.setDeporte(sport.isChecked());
                cleanViews();

                Toast.makeText(this, alumno.toString(), Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    public void confirmClean(View v){
        // Configuración del mensaje de alerta
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
        builder.setTitle("");
        builder.setMessage("¿Desea limpiar el contenido?");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cleanViews();
            }
        });
        builder.setNegativeButton("Cancelar", null);


        // Creación y mostrar el mensaje de alerta
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // Limpiar elementos de la pantalla
    public void cleanViews(){
        name.setText("");
        phone.setText("");
        scholarship.setSelection(0);
        gender.check(R.id.activity_main_gender_female);
        books.setText("");
        sport.setChecked(false);
    }

    // Activar/desactivar el CheckTextView, si no no funciona
    public void checked(View v){
        if(sport.isChecked())
            sport.setChecked(false);
        else
            sport.setChecked(true);
    }

    // Guardar los valores al cambiar la orientacion
    @Override // Se manda llamar para guardar valores antes de destruirse la actividad
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NAME, name.getText().toString());
        outState.putString(PHONE, phone.getText().toString());
        outState.putInt(SCHORLARSHIP, scholarship.getSelectedItemPosition());
        outState.putInt(GENDER, gender.getCheckedRadioButtonId());
        outState.putBoolean(SPORT, sport.isChecked());
    }

    @Override // Se manda llamar para restaurar los valores
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name.setText(savedInstanceState.getString(NAME));
        phone.setText(savedInstanceState.getString(PHONE));
        scholarship.setSelection(savedInstanceState.getInt(SCHORLARSHIP));
        gender.check(savedInstanceState.getInt(GENDER));
        sport.setChecked(savedInstanceState.getBoolean(SPORT));
    }
}
