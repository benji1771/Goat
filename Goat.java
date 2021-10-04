import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Goat {
    
    private ArrayList<File> filesToEat;
    private ArrayList<String> keywords = new ArrayList<String>();
    private String name;
    private final int MAX_DEFAULT_CAN_EAT = 10;
    private int maxCanEat;
    private int ate;
    private int level;
    

    public Goat(File folder){
        filesToEat = new ArrayList<File>();
        name = "Benjamin";
        maxCanEat = MAX_DEFAULT_CAN_EAT;
        ate = 0;
        level = 1;
        listFilesToEat(folder, filesToEat);
    }
    public Goat(File folder, File kw){
        filesToEat = new ArrayList<File>();
        name = "Benjamin";
        maxCanEat = MAX_DEFAULT_CAN_EAT;
        ate = 0;
        level = 1;
        getKeywords(kw);
        listFilesToEat(folder, filesToEat);
        narrowToKeyWords();
    }
    public Goat(String n, File folder){
        filesToEat = new ArrayList<File>();
        name = n;
        level = 1;
        maxCanEat = MAX_DEFAULT_CAN_EAT;
        ate = 0;
        listFilesToEat(folder, filesToEat);
    }
    public Goat(String n, File folder, File kw){
        filesToEat = new ArrayList<File>();
        name = n;
        level = 1;
        maxCanEat = MAX_DEFAULT_CAN_EAT;
        ate = 0;
        getKeywords(kw);
        listFilesToEat(folder, filesToEat);
        narrowToKeyWords();
    }

    public Goat(String n, int max, File folder){
        filesToEat = new ArrayList<File>();
        name = n;
        level = 1;
        maxCanEat = max;
        ate = 0;
        listFilesToEat(folder, filesToEat);
    }
    public Goat(String n, int max, File folder, File kw){
        filesToEat = new ArrayList<File>();
        name = n;
        level = 1;
        maxCanEat = max;
        ate = 0;
        getKeywords(kw);
        listFilesToEat(folder, filesToEat);
        narrowToKeyWords();
    }


    private void narrowToKeyWords(){
        String tempFName;
        String tempKeyName;
        boolean check = false;
        for(File f: filesToEat){
            tempFName = f.getName().toLowerCase();
            for(String keys: keywords){         
                tempKeyName = keys.toLowerCase();
                if(tempFName.contains(tempKeyName)){
                    check = true;
                }
            }
            if(!check){
                filesToEat.remove(f);
            }
            check = false;
        }
    }
    private void getKeywords(File file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String key = br.readLine();
            while(key != null){
                keywords.add(key);
                key = br.readLine();
            }
            if(br != null){
                br.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Keywords file is missing");
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        
    }
    
    public boolean isFull(){
        if(ate == maxCanEat){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return name;
    }
    public void burp(){
        if(ate == maxCanEat){
            maxCanEat+=10;
        }
        level++;
        ate = 0;
    }
    public int getLevel(){
        return level;
    }
    public void listFilesToEat(File folder, List<File> file){
        for(File f : folder.listFiles()){
            if(f.isDirectory()){
                listFilesToEat(f, file);
            } else {
                file.add(f);
            }
        }
        

    }

    public void setMaxCanEat(int n){
        maxCanEat = n;
    }

    public void eat(){
        if(filesToEat.isEmpty()){
            System.out.println("No Files to Delete");
            return;
        }
        Collections.shuffle(filesToEat);
        if(isFull()){
            System.out.println("I'm Full");
            return;
        }
        filesToEat.get(0).delete();
        filesToEat.remove(0);
        ate++;
    }
    public void eat(int n){
        if(filesToEat.isEmpty()){
            System.out.println("No Files to Delete");
            return;
        }
        Collections.shuffle(filesToEat);
        for(int i = 0; i < n; i++){
            if(filesToEat.isEmpty()){
                System.out.println("No Files to Delete");
                return;
            }
            if(isFull()){
                System.out.println("I'm Full");
                return;
            }
            filesToEat.get(0).delete();
            filesToEat.remove(0);
            ate++;
            
        }
    }

    public void eatTillFull(){
        if(filesToEat.isEmpty()){
            System.out.println("No Files to Delete");
            return;
        }
        Collections.shuffle(filesToEat);
        while(!isFull()){
            if(filesToEat.isEmpty()){
                System.out.println("No Files to Delete");
                return;
            }
            filesToEat.get(0).delete();
            filesToEat.remove(0);
        }
    }

}
