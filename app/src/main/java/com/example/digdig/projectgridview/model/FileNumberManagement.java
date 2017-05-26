package com.example.digdig.projectgridview.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by digdig on 17-05-18.
 */

public class FileNumberManagement {
    public static ArrayList<Operation> readFile(Context context, String fileName)
    {
        ArrayList<Operation> listOfOperations = new ArrayList<Operation>();


        AssetManager assetManager = context.getResources().getAssets();

        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));

            BufferedReader br = new BufferedReader(isr);
            String oneLine;
            while ((oneLine=br.readLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(oneLine,",");

                while (st.hasMoreTokens())
                {

                    String number1 = st.nextToken();
                    String operation = st.nextToken();
                    String number2 = st.nextToken();

                    String symbol = st.nextToken();
                    String resultUser = st.nextToken();

                    Operation nbObj = new Operation(number1,operation,number2,symbol,resultUser);
                    listOfOperations.add(nbObj);
                }


            }

            br.close();
            isr.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return  listOfOperations;

    }
}
