package co.edu.uptc.servicesfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ProcessesFiles {

    private BufferedReader bufferedReader;
    private String fileName;
    private String charsetName;

    public ProcessesFiles(){
        this.charsetName="UTF-8";
    }

    public void setCharName(String charName){
        this.charsetName=charName;
    }

    public void setNameFile(String name){
        this.fileName=name;
    }

    public List<String> extraerString() throws Exception {
        this.openFile();
        List<String> list=this.readFile();
        this.closedFile();
        return list;
    }

    private void openFile() throws Exception{
        File file= new File(fileName);
        if (!file.exists()) {
            throw new Exception("El archivo no existe");
        }else{
            Reader reader = new InputStreamReader(new FileInputStream(file),this.charsetName);
            bufferedReader = new BufferedReader(reader);
        }
        
    }

    private List<String> readFile() throws Exception{
        String cont="";
        List<String> list = new ArrayList<String>();
        while ((cont=bufferedReader.readLine())!=null) {
            list.add(cont);
        }
        return list;
    }

    private void closedFile() throws Exception{
        if (bufferedReader!= null) {
            bufferedReader.close();
        }
    }

    public byte[] extraerStringByte() throws Exception {
        this.openFile();
        String cont="";
        String conteded="";
        while ((cont=bufferedReader.readLine())!=null) {
            conteded=conteded+cont;
        }
        byte[] bytes= conteded.getBytes();
        this.closedFile();
        return bytes;
    }

    // private List<String> changeBase64() {
    //     String base64="";
    //     for (String contentbase64 : content) {
    //         base64=base64+contentbase64;
    //     }
    //     byte[] bytesDecoded= Base64.getDecoder().decode(base64);
    //     String conteded=new String(bytesDecoded);
    //     List<String> list=content;
    //     return list;
    // }


}
