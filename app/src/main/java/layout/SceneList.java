/*
 * ********************************************************
 *
 * Copyright (c) 2016.
 * by 111ELM Design, LLC
 *
 * ********************************************************
 */

package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.inject.Inject;
import com.oneelevenelm.bedmate.R;
import com.oneelevenelm.bedmate.events.SceneExecuteEvent;
import com.oneelevenelm.bedmate.model.SceneModel;
import com.oneelevenelm.bedmate.model.events.SceneModelUpdateEvent;

import roboguice.event.EventManager;
import roboguice.event.Observes;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SceneList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SceneList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SceneList extends RoboFragment {

    private OnFragmentInteractionListener mListener;

    @Inject
    protected EventManager eventManager;

    @InjectView(R.id.btnScene)
    Button sceneButton;

    @Inject
    SceneModel sceneModel;

    public SceneList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SceneList.
     */
    public static SceneList newInstance() {
        SceneList fragment = new SceneList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sceneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventManager.fire(new SceneExecuteEvent(1) );
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scene_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    protected void handleScenesUpdated (@Observes SceneModelUpdateEvent evt){
        renderScenes();
    }

    private void renderScenes() {

    }
}
