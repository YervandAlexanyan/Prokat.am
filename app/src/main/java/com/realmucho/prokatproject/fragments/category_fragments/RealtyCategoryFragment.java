package com.realmucho.prokatproject.fragments.category_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.adapters.CategoryAdapter;
import com.realmucho.prokatproject.models.CategoryData;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.activities.PostsActivity;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


public class RealtyCategoryFragment extends Fragment implements PaneCallBack {
    private RecyclerView mCategoryRv;
    private CategoryAdapter mCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.realty_category_fragment, container, false);
        mCategoryRv = (RecyclerView) view.findViewById(R.id.realty_category_rw);
        mCategoryRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryAdapter = new CategoryAdapter(setData(), getContext(), this);
        mCategoryRv.setAdapter(mCategoryAdapter);
        return view;
    }
    /**Setting local data for testing recyclerViews*/
    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.tun_mek_checked_icon, R.drawable.tun_erku_checked_icon, R.drawable.tun_ereq_checked_icon, R.drawable.arandznatun_checked_icon, R.drawable.shop_checked_icon, R.drawable.cottage_checked_icon};
        int[] unchecked = new int[]{R.drawable.tun_mek_icon, R.drawable.tun_erku_icon, R.drawable.tun_ereq_icon, R.drawable.arandznatun_icon, R.drawable.shop_icon, R.drawable.cottage_icon};
        String[] names = getResources().getStringArray(R.array.realty_items);

        for (int i = 0; i < 5; i++) {
            arrayList.add(new CategoryData(checked[i], names[i + 1], unchecked[i]));

        }


        return arrayList;
    }

    @Override
    public void paneOpen(int position) {
        Intent intent = new Intent(getContext(), PostsActivity.class);
        intent.putExtra("request", position);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        /**OnBackPressed functions*/

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    getActivity().finish();
                    return true;
                }

                return false;
            }
        });
    }


}
