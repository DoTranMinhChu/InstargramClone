package com.dtmchu.instargramclone.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dtmchu.instargramclone.EditContactActivity;
import com.dtmchu.instargramclone.R;
import com.dtmchu.instargramclone.model.Contact;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    final int RESULT_CONTACTS_ACTIVITY = 1;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView idTextView = holder.idTextView;
        idTextView.setText(String.valueOf(contact.getID()));
        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(contact.getName());
        TextView phoneNumberTextView = holder.phoneNumberTextView;
        phoneNumberTextView.setText(contact.getPhoneNumber());
//        Button button = holder.messageButton;
//        button.setText("Message");
//        button.setEnabled(true);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the details activity
                Intent intent = new Intent(mContext, EditContactActivity.class);
      //          intent.putExtra("username",contact.getID() + "username");
                intent.putExtra("isupdate", true);
                intent.putExtra("contact_id", contact.getID());
                ((Activity) mContext).startActivityForResult(intent, RESULT_CONTACTS_ACTIVITY);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView idTextView;
        public TextView nameTextView;
        public TextView phoneNumberTextView;
       // public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            idTextView = (TextView) itemView.findViewById(R.id.contactId);
            nameTextView = (TextView) itemView.findViewById(R.id.contactName);
            phoneNumberTextView = (TextView) itemView.findViewById(R.id.contactPhoneNumber);
        }
    }
    private Context mContext;
    private List<Contact> mContacts;

    // Pass in the contact array into the constructor
    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }
    public ContactsAdapter(Context context , List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }
}