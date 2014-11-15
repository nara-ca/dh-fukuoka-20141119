package jp.co.cyberagent.codesample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.cyberagent.codesample.R;

public class Ex1Fragment extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Ex1Fragment.
     */
    public static Ex1Fragment newInstance() {
        Ex1Fragment fragment = new Ex1Fragment();
        return fragment;
    }

    public Ex1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ex1_fragment, container, false);

//        view.findViewById(R.id.ex1_fragment_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((Ex1Activity) getActivity()).onFragmentButtonClick();
//            }
//        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
