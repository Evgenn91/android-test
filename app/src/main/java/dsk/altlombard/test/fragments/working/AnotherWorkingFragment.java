package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingBinding;

public class AnotherWorkingFragment extends Fragment {

    private FragmentAnotherWorkingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnotherWorkingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //MY CODE HERE
        binding.oneShortPledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(AnotherWorkingFragment.this)
                        .navigate(R.id.action_workingMainFragment_to_noticeWorkingAddressFragment);
            }
        });

        binding.oneShortPledge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO передача инф о текущем объекте
                NavHostFragment.findNavController(AnotherWorkingFragment.this)
                        .navigate(R.id.action_workingMainFragment_to_noticeWorkingAboutFragment);
            }
        });


    }

    //выход их приложения при нажатии кнопки "назад"
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().moveTaskToBack(true);
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
