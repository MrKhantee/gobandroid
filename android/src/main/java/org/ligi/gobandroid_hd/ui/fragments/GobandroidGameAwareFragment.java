package org.ligi.gobandroid_hd.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.ligi.gobandroid_hd.App;
import org.ligi.gobandroid_hd.logic.GoGame;

public abstract class GobandroidGameAwareFragment extends Fragment implements GoGame.GoGameChangeListener {

    protected GoGame game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        game = App.getGame();
        game.addGoGameChangeListener(this);
        return createView(inflater, container, savedInstanceState);
    }

    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        game.removeGoGameChangeListener(this);
        super.onDestroyView();
    }

}
