

import java.util.*;

public class Test {

    static int EMBED_DIM = 64;
    static Map<String , Integer> vacob= new HashMap<>();  

    static double[][] embedding;
    public static void main(String[] args) {

        String[] data = {"car" , "bike" , "bus"};

        int index = 0;
        for(String word:data){
            if(!vacob.containsKey(word)){
                vacob.put(word, index++);
            }
        }

        int vacobSize = vacob.size();
        embedding = new double[vacobSize][EMBED_DIM];

        Random rng = new Random();


        for(int i=0; i<vacobSize; i++){
            for(int j=0; j<EMBED_DIM; j++){
                embedding[i][j] = rng.nextGaussian() * 0.1;
            }
        }

        String sentence = "car bike";

        double[] vec = vactorize(sentence);

        for(int i=0; i<vec.length; i++){
            System.out.print("vec: "+vec[i]+" ");
        }
        
    }

    static double[] vactorize(String sentence){
    
        double[] vec = new double[EMBED_DIM];
        String[] word = sentence.split(" ");

        for(String w:word){
            if(vacob.containsKey(w)){
                int idx = vacob.get(w);
                for(int i=0; i<EMBED_DIM; i++){
                    vec[i] += embedding[idx][i];
                }
            }

        }
        return vec;
    }
}