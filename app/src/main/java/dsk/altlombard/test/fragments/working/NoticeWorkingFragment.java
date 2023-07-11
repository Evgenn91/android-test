package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.NoticeRowAdapter;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentMainWorkingBinding;
import dsk.altlombard.test.databinding.FragmentNoticeWorkingBinding;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class NoticeWorkingFragment extends Fragment {

    private FragmentNoticeWorkingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNoticeWorkingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //MY CODE HERE
        //TODO реализация получения списка залогов
        List<PledgeRow> pledges = new ArrayList<>();
        pledges.add(new PledgeRow("111111-111", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-112", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-113", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-114", "10.10.2020","100.00","1000.00"));

        ListView simpleListView = view.findViewById(R.id.notice_list);
        NoticeRowAdapter customAdapter = new NoticeRowAdapter(view.getContext(), pledges);
        simpleListView.setAdapter(customAdapter);

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
