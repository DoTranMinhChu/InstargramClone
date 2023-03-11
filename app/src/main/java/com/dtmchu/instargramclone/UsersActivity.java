package com.dtmchu.instargramclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dtmchu.instargramclone.adapter.ContactsAdapter;
import com.dtmchu.instargramclone.model.Contact;

import java.util.List;

public class UsersActivity extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        databaseHandler = new DatabaseHandler(this);
        // Initialize contacts
        contacts = databaseHandler.getAllContacts();
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(UsersActivity.this,contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }


}