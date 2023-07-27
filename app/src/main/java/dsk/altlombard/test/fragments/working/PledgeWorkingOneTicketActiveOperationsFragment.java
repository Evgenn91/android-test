package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.OperationRowAdapter;
import dsk.altlombard.test.databinding.FragmentPledgeWorkingActiveOneOperationsBinding;
import dsk.altlombard.test.dto.OperationRow;
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

        boolean result = getArguments().getBoolean("res");

        //изображение кнопки назад в верхнем тулбаре
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.topAppBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        if(result)
            toolbar.setTitle("Общая сумма погашений");
        else {
            toolbar.setTitle("");
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_working, new ToolTitle())
                    .commit();
        }

        //TODO реализация получения списка
        List<OperationRow> operations = new ArrayList<>();
        operations.add(new OperationRow("14.04.2023","832,00р","0,00р"));
        operations.add(new OperationRow("13.04.2023","1832,00р","345,30р"));
        operations.add(new OperationRow("14.06.2023","1532,20р","1040,50р"));
        operations.add(new OperationRow("23.02.2023","832,00р","134,00р"));
        operations.add(new OperationRow("16.01.2023","432,00р","2040,20р"));
        operations.add(new OperationRow("14.06.2023","1532,20р","1040,50р"));
        operations.add(new OperationRow("23.02.2023","832,00р","134,00р"));
        operations.add(new OperationRow("16.01.2023","432,00р","2040,20р"));
        operations.add(new OperationRow("14.06.2023","1532,20р","1040,50р"));
        operations.add(new OperationRow("23.02.2023","832,00р","134,00р"));
        operations.add(new OperationRow("16.01.2023","432,00р","2040,20р"));

        ListView simpleListView = view.findViewById(R.id.pledge_active_operations);
        OperationRowAdapter customAdapter = new OperationRowAdapter(view.getContext(), operations);
        simpleListView.setAdapter(customAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
