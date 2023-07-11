package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingActiveOneBinding;
import dsk.altlombard.test.fragments.WorkingMainFragment;
import dsk.altlombard.test.fragments.entering.CodeEnteringFragment;

public class PledgeWorkingOneTicketActiveFragment extends Fragment {
    private FragmentPledgeWorkingActiveOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingActiveOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.layoutPledgeWorkAllOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(PledgeWorkingOneTicketActiveFragment.this).navigate(R.id.action_pledgeWorkingOneTicketActiveFragment_to_pledgeWorkingOneTicketActiveOperationsFragment);
            }
        });

        binding.layoutPledgeWorkLoanOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(PledgeWorkingOneTicketActiveFragment.this).navigate(R.id.action_pledgeWorkingOneTicketActiveFragment_to_pledgeWorkingOneTicketActiveLoanOperationsFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
