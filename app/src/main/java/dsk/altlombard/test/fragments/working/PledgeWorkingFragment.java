package dsk.altlombard.test.fragments.working;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.FullPledgeRowAdapter;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentMainWorkingBinding;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingBinding;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class PledgeWorkingFragment extends Fragment {
    private boolean isActive = true;

    private FragmentPledgeWorkingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(isActive){
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lay_working, new PledgeWorkingTicketActiveFragment())
                    .commit();
        } else {
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lay_working, new PledgeWorkingTicketArchiveFragment())
                    .commit();
        }
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.top_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.active_item:
                        isActive = true;
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.lay_working, new PledgeWorkingTicketActiveFragment())
                                .commit();
                        return true;
                    case R.id.archive_item:
                        isActive = false;
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.lay_working, new PledgeWorkingTicketArchiveFragment())
                                .commit();
                        return true;
                    default: return true;
                }
            }
        });

//        binding.topAppBar1.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener listener1) {
//
//        };
    }

    private SearchView searchView;

    private SearchView.OnQueryTextListener queryTextListener;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.top_app_bar, menu);
        MenuItem searchItem = menu.findItem(R.id.search1);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        System.out.println("MENUITEM = " + searchItem);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    System.out.println("SERARCH111");

                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {
                    System.out.println("SERARCH222");

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search1:
                System.out.println("SERARCH333");
                // Not implemented here
                return false;
            default:
                break;
        }
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);
    }

    //выход их приложения при нажатии кнопки "назад"
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().moveTaskToBack(true);
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
