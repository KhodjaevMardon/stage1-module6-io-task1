package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            String content = new String(fileInputStream.readAllBytes());
            String[] splitByLines = content.split("\n");
            for (String line : splitByLines) {
                String[] splitBySemicolon = line.split(":");
                switch (splitBySemicolon[0]) {
                    case "Name":
                        profile.setName(splitBySemicolon[1].trim());
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(splitBySemicolon[1].trim()));
                        break;
                    case "Email":
                        profile.setEmail(splitBySemicolon[1].trim());
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(splitBySemicolon[1].trim()));
                        break;
                }
            }
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}
