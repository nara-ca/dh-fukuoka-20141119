package jp.co.cyberagent.codesample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.cyberagent.codesample.R;
import jp.co.cyberagent.codesample.adapter.Ex5OnSetListAdapter;

public class Ex5OnSetFragment extends Fragment {

    @InjectView(R.id.ex5_list)
    ListView mListView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Ex1Fragment.
     */
    public static Ex5OnSetFragment newInstance() {
        Ex5OnSetFragment fragment = new Ex5OnSetFragment();
        return fragment;
    }

    public Ex5OnSetFragment() {
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
        View view = inflater.inflate(R.layout.ex5_fragment, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ダミーデータをListViewに設定
        Ex5OnSetListAdapter adapter = new Ex5OnSetListAdapter(getActivity(), createDummyItem());
        mListView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private List<String> createDummyItem() {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            items.add("Content " + (i + 1));
        }
        return items;
    }
}
