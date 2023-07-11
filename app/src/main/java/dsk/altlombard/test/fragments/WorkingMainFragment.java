package dsk.altlombard.test.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentWorkingMainBinding;
import dsk.altlombard.test.fragments.working.AnotherWorkingFragment;
import dsk.altlombard.test.fragments.working.MainWorkingFragment;
import dsk.altlombard.test.fragments.working.NoticeWorkingFragment;
import dsk.altlombard.test.fragments.working.PledgeWorkingFragment;

public class WorkingMainFragment extends Fragment{

    public static boolean isFirstTime;
    private FragmentWorkingMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWorkingMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(isFirstTime){
            getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_working, new MainWorkingFragment())
                .commit();
            isFirstTime = false;
        }


        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_item:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.layout_working, new MainWorkingFragment())
                                .commit();
                        return true;
                    case R.id.pledge_item:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.layout_working, new PledgeWorkingFragment())
                                .commit();
                        return true;
                    case R.id.notice_item:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.layout_working, new NoticeWorkingFragment())
                                .commit();
                        return true;
                    case R.id.another_item:
                        getChildFragmentManager()
                                .beginTransaction()
                                .replace(R.id.layout_working, new AnotherWorkingFragment())
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
