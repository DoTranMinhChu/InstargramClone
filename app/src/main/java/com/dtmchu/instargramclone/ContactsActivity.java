package com.dtmchu.instargramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dtmchu.instargramclone.adapter.ContactsAdapter;
import com.dtmchu.instargramclone.model.Contact;

import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    final int RESULT_CONTACTS_ACTIVITY = 1;
    DatabaseHandler databaseHandler;
    ContactsAdapter adapter;
    List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);


        databaseHandler = new DatabaseHandler(this);
        // Initialize contacts
        contacts = databaseHandler.getAllContacts();
        // Create adapter passing in the sample user data
        findViewById(R.id.addContactButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("isupdate", false);
                intent.setClass(ContactsActivity.this, EditContactActivity.class);
                startActivityForResult(intent, RESULT_CONTACTS_ACTIVITY);



            }
        });
        this.loadRecyclerView();
    }
    private void loadDbProduct() {
        contacts.clear();
        contacts.addAll(databaseHandler.getAllContacts());
    }
    private void loadRecyclerView(){
        this.loadDbProduct();
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        // Create adapter passing in the sample user data
        adapter = new ContactsAdapter(ContactsActivity.this,contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
//    @Override
//    public void onResume(){
//        super.onResume();
//        this.loadRecyclerView();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_CONTACTS_ACTIVITY:
                //Khi đóng Activity EditProduct thì nạp lại dữ liệu
                loadDbProduct();
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }

    }



}