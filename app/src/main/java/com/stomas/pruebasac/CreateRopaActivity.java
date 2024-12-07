package com.stomas.pruebasac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

public class CreateRopaActivity extends AppCompatActivity {

    Button btn_ad;
    EditText name, quality, size;
    private FirebaseFirestore mfirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ropa);

        this.setTitle("Crear Ropa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        name = findViewById(R.id.nombre);
        quality = findViewById(R.id.calidad);
        size = findViewById(R.id.talla);
        btn_ad = findViewById(R.id.btn_ad);

        btn_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameropa = name.getText().toString().trim();
                String qualityropa = quality.getText().toString().trim();
                String sizeropa = size.getText().toString().trim();

                if(nameropa.isEmpty() && qualityropa.isEmpty() && sizeropa.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    postRopa(nameropa, qualityropa, sizeropa);
                }
            }
        });
    }

    private void postRopa(String nameropa, String qualityropa, String sizeropa) {

        mfirestore.collection("ropa").add(map).addOnSuccessListener(new OnSuccessListener())<DocumentReference>{
            @Override
            public void onSuccess(DocumentReference documentReference){

            }
        }).addOnFailureListener()
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
