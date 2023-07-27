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
import dsk.altlombard.test.databinding.FragmentPledgeWorkingActiveOneLoanOperationsBinding;
import dsk.altlombard.test.dto.OperationRow;
import dsk.altlombard.test.dto.PledgeRow;
import dsk.altlombard.test.dto.ProductRow;

import java.util.ArrayList;
import java.util.List;

public class PledgeWorkingOneTicketActiveLoanOperationsFragment extends Fragment {

    private FragmentPledgeWorkingActiveOneLoanOperationsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPledgeWorkingActiveOneLoanOperationsBinding.inflate(inflater, container, false);
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

        //TODO реализация получения списка залогов
        List<ProductRow> products = new ArrayList<>();
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));
        products.add(new ProductRow("Браслет б/к ","9800,00р","1004,60р"));
        products.add(new ProductRow("Кольцо с/к","1560,00р","0,00р"));

        ListView simpleListView = view.findViewById(R.id.pledge_active_loan_operations);
        OperationRowAdapter customAdapter = new OperationRowAdapter(view.getContext(), products, "f");
        simpleListView.setAdapter(customAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
