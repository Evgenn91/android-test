package dsk.altlombard.test.fragments.working;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.adapter.AnotherAddressRowAdapter;
import dsk.altlombard.test.adapter.PledgeRowAdapter;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingAddressBinding;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingBinding;
import dsk.altlombard.test.dto.Address;
import dsk.altlombard.test.dto.PledgeRow;

import java.util.ArrayList;
import java.util.List;

public class AnotherWorkingAddressFragment extends Fragment {

    private FragmentAnotherWorkingAddressBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnotherWorkingAddressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //изображение кнопки назад в верхнем тулбаре
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.topAppBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        //MY CODE HERE
//        //TODO реализация получения списка залогов
        List<Address> addresses = new ArrayList<>();
        ListView simpleListView = view.findViewById(R.id.main_active_pledge_list1);

        String[] spinnerList = new String[]{"Екатеринбург","Нижний Тагил","Ревда","Челябинск","Пермь"};

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                if(item.equals("Екатеринбург")){
                    addresses.clear();
                    addresses.add(new Address("Екатеринбург", "Проспек Ленина, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Екатеринбург", "Победы, 11","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Екатеринбург", "8 Марта, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                } else if(item.equals("Нижний Тагил")){
                    addresses.clear();
                    addresses.add(new Address("Нижний Тагил", "Бакинских коммисаров, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Нижний Тагил", "Санаторная, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                } else if(item.equals("Ревда")){
                    addresses.clear();
                    addresses.add(new Address("Ревда", "Розы Люксенбург, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Ревда", "Восточная, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Ревда", "Восточная, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                } else if(item.equals("Челябинск")){
                    addresses.clear();
                    addresses.add(new Address("Челябинск", "Проспект Космонавтов, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Челябинск", "Лучистая, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                } else if(item.equals("Пермь")){
                    addresses.clear();
                    addresses.add(new Address("Пермь", "Ломоносова, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Пермь", "Московская, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Пермь", "Московская, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Пермь", "Московская, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                    addresses.add(new Address("Пермь", "Московская, 36","Ежедневно с 10:00 до 20:00\n" + "Обед c 14:00 до 14:30"));
                } else {
                    addresses.clear();
                }
                AnotherAddressRowAdapter customAdapter = new AnotherAddressRowAdapter(view.getContext(), addresses);
                simpleListView.setAdapter(customAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
