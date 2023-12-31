package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.FullPledgeRowAdapter;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingArchiveBinding;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingBinding;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class PledgeWorkingTicketArchiveFragment extends Fragment {

    private FragmentPledgeWorkingArchiveBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingArchiveBinding.inflate(inflater, container, false);
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

        ListView simpleListView = view.findViewById(R.id.full_archive_pledge_list);
        PledgeRowAdapter customAdapter = new PledgeRowAdapter(view.getContext(), pledges);
        simpleListView.setAdapter(customAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                System.out.println(pledges.get(pos));
                //todo вместе с таким переходом должна еше информация об объекте передаваться
                NavHostFragment.findNavController(PledgeWorkingTicketArchiveFragment.this).navigate(R.id.action_workingMainFragment_to_pledgeWorkingOneTicketArchiveFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
