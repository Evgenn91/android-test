package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.PledgeActiveOneRowAdapter;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentContractEnteringBinding;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingActiveOneOperationsBinding;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class PledgeWorkingOneTicketActiveOperationsFragment extends Fragment {

    private FragmentPledgeWorkingActiveOneOperationsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingActiveOneOperationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        pledges.add(new PledgeRow("111111-111", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-112", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-113", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-114", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-115", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-116", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-117", "10.10.2020","100.00","1000.00"));
        pledges.add(new PledgeRow("111111-118", "10.10.2020","100.00","1000.00"));

        ListView simpleListView = view.findViewById(R.id.pledge_active_operations);
        PledgeActiveOneRowAdapter customAdapter = new PledgeActiveOneRowAdapter(view.getContext(), pledges);
        simpleListView.setAdapter(customAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
