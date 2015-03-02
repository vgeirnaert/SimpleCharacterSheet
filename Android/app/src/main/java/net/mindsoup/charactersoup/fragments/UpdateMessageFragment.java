package net.mindsoup.charactersoup.fragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockDialogFragment;

import net.mindsoup.charactersoup.R;

/**
 * Created by Valentijn on 14-2-2015.
 */
public class UpdateMessageFragment extends SherlockDialogFragment {

    public static final String messageKey = "message_key";
    public static final String messageTitleKey = "message_title_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_updatemessage, container);
        getDialog().setTitle(getArguments().getString(messageTitleKey));
        TextView tv = (TextView)mainView.findViewById(R.id.message);
        tv.setText(Html.fromHtml(getArguments().getString(messageKey)));
        Button button = (Button)mainView.findViewById(R.id.message_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return mainView;
    }
}
