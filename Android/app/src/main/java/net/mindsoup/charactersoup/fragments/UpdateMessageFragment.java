package net.mindsoup.charactersoup.fragments;

import android.content.pm.PackageManager;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_updatemessage, container);
        String versionName = "";
        try {
            versionName = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {}

        getDialog().setTitle("Update " + versionName);
        TextView tv = (TextView)mainView.findViewById(R.id.message);

        tv.setText(Html.fromHtml("<p>Hello users of Character Soup!</p><p>I originally started developing this app because it was a good way to learn Android app development, and I felt there was a lack of good character sheet apps out there. However, I never really expected to get any users besides myself. Recently however things have picked up a little in that regard so I will be spending more effort on developing and maintaining this app.</p><p>The first step of that is the introduction of Crashlytics which will help me track and fix crashes. This is also why the app now requires the Internet access permission.</p><p>The following items are on my roadmap, although I cannot guarantee when they will be done:<br><br>• Character backup and export options<br>• Complete class and racial feats, bonuses and talents<br>• Special Abilities for all classes<br>• Spells for caster classes<br>• Rage powers for Barbarians<br>• Improved item managment<br>• Improved character overview<br>• Proper tablet support<br><br>Please keep in mind that this app is still in development and is not finished yet. There may be bugs and missing features. If you have feedback you can contact me at mindsouplabs@gmail.com.</p><p>Thank you for using Character Soup! :)</p>"));
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
