package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class User {

    static List<UserDetails> list = new ArrayList<UserDetails>();

    public static void load(String filename)
    {
        Path path = Paths.get(filename);
        try {
            BufferedReader br = Files.newBufferedReader(path);
            br.readLine();
            String line = "";
            while((line = br.readLine()) !=null)
            {
                String[] p = line.trim().split(",");
                UserDetails userDetails = new UserDetails(p[0],p[1],p[2],p[3],p[4],p[5]);
                list.add(userDetails);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void store(String filename)
    {
        Path path = Paths.get(filename);
        try {
            BufferedWriter br = Files.newBufferedWriter(path);
            String p = "Username,Name,Password,Phone,Email,Address";
            br.write(p);
            br.newLine();

            for(int i=0;i<list.size();i++)
            {
                UserDetails userDetails = list.get(i);
                p = userDetails.getUsername()+","+userDetails.getName()+","+userDetails.getPassword()+","+userDetails.getPhone()+
                        ","+userDetails.getEmail()+","+userDetails.getAddress();
                br.write(p);
                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void add(UserDetails userDetails)
    {
        list.add(userDetails);
    }

    static boolean check(String username,String password)
    {
        for(int i=0;i<list.size();i++)
        {
            UserDetails userDetails = list.get(i);
            if(username.equals(userDetails.getUsername())&&password.equals(userDetails.getPassword())) {
                return true;
            }
        }
        return false;
    }

    static UserDetails get(String username)
    {
        for(int i=0;i<list.size();i++)
        {
            UserDetails userDetails = list.get(i);
            if(username.equals(userDetails.getUsername())) {
                return userDetails;
            }
        }
        return null;
    }
}
