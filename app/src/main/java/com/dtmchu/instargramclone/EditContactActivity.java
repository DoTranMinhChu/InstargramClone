package com.dtmchu.instargramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.dtmchu.instargramclone.model.Contact;


public class EditContactActivity extends AppCompatActivity {


    boolean isupdate;
    int idContact;
    EditText editName;
    EditText editPhoneNumber;
    Contact contact;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        databaseHandler = new DatabaseHandler(this);

        Intent intent = getIntent();
        isupdate = intent.getBooleanExtra("isupdate", false);
        if (isupdate) {
            //Activity hoạt động biên tập dữ liệu Sản phẩm đã

            //Đọc sản phẩm

            idContact = intent.getIntExtra("contact_id", 0);
            contact = databaseHandler.getContact(idContact);


            findViewById(R.id.deleteContact).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseHandler.deleteContact(contact);
                    finish();
                    int RESULT_CONTACTS_ACTIVITY = 1;
                    Intent i = new Intent(EditContactActivity.this, ContactsActivity.class);
                    startActivityForResult(i, RESULT_CONTACTS_ACTIVITY);
                }
            });


        } else {
            //Activity nhâp dữ liệu thêm Sản phẩm mới

            contact = new Contact(0, "", "");
            findViewById(R.id.deleteContact).setVisibility(View.GONE);
            ((Button) findViewById(R.id.saveContact)).setText("New contact");
        }

        //Update to View
        editName = findViewById(R.id.editName);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);


        editName.setText(contact.getName());
        editPhoneNumber.setText(contact.getPhoneNumber());

        findViewById(R.id.saveContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.setName(editName.getText().toString());
                contact.setPhoneNumber(editPhoneNumber.getText().toString());

                if (isupdate) {
                    //Cập nhật
                    databaseHandler.updateContact(contact);
                } else {
                    //Tạo
                    databaseHandler.addContact(contact);
                }
                finish();
            }
        });


    }


}