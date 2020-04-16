package donguyennhathan.com.hocsharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

import donguyennhathan.com.hocsharepreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String tenSharePreference="trangthai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void xuLyLuuTrangThai(View view) {
        SharedPreferences preferences= getSharedPreferences(tenSharePreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("b", true);
        editor.putFloat("f",15.8F);
        editor.putInt("i",1);
        editor.putLong("l", 2001);
        editor.putString("s","HelloWorld");
        Set<String> dsChuoi = new HashSet<>();
        dsChuoi.add("Hello");
        dsChuoi.add("World!");
        editor.putStringSet("dsChuoi", dsChuoi);
        editor.commit(); //Xác nhận lưu
    }

    public void xuLyDocTrangThai(View view) {
        SharedPreferences preferences= getSharedPreferences(tenSharePreference, MODE_PRIVATE);
        boolean b= preferences.getBoolean("b", false);
        Float f = preferences.getFloat("f", 0.0f);
        int i = preferences.getInt("i", 0);
        long l =preferences.getLong("l", 0l);
        String s = preferences.getString("s", "");
        Set<String> dsChuoi=preferences.getStringSet("dsChuoi", null);
        StringBuilder builder = new StringBuilder();
        for(String x: dsChuoi)
        {
            builder.append(x+"\t");
        }
        binding.txtTrangThai.setText("Boolean ="+b+"\n"+
                "Float ="+f+"\n"+
                "int ="+i+"\n"+
                "Long ="+l+"\n"+
                "String ="+s+"\n"+
                "Set ="+builder+"\n"
        );
    }
}
