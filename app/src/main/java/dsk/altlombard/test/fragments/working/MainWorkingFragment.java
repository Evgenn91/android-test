package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingBinding;
import dsk.altlombard.test.databinding.FragmentMainWorkingBinding;
import dsk.altlombard.test.dto.PledgeRow;
import dsk.altlombard.test.fragments.WorkingMainFragment;
import dsk.altlombard.test.fragments.entering.CodeEnteringFragment;

import java.util.ArrayList;
import java.util.List;

public class MainWorkingFragment extends Fragment {

    private FragmentMainWorkingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainWorkingBinding.inflate(inflater, container, false);
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
        pledges.add(new PledgeRow("111111-115", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-116", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-117", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-118", "10.10.2020","100.00","1000.00"));

        ListView simpleListView = view.findViewById(R.id.main_active_pledge_list);
        PledgeRowAdapter customAdapter = new PledgeRowAdapter(view.getContext(), pledges);
        simpleListView.setAdapter(customAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                System.out.println(pledges.get(pos));
                //todo вместе с таким переходом должна еше информация об объекте передаваться
                NavHostFragment.findNavController(MainWorkingFragment.this).navigate(R.id.action_workingMainFragment_to_pledgeWorkingOneTicketActiveFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
