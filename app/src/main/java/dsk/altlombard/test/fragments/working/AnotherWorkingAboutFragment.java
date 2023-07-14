package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingAboutBinding;

public class AnotherWorkingAboutFragment extends Fragment {
    private FragmentAnotherWorkingAboutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnotherWorkingAboutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //изображение кнопки назад в верхнем тулбаре
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.topAppBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);


    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
