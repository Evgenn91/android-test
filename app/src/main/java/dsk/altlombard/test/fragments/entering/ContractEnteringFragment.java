package dsk.altlombard.test.fragments.entering;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.textfield.TextInputLayout;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentContractEnteringBinding;


public class ContractEnteringFragment extends Fragment {

    private FragmentContractEnteringBinding binding;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContractEnteringBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputLayout contractNumberEdit = view.findViewById(R.id.enter_authorization_contract);

        SharedPreferences registrationEntity = this.getActivity().getSharedPreferences("registration", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = registrationEntity.edit();

        binding.buttonAuthorizationContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO последовательночть действий:
                //1. запрос на сервер(на сервере - находим номер телефона по договору; - генерируем пароль; - оправляем пароль(смс на телефон и обратно в мобил прил);)
                //2. получили сгененированный пароль для авторизации  с сервера(+ получили globalGUID клиента!!!) - сохранение smsкода в телефоне
                                                                              //+ сохранение номера договора в телефоне(чтобы на следующем этапе повторно отправить смс код пользователю)
                                                                               //+ сохранение globalGUID в телефоне

                String contractNumber = contractNumberEdit.getEditText().getText().toString();;
                String smsCode = "";
                String globalGUID = "";


                //ЗАПРОС НА СЕРВЕР с contractNumber
                //smsCode = результат с сервера;
                //globalGUID = результат с сервера;


                myEdit.putString("contractNumber", String.valueOf(contractNumber));
                myEdit.putString("globalGUID", String.valueOf(contractNumber));
                myEdit.putString("smsCode", String.valueOf(smsCode));
                myEdit.commit();

                NavHostFragment.findNavController(ContractEnteringFragment.this).navigate(R.id.action_contractEnteringFragment_to_smsCodeEnteringFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
