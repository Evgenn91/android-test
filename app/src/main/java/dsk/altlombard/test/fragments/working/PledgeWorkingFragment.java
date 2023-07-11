package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
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
    }

    //выход их приложения при нажатии кнопки "назад"
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
