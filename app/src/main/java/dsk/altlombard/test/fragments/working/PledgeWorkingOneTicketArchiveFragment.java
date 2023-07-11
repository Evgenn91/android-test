package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingArchiveOneBinding;

public class PledgeWorkingOneTicketArchiveFragment extends Fragment {
    private FragmentPledgeWorkingArchiveOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingArchiveOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //CoDe
        binding.layoutPledgeWorkAllOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(PledgeWorkingOneTicketArchiveFragment.this).navigate(R.id.action_pledgeWorkingOneTicketArchiveFragment_to_pledgeWorkingOneTicketActiveOperationsFragment);
            }
        });

        binding.layoutPledgeWorkLoanOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(PledgeWorkingOneTicketArchiveFragment.this).navigate(R.id.action_pledgeWorkingOneTicketArchiveFragment_to_pledgeWorkingOneTicketActiveLoanOperationsFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
