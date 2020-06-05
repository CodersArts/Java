package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserDetails {

    private String username;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private List<String> total;

    public UserDetails(String username, String name, String password, String phone, String email, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        total = new ArrayList<String>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getTotal() {
        return total;
    }

    public void setTotal(List<String> total) {
        this.total = total;
    }

    public void load(String filename)
    {
        Path path = Paths.get(filename);
        try {
            BufferedReader br = Files.newBufferedReader(path);
            br.readLine();
            String line = "";
            while((line = br.readLine()) !=null)
            {
                total.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void store(String filename)
    {
        Path path = Paths.get(filename);
        try {
            BufferedWriter br = Files.newBufferedWriter(path);
            String p = "Calorie,Fat,Carbohydrate,Protein";
            br.write(p);
            br.newLine();

            for(int i=0;i<total.size();i++)
            {
                String str = total.get(i);
                br.write(str);
                br.newLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
