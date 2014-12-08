package jp.co.cyberagent.codesample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.co.cyberagent.codesample.R;
import jp.co.cyberagent.codesample.adapter.Ex2ListAdapter;

public class Ex2ListFragment extends Fragment implements AbsListView.OnScrollListener {

    // Viewの位置調整を計算するためにheader、sticky barの高さを使用します。
    // 本来であればこれは /res/values/dimens.xmlに定義しておきます（今回は簡単のためベタ書き）
    private static final int HEADER_HEIGHT_DIP = 200;
    private static final int STICKY_BAR_HEIGHT_DIP = 48;

    private int mHeaderHeight;
    private int mStickyBarHeight;

    private ListView mListView;
    private FrameLayout mHeader;
    private TextView mHeaderText;
    private FrameLayout mStickyBar;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Ex1Fragment.
     */
    public static Ex2ListFragment newInstance() {
        Ex2ListFragment fragment = new Ex2ListFragment();
        return fragment;
    }

    public Ex2ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHeaderHeight = (int) (HEADER_HEIGHT_DIP * getResources().getDisplayMetrics().density);
        mStickyBarHeight = (int) (STICKY_BAR_HEIGHT_DIP * getResources()
                .getDisplayMetrics().density);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ex2_list_fragment, container, false);

        mListView = (ListView) view.findViewById(R.id.ex2_list);
        mHeader = (FrameLayout) view.findViewById(R.id.frame_header);
        mHeaderText = (TextView) view.findViewById(R.id.header_text);
        mStickyBar = (FrameLayout) view.findViewById(R.id.frame_sticky_bar);

        // ListViewのHeaderViewに、Header、StickyBarと同じ高さのダミーヘッダーを設定
        View listHeader = inflater.inflate(R.layout.ex2_list_header, container, false);
        mListView.addHeaderView(listHeader);

        // このFragmentをListViewのリスナーに設定
        mListView.setOnScrollListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ダミーデータをListViewに設定
        Ex2ListAdapter adapter = new Ex2ListAdapter(getActivity(), createDummyItem());
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


    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        // ScrollViewのスクロール位置にあわせて、HeaderとStickyBarのtranslationを設定する
        if (t < mHeaderHeight) {
            mHeader.setTranslationY(t / 2);
        }
        if (t >= mHeaderHeight) {
            mStickyBar.setTranslationY(t - mHeaderHeight);
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        // 表示中の子View情報を計算して、現在のスクロール位置（pixel）を取得する
        int scrollY = getScrollY(absListView, firstVisibleItem);

        // ListViewのスクロール位置にあわせて、HeaderとStickyBarのtranslationを設定する
        if (scrollY <= mHeaderHeight) {
            mHeader.setTranslationY(-scrollY);
            mHeaderText.setTranslationY(scrollY / 2);
            mStickyBar.setTranslationY(-scrollY);
        } else {
            mHeader.setTranslationY(-mHeaderHeight);
            mHeaderText.setTranslationY(mHeaderHeight / 2);
            mStickyBar.setTranslationY(-mHeaderHeight);
        }
    }

    private int getScrollY(AbsListView absListView, int firstVisibleItem) {
        View child = absListView.getChildAt(0);
        if (child == null) {
            return 0;
        }

        int headerHeight = 0;
        if (firstVisibleItem >= 1) {
            headerHeight = mHeaderHeight;
        }

        return firstVisibleItem * child.getHeight() - child.getTop() + headerHeight;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        // nothing
    }

    private List<String> createDummyItem() {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            items.add("Content " + (i + 1));
        }
        return items;
    }
}
