package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

        //изображение кнопки назад в верхнем тулбаре
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.topAppBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("");

        binding.layoutPledgeWorkAllOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                Bundle dates = new Bundle();
                dates.putBoolean("res", false);
                NavHostFragment.findNavController(PledgeWorkingOneTicketActiveFragment.this).navigate(R.id.action_pledgeWorkingOneTicketActiveFragment_to_pledgeWorkingOneTicketActiveOperationsFragment, dates);
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
