package com.example.digdig.projectgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digdig.projectgridview.model.CustomNumberAdapter;
import com.example.digdig.projectgridview.model.FileNumberManagement;
import com.example.digdig.projectgridview.model.Operation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{

GridView gridViewOperation;
EditText editTextResult;
 TextView textviewresult;
Button btnscore;
ArrayList<Operation> listOfOperation;
ArrayList<String> listallOfOperation;
ArrayAdapter<Operation> adapterOperation;
CustomNumberAdapter customAdapterOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editTextResult = (EditText) findViewById(R.id.editText);
        gridViewOperation = (GridView) findViewById(R.id.gridViewNumbers);
        listOfOperation = FileNumberManagement.readFile(this,"operations.txt");
        listallOfOperation = new ArrayList<>();
        btnscore = (Button) findViewById(R.id.button);
        btnscore.setOnClickListener(this);
        textviewresult = (TextView) findViewById(R.id.TextViewScore);
        for(int i=0; i<listOfOperation.size();i++)
        {
            listallOfOperation.add(listOfOperation.get(i).getNumber());
            listallOfOperation.add(listOfOperation.get(i).getOperator());
            listallOfOperation.add(listOfOperation.get(i).getNumber2());
            listallOfOperation.add(listOfOperation.get(i).getSimbolEqual());
            listallOfOperation.add(listOfOperation.get(i).getUserResult());
            listallOfOperation.add(listOfOperation.get(i).getResult());
            //listallOfOperation.add(listOfOperation.get(i).goodResul(listOfOperation.get(i).getNumber(),listOfOperation.get(i).getOperator(),listOfOperation.get(i).getNumber2()));
        }
       // adapterOperation = new ArrayAdapter<Operation>(this,R.layout.one_element,listOfOperation);
        //gridViewOperation.setAdapter(adapterOperation);
        customAdapterOperation = new CustomNumberAdapter(this,listallOfOperation);
        gridViewOperation.setAdapter(customAdapterOperation);
        gridViewOperation.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int totalok=0;
        for(int i=0;i<listOfOperation.size();i++)
        {
            if(listOfOperation.get(i).getResult().equals("ok"))
            {
                totalok++;
            }

        }
        textviewresult.setText(String.valueOf(totalok*100/listOfOperation.size())+"%");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int collumNumber = (position % 6) + 1;
        int rowNumber = (position / 6);


            Operation noObj = listOfOperation.get(rowNumber);
            if (collumNumber==5) {
                if (!editTextResult.getText().toString().isEmpty()) {
                    listallOfOperation.set(position, editTextResult.getText().toString());
                    if (noObj.checkResult(editTextResult.getText().toString())) {
                        listallOfOperation.set(position+1, "ok");
                        noObj.setResult("ok");
                    }
                    else {
                        listallOfOperation.set(position+1, "bad");
                        noObj.setResult("bad");
                    }
                //listallOfOperation.set(position, String.valueOf(noObj.getUserResult()));
                   // listallOfOperation.set(position, String.valueOf(noObj.getResult()));
                customAdapterOperation.notifyDataSetChanged();
            }
            //}


        } else
        {
            Toast.makeText(this,"data are empty",Toast.LENGTH_LONG).show();
        }
    }
}
