package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.FullPledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingActiveBinding;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingBinding;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class PledgeWorkingTicketActiveFragment extends Fragment {

    private FragmentPledgeWorkingActiveBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingActiveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO реализация получения списка залогов(возможно передается при смене фрагмента)
        List<PledgeRow> pledges = new ArrayList<>();
        pledges.add(new PledgeRow("111111-111", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-112", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-113", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-114", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-115", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-116", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-117", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-118", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-116", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-117", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));
        pledges.add(new PledgeRow("111111-118", "10.03.2023","71,97р","11995,40р","0,20%","23,99р"));

        ListView simpleListView = view.findViewById(R.id.full_active_pledge_list);
        FullPledgeRowAdapter customAdapter = new FullPledgeRowAdapter(view.getContext(), pledges);
        simpleListView.setAdapter(customAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                System.out.println(pledges.get(pos));
                //todo вместе с таким переходом должна еше информация об объекте передаваться
                NavHostFragment.findNavController(PledgeWorkingTicketActiveFragment.this).navigate(R.id.action_workingMainFragment_to_pledgeWorkingOneTicketActiveFragment);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
