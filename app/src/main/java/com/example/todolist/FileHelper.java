package com.example.todolist;

import android.content.Context;
import android.os.Build;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper
{

    public static final String FILENAME = "listinfo.dat";


    public static void writeData(ArrayList<String> itemsList, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            try
            {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(itemsList);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemsList = new ArrayList<String>();

        try
        {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<String>) ois.readObject();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
