package org.tarik.numberfacts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.tarik.numberfacts.databinding.FragmentMainBinding;
import org.tarik.numberfacts.retrofit.MainResponse;
import org.tarik.numberfacts.retrofit.NumbersRetrofit;
import org.tarik.numberfacts.retrofit.NumbersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private static final String BUNDLE_TYPE = "BUNDLE_TYPE";
    public static final String TYPE_TRIVIA = "trivia";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_YEAR = "year";
    public static final String TYPE_MATH = "math";

    private String type;
    private NumbersService numbersService;

    public static MainFragment getInstance(String type) {
        MainFragment fragment = new MainFragment();

        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            type = arguments.getString(BUNDLE_TYPE);
        }

        numbersService = NumbersRetrofit.getRetrofitInstance().create(NumbersService.class);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (type != null) {
            if (type.equals(TYPE_TRIVIA)) {
                binding.titleTextView.setText(R.string.trivia_question_label);

                binding.askQuestionButton.setOnClickListener(v -> {
                    Log.d("historia", "clck");
                    numbersService.getTriviaAnswer().enqueue(new Callback<MainResponse>() {
                        @Override
                        public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                            Log.d("historia", "onResponse: " + response);
                            Toast.makeText(requireContext(), "response", Toast.LENGTH_SHORT).show();
                            if (response.isSuccessful()) {
                                MainResponse mainResponse = response.body();
                                if (mainResponse != null) {
                                    binding.answerTextView.setText(mainResponse.text);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<MainResponse> call, Throwable t) {
                            Toast.makeText(requireContext(), "failure", Toast.LENGTH_SHORT).show();
                        }
                    });

                });

            } else if (type.equals(TYPE_DATE)) {
                binding.titleTextView.setText(R.string.date_question_label);
            } else if (type.equals(TYPE_MATH)) {
                binding.titleTextView.setText(R.string.math_question_label);
            } else if (type.equals(TYPE_YEAR)) {
                binding.titleTextView.setText(R.string.year_question_label);
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
