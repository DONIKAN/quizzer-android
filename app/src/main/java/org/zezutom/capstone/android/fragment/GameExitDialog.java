package org.zezutom.capstone.android.fragment;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import org.zezutom.capstone.android.R;

public class GameExitDialog extends DialogFragment {

    private View dialogView;

    private View.OnClickListener onClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dialogView = inflater.inflate(R.layout.fragment_dialog_game_exit, container, false);
        setCancelable(false);
        if (onClickListener != null) {
            onClick(R.id.save_score, onClickListener);
            onClick(R.id.reset_game, onClickListener);
            onClick(R.id.exit_game, onClickListener);
            onClick(R.id.cancel_exit, onClickListener);
        }

        final Window window = getDialog().getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(0));

        dialogView.getBackground().setAlpha(200);
        return dialogView;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = listener;
    }

    private void onClick(int id, View.OnClickListener listener) {
        dialogView.findViewById(id).setOnClickListener(listener);
    }

}
