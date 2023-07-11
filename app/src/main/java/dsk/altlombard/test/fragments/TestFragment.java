package dsk.altlombard.test.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentWaitingMainBinding;

public class TestFragment extends Fragment {

    private FragmentWaitingMainBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentWaitingMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //сохранение данных на телефон
                  //создание 'типа' созраняемых данные
        SharedPreferences limits = this.getActivity().getSharedPreferences("limits", Context.MODE_PRIVATE);
                  //сохранение параметра
        SharedPreferences.Editor myEdit = limits.edit();
        myEdit.putString("up", String.valueOf("мой параметр для сохранения"));
        myEdit.commit();
                 //получение параметра
        String ressss = limits.getString("up","");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
