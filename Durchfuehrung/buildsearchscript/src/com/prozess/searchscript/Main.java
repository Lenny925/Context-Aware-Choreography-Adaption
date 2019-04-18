package com.prozess.searchscript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String queryFile = System.getProperty("user.dir") + "\\queries.txt";
        File file = new File(queryFile);
        file.delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(queryFile , true));
        for (int i = 0; i < getFirstBlock().size(); i++) {
            String string1 = getFirstBlock().get(i);

            for ( int j = 0 ; j < getSecondBlock().size(); j++) {
                String string2 = getSecondBlock().get(j);
                for ( int k = 0 ; k < getThirdBlock().size(); k++) {
                    String string3 = getThirdBlock().get(k);
                    writer.write(string1 + " AND " +  string2 +  " AND " +  string3 +"\n");
                }
            }


        }

        writer.close();

    }

    public static List<String> getFirstBlock() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("context-aware");
        strings.add("context aware");

        strings.add("context specific");
        strings.add("context-specific");

        strings.add("context-dependent");
        strings.add("context dependent");

        strings.add("context-sensitive");
        strings.add("context sensitive");

        strings.add("situation aware");
        strings.add("situation-aware");
        return strings;
    }

    public static List<String> getSecondBlock() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("choreography" );
        strings.add("decentralized composition" );
        strings.add("decentralized service composition");
        strings.add("distributed composition");
        return strings;
    }

    public static List<String> getThirdBlock() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("adapt*");
        strings.add("self-config*");
        strings.add("auto-config*");
        strings.add("reconfig*");
        strings.add("sensitiv");
        strings.add("behaviour");
        return strings;
    }
}
