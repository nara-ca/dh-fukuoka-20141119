package jp.co.cyberagent.codesample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.co.cyberagent.codesample.R;
import jp.co.cyberagent.codesample.widget.ObservableScrollView;

public class Ex2ScrollFragment extends Fragment implements ObservableScrollView.Callbacks {

    private static final int HEADER_HEIGHT_DIP = 200;
    private static final int STICKY_BAR_HEIGHT_DIP = 48;

    private int mHeaderHeight;
    private int mStickyBarHeight;

    @InjectView(R.id.ex2_scroll)
    ObservableScrollView mScrollView;
    @InjectView(R.id.frame_header)
    FrameLayout mHeader;
    @InjectView(R.id.frame_sticky_bar)
    FrameLayout mStickyBar;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Ex1Fragment.
     */
    public static Ex2ScrollFragment newInstance() {
        Ex2ScrollFragment fragment = new Ex2ScrollFragment();
        return fragment;
    }

    public Ex2ScrollFragment() {
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
        View view = inflater.inflate(R.layout.ex2_scroll_fragment, container, false);
        ButterKnife.inject(this, view);

        // このFragmentをScrollViewのリスナーに設定
        mScrollView.addCallbacks(this);

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

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        // ScrollViewのスクロール位置にあわせて、HeaderとStickyBarのtranslationを設定する
        if (t < mHeaderHeight) {
            mHeader.setTranslationY(t / 2);
        } else {
            mHeader.setTranslationY(0);
        }
        if (t >= mHeaderHeight) {
            mStickyBar.setTranslationY(t - mHeaderHeight);
        } else {
            mStickyBar.setTranslationY(0);
        }
    }
}
