package sg.edu.rp.c346.id20002288.billplease;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

EditText editamt;
EditText editpax;
EditText editdisc;
ToggleButton tbsvc;
ToggleButton tbgst;
RadioGroup rggender;
RadioButton rbcash;
RadioButton rbpn;
Button btnsplit;
Button btnreset;
TextView finalstring;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

editamt = findViewById(R.id.editamt);
editpax = findViewById(R.id.editpax);
editdisc = findViewById(R.id.editdisc);
tbsvc = findViewById(R.id.tbsvc);
tbgst =  findViewById(R.id.tbgst);
rggender = findViewById(R.id.rggender);
rbcash = findViewById(R.id.rbcash);
rbpn =findViewById(R.id.rbpn);
btnsplit = findViewById(R.id.btnsplit);
btnreset = findViewById(R.id.btnreset);
finalstring = findViewById(R.id.finalstring);



String numpax = editpax.getText().toString();
String numamt = editamt.getText().toString();
String disc = editdisc.getText().toString();

if(numamt.length() > 0 && numpax.length() > 0){
    double newamt =0.0;
    String stringamt = editamt.getText().toString();

    if(tbsvc.isChecked()==false && tbgst.isChecked()==false){
        newamt = Double.parseDouble(stringamt);
        if(disc.length()>0){
            newamt=Double.parseDouble(stringamt)*Double.parseDouble(disc);
    }
    else if(tbsvc.isChecked()==false && tbgst.isChecked()==true){
        newamt = Double.parseDouble(stringamt)*1.1;
            if(disc.length()>0){
                newamt=Double.parseDouble(stringamt)*Double.parseDouble(disc);
            }
    }
    else if(tbsvc.isChecked()==true && tbgst.isChecked()==false){
        newamt = Double.parseDouble(stringamt)*1.07;
            if(disc.length()>0){
                newamt=Double.parseDouble(stringamt)*Double.parseDouble(disc);
            }
    }
    else{
        newamt = Double.parseDouble(stringamt)*1.17;
            if(disc.length()>0){
                newamt=Double.parseDouble(stringamt)*Double.parseDouble(disc);
            }
    }
}
btnsplit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String output = "";
        stringamt=newamt.getText().toString();
        String output = finalstring.getText().toString();
if(rggender.getCheckedRadioButtonId()==R.id.rbpn){
    double indipay = doubleamt/intpax;
output ="Total bill : $"+ stringamt + "Each pay " + indipay +" Via paynow to 97931669";}
    else{
    output ="Total bill : $"+ stringamt;}

    }
finalstring.setText(output);

});
    }
    }}